package logica;

import java.io.File;
import java.util.ArrayList;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import controlador.GestionBD;
import modelo.Album;
import modelo.Cancion;
import modelo.Cliente;
import modelo.Musico;
import modelo.Podcaster;
import modelo.PlayList;

public class GestionDeLaInformacion {

	private GestionBD gestionBD;
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

	public GestionDeLaInformacion() {
		gestionBD = new GestionBD();
		gestionFI = new GestionFicheros();
	}
	
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

	public boolean testUsuarioYContraseña(String usuario, String contraseña) {
		boolean login = false;
		login = gestionBD.Login(usuario, contraseña);
		return login;
	}

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
	public void guardarUsuario(String usuario) {
		this.cliente = new Cliente();
		this.cliente = gestionBD.pedirUsuario(usuario);

	}

	public Cliente devolverUsuario() {

		return this.cliente;
	}

	public boolean insertarUsuario(Cliente insertar) {
		gestionBD.insertUsuario(insertar);
		return true;
	}

	/**
	 * Metodos para la gestion de musicos
	 * 
	 * @param musico
	 */
	public void guardarMusico(Musico musico) {
		this.musico = new Musico();
		this.musico = musico;
	}

	public Musico devolverMusico() {
		return this.musico;
	}

	public ArrayList<Musico> devolverMusicos() {
		return this.musicos;
	}

	public void recogerMusicosDeLaBaseDeDatos() {
		musicos = gestionBD.llenarListaMusico();
	}

	/**
	 * Metodos para la gestion de albums
	 * 
	 * @param album
	 */

	public void guardarAlbum(Album album) {
		this.album = new Album();
		this.album = album;
	}

	public Album devolverAlbum() {
		return this.album;
	}

	public ArrayList<Album> devolverAlbums() {
		return this.albums;
	}

	public void recogerAlbumsDeLaBaseDeDatos() {
		this.albums = gestionBD.llenarListaDeAlbums(this.musico);
	}

	/**
	 * Metodos para la gestion de canciones
	 * 
	 * @param album
	 */

	public void guardarCancion(Cancion cancion) {
		this.cancion = cancion;
	}

	public Cancion devolverCancion() {
		return this.cancion;
	}

	public ArrayList<Cancion> devolverCanciones() {
		return this.canciones;
	}

	public void recogerCancionesDeLaBaseDeDatos() {
		if (playList.getIDList() != null) {
			this.canciones = new ArrayList<Cancion>();
			this.canciones = gestionBD.llenarListaDeCancionesPorPlayList(this.playList);
		} else {
			this.canciones = new ArrayList<Cancion>();
			this.canciones = gestionBD.llenarListaDeCanciones(this.album);
		}
	}

	public void recogerCancionesDeLaBaseDeDatosConAudio() {
		if (playList.getIDList() != null) {
			this.canciones = new ArrayList<Cancion>();
			this.canciones = gestionBD.llenarListaDeCancionesConAudioPorPlayList(this.playList);
		} else {
			this.canciones = new ArrayList<Cancion>();
			this.canciones = gestionBD.llenarListaDeCancionesConAudio(this.album);
		}
	}

	
	public void borrarAudiosDelSistema() {
		File directory = new File("./canciones");
		 
        for (File file: Objects.requireNonNull(directory.listFiles())) {
            if (!file.isDirectory()) {
                file.delete();
        }
       }
	}

	public ArrayList<Cancion> recogerAnunciosDeLaBaseDeDatosConAudio() {
		return gestionBD.buscarAnuncios();
	}

	/**
	 * Metodos para sacar playlists
	 */
	public void guardarPlayList(PlayList playList) {
		this.playList = new PlayList();
		this.playList = playList;
	}

	public PlayList devolverPlayList() {
		return this.playList;
	}

	public ArrayList<PlayList> devolverPlayLists() {
		return this.playlists;
	}

	public void recogerPlayListsDeLaBaseDeDatos() {
		this.playlists = gestionBD.llenarListaDePlaylists(this.cliente);
	}
	
	public int cantidadDePlayList() {
		return gestionBD.contarPlayList(cliente);
	}
	
	public int cantidadDeCancionesEnPlayList(PlayList p) {
		return gestionBD.contarCantidadDeCancionEnPlayList(p);
	}
	
	public void crearPlayList(String nombre) {
		gestionBD.crearPlayList(nombre, cliente);
	}

	public void borrarPlayList(PlayList playList) {
		gestionBD.borrarPlayList(playList);
		gestionBD.borrarCancionesDePlayList(playList);
	}
	
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
	public boolean editarArtistaAdministrador(String nombre, String id, String desc, String tipo) {
		gestionBD.editarArtistaAdministrador(nombre, id, desc, tipo);
		return true;
	}

	public boolean añadirMusicoABaseDeDatos(String nombre, String desc, String tipo) {
		gestionBD.insertNuevoMusico(nombre, desc, tipo);

		return true;

	}


	public ArrayList<Podcaster> devolverPodcasters() {
		return this.podcasters;
	}

	public void recogerPodcastersDeLaBaseDeDatos() {
		podcasters = gestionBD.llenarListaPodcaster();
	}

	public boolean editarAlbumAdministrador(String id, String nombre, String año, String genero) {
		gestionBD.editarAlbumAdministrador(id, nombre, año, genero);
		
		return true;
	}
	public void recogerAlbumsDeLaBaseDeDatosAdmin() {
		albums = new ArrayList<Album>();
		this.albums = gestionBD.llenarListaDeAlbumsAdmin();
	}
	public boolean añadirAlbumABaseDeDatos(String nombre, String desc, String tipo) {
		gestionBD.insertNuevoMusico(nombre, desc, tipo);

		return true;

	}
	public void recogerCancionesDeLaBaseDeDatosAdmin() {
	canciones = new ArrayList<Cancion>();
	this.canciones = gestionBD.llenarListaDeCancionesAdmin();
	}
	
	//Metodos de gestion de archivos
	public void escribirFichero() {
		gestionFI.escribirFichero(canciones, playList.getTitulo());
	}
	
	public void insertarFichero(File fichero) {
		gestionFI.leerFichero(fichero);

	}

	
}
