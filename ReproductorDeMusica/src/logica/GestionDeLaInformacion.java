package logica;

import java.io.File;
import java.util.ArrayList;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import controlador.GestionBD;
import interfaces.InterfazGestionBD;
import interfaces.InterfazGestionDeLaInformacion;
import modelo.Album;
import modelo.Cancion;
import modelo.Cliente;
import modelo.Musico;
import modelo.PlayList;
import modelo.Podcast;
import modelo.Podcaster;

public class GestionDeLaInformacion implements InterfazGestionDeLaInformacion {

	private InterfazGestionBD gestionBD;
	private GestionFicheros gestionFI;
	private Cliente cliente;
	private Musico musico;
	private ArrayList<Musico> musicos;
	private Album album;
	private ArrayList<Album> albums;
	private Cancion cancion;
	private ArrayList<Cancion> canciones;
	private ArrayList<Podcaster> podcasters;
	private PlayList playList;
	private ArrayList<PlayList> playlists;
	private Podcaster podcaster;
	private ArrayList<Podcast> podcasts;

	public GestionDeLaInformacion() {
		gestionBD = new GestionBD();
		gestionFI = new GestionFicheros();
	}

	@Override
	public void limpiar() {
		musico = new Musico();
		musicos = new ArrayList<Musico>();
		album = new Album();
		albums = new ArrayList<Album>();
		canciones = new ArrayList<Cancion>();
		podcasters = new ArrayList<Podcaster>();
		playList = new PlayList();
		playlists = new ArrayList<PlayList>();

	}

	@Override
	public boolean testUsuarioYContraseña(String usuario, String contraseña) {
		boolean login = false;
		login = gestionBD.login(usuario, contraseña);
		return login;
	}

	@Override
	public boolean recogerInformacionFormulario(String fecha) {
		boolean opcion = true;
		/**
		 * Regex para que en el panel de registro toda la informacion se introduzca
		 * correctamente
		 */
		Pattern patron1 = Pattern.compile("^\\d{4}([\\-/.])(0?[1-9]|1[1-2])\\1(3[01]|[12][0-9]|0?[1-9])$");
		Matcher pass = patron1.matcher(fecha);

		if (!pass.find()) {
			opcion = false;
		}

		return opcion;
	}

	@Override
	public boolean validarExistenciaEnLaBaseDeDatos(String usuario) {
		boolean correcto = false;
		correcto = gestionBD.verificarUsuario(usuario);
		return correcto;
	}

	/**
	 * Metodo para devolver un string con el nombre y apellidos del cliente
	 * 
	 * @return String con el nombre y apellido del cliente
	 */
	@Override
	public void guardarUsuario(String usuario) {
		this.cliente = new Cliente();
		this.cliente = gestionBD.pedirUsuario(usuario);

	}

	@Override
	public Cliente devolverUsuario() {

		return this.cliente;
	}

	@Override
	public boolean insertarUsuario(Cliente insertar) {
		gestionBD.insertUsuario(insertar);
		return true;
	}

	/**
	 * Metodos para la gestion de musicos
	 * 
	 * @param musico
	 */
	@Override
	public void guardarMusico(Musico musico) {
		this.musico = new Musico();
		this.musico = musico;
	}

	@Override
	public Musico devolverMusico() {
		return this.musico;
	}

	@Override
	public ArrayList<Musico> devolverMusicos() {
		return this.musicos;
	}

	@Override
	public void recogerMusicosDeLaBaseDeDatos() {
		musicos = gestionBD.llenarListaMusico();
	}

	/**
	 * Metodos para la gestion de albums
	 * 
	 * @param album
	 */

	@Override
	public void guardarAlbum(Album album) {
		this.album = new Album();
		this.album = album;
	}

	@Override
	public Album devolverAlbum() {
		return this.album;
	}

	@Override
	public ArrayList<Album> devolverAlbums() {
		return this.albums;
	}

	@Override
	public void recogerAlbumsDeLaBaseDeDatos() {
		this.albums = gestionBD.llenarListaDeAlbums(this.musico);
	}

	/**
	 * Metodos para la gestion de canciones
	 * 
	 * @param album
	 */

