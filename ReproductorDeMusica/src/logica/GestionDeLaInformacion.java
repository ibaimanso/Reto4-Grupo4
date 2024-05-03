package logica;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import controlador.GestionBD;
import modelo.Album;
import modelo.Cliente;
import modelo.Musico;

public class GestionDeLaInformacion {

	private GestionBD gestionBD;
	private Cliente cliente;
	private Musico musico;
	private ArrayList<Musico> musicos;
	private Album album;
	private ArrayList<Album> albums;
	

	public GestionDeLaInformacion() {
		gestionBD = new GestionBD();
		musicos = gestionBD.llenarListaMusico();
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
		
		if(!pass.find()) {
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
	 * @param musico
	 */
	public void guardarMusico(Musico musico) {
		this.musico = musico;
	}
	
	public Musico devolverMusico(){
		return this.musico;
	}
	
	public ArrayList<Musico> devolverMusicos(){
		return this.musicos;
	}

	public void recogerMusicosDeLaBaseDeDatos() {
		musicos = gestionBD.llenarListaMusico();
	}
	
	/**
	 * Metodos para la gestion de albums
	 * @param album
	 */
	
	public void guardarAlbum(Album album) {
		this.album = album;

	}
	
	public ArrayList<Album> devolverAlbums(){
		return this.albums;
	}

	public void recogerAlbumsDeLaBaseDeDatos() {
		this.albums = gestionBD.llenarListaDeAlbums(this.musico);
	}
}