	@Override
	public void guardarCancion(Cancion cancion) {
		this.cancion = cancion;
	}

	@Override
	public Cancion devolverCancion() {
		return this.cancion;
	}

	@Override
	public ArrayList<Cancion> devolverCanciones() {
		return this.canciones;
	}

	@Override
	public void recogerCancionesDeLaBaseDeDatos() {
		if (playList.getIDList() != null) {
			this.canciones = new ArrayList<Cancion>();
			this.canciones = gestionBD.llenarListaDeCancionesPorPlayList(this.playList);
		} else {
			this.canciones = new ArrayList<Cancion>();
			this.canciones = gestionBD.llenarListaDeCanciones(this.album);
		}
	}

	@Override
	public void recogerCancionesDeLaBaseDeDatosConAudio() {
		if (playList.getIDList() != null) {
			this.canciones = new ArrayList<Cancion>();
			this.canciones = gestionBD.llenarListaDeCancionesConAudioPorPlayList(this.playList);
		} else {
			this.canciones = new ArrayList<Cancion>();
			this.canciones = gestionBD.llenarListaDeCancionesConAudio(this.album);
		}
	}

	@Override
	public void borrarAudiosDelSistema() {
		File directory = new File("./canciones");
		
		try {
			for (File file : Objects.requireNonNull(directory.listFiles())) {
				if (!file.isDirectory()) {
					file.delete();
				}
			}
		} catch (NullPointerException e) {
		}
		
	}

	@Override
	public ArrayList<Cancion> recogerAnunciosDeLaBaseDeDatosConAudio() {
		return gestionBD.buscarAnuncios();
	}

	/**
	 * Metodos para sacar playlists
	 */
	@Override
	public void guardarPlayList(PlayList playList) {
		this.playList = new PlayList();
		this.playList = playList;
	}

	@Override
	public PlayList devolverPlayList() {
		return this.playList;
	}

	@Override
	public ArrayList<PlayList> devolverPlayLists() {
		return this.playlists;
	}

	@Override
	public void recogerPlayListsDeLaBaseDeDatos() {
		this.playlists = gestionBD.llenarListaDePlaylists(this.cliente);
	}

	@Override
	public int cantidadDePlayList() {
		return gestionBD.contarPlayList(cliente);
	}

	@Override
	public int cantidadDeCancionesEnPlayList() {
		return gestionBD.contarCantidadDeCancionEnPlayList(playList);
	}

	@Override
	public void crearPlayList(String nombre) {
		gestionBD.crearPlayList(nombre, cliente);
	}

	@Override
	public void borrarPlayList(PlayList playList) {
		gestionBD.borrarPlayList(playList);
		gestionBD.borrarCancionesDePlayList(playList);
	}

	@Override
	public void borrarPlayListAdmin(PlayList playList) {
		gestionBD.borrarCancionesDePlayList(playList);
	}

	/**
	 * Funciones del panel De adminstración
	 * 
	 * @param nombre
	 * @param id
	 * @param desc
	 * @param tipo
	 * @return
	 */
	@Override
	public boolean editarArtistaAdministrador(String nombre, String id, String desc, String tipo) {
		gestionBD.editarArtistaAdministrador(nombre, id, desc, tipo);
		return true;
	}

	@Override
	public boolean eliminarCancionAdministrador(String id) {
		gestionBD.eliminarCancionAdministrador(id);
		return true;
	}



	@Override
	public boolean eliminarArtistaAdministrador(String id) {
		gestionBD.eliminarArtistaAdministrador(id);
		return true;
	}

	@Override
	public boolean eliminarAlbumAdministrador(String id) {
		gestionBD.eliminarAlbumAdministrador(id);
		return true;
	}


	@Override
	public boolean añadirMusicoABaseDeDatos(String nombre, String desc, String tipo) {
		gestionBD.insertNuevoMusico(nombre, desc, tipo);

		return true;

	}

	/**
	 * Metodo para recoger llenarListaPodcast de GestionBD
	 * 
	 * @return
	 */
//	public void recogerPodcastDeLaBaseDeDatos(String id) {
//		podcasts = gestionBD.llenarListaPodcast();
//	}
	
	@Override
	public void guardarPodcaster(Podcaster p) {
		 this.podcaster = p;
	}
	
	@Override
	public Podcaster devolverPodcaster() {
		return this.podcaster;
	}
	
	@Override
	public ArrayList<Podcaster> devolverPodcasters() {
		return this.podcasters;
	}

	@Override
	public void recogerPodcastersDeLaBaseDeDatos() {
		podcasters = gestionBD.llenarListaPodcaster();
	}
	
	@Override
	public ArrayList<Podcast> devolverPodcasts() {
		return this.podcasts;
	}

	@Override
	public void recogerPodcastsDeLaBaseDeDatos() {
		this.podcasts = new ArrayList<Podcast>();
		this.podcasts = gestionBD.llenarListaDePodcasts(this.podcaster);
	}

	@Override
	public void recogerPodcastsDeLaBaseDeDatosConAudio() {
		this.podcasts = new ArrayList<Podcast>();
		this.podcasts = gestionBD.llenarListaDePodcastsConAudio(this.podcaster);

	}

	@Override
	public boolean editarAlbumAdministrador(String id, String nombre, String año, String genero) {
		gestionBD.editarAlbumAdministrador(id, nombre, año, genero);
		
		return true;
	}
	@Override
	public boolean editarCancionAdministrador(String ldAudio, String textidcancion, String nombreAudio, String textduracion,String  Idalbum) {
		gestionBD.editarCancionesAdministrador(ldAudio, textidcancion, nombreAudio, textduracion,Idalbum);
		
		return true;
	}
	@Override
	public void recogerAlbumsDeLaBaseDeDatosAdmin() {
		albums = new ArrayList<Album>();
		this.albums = gestionBD.llenarListaDeAlbumsAdmin();
	}

	@Override
	public boolean añadirAlbumABaseDeDatos(String nombre, String desc, String tipo) {
		gestionBD.insertNuevoMusico(nombre, desc, tipo);

		return true;

	}

	@Override
	public void recogerCancionesDeLaBaseDeDatosAdmin() {
		canciones = new ArrayList<Cancion>();
		this.canciones = gestionBD.llenarListaDeCancionesAdmin();
	}

	// Metodos de gestion de archivos
	@Override
	public void escribirFichero() {
		gestionFI.escribirFichero(canciones, playList.getTitulo());
	}

	@Override
	public void insertarFichero(File fichero) {
		canciones = gestionFI.leerFichero(fichero);
	}

	@Override
	public void insertarCacionesEnPlayList() {
		if (cliente.getPremium().equalsIgnoreCase("Free") && cantidadDeCancionesEnPlayList() < 3) {
			for (int i = 0; i < 3 - cantidadDeCancionesEnPlayList(); i++) {
				gestionBD.insertarCancionesEnPlayList(playList.getIDList(), canciones.get(i).getIdCancion());
			}
		} else {
			for (int i = 0; i < canciones.size(); i++) {
				gestionBD.insertarCancionesEnPlayList(playList.getIDList(), canciones.get(i).getIdCancion());
			}
		}
	}

	@Override
	public void nuevaPlayList(String nombre) {
		crearPlayList(nombre);
		ArrayList<PlayList> pl = gestionBD.llenarListaDePlaylists(this.cliente);
		for (int i = 0; i < pl.size(); i++) {
			if (pl.get(i).getTitulo().equalsIgnoreCase(nombre)) {
				System.out.println(pl.get(i).getTitulo());
				guardarPlayList(pl.get(i));
				insertarCacionesEnPlayList();
			}
		}
	}

	@Override
	public void insertarCacionEnPlayList(Cancion cancion) {
		recogerPlayListsDeLaBaseDeDatos();
		if (cliente.getPremium().equalsIgnoreCase("Free") && cantidadDeCancionesEnPlayList() >= 3) {
			JOptionPane.showMessageDialog(null, "No se pueden guardar en favoritos mas de 3 canciones");
		} else {
			gestionBD.insertarCancionesEnPlayList(playlists.get(0).getIDList(), cancion.getIdCancion());
		}
	}

}
