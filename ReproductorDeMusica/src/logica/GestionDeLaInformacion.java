package logica;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import controlador.GestionBD;
import modelo.Cliente;
import modelo.Musico;

public class GestionDeLaInformacion {

	private GestionBD gestionBD;
	private Cliente cliente;
	private Musico musico;

	public GestionDeLaInformacion() {
		gestionBD = new GestionBD();
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
		System.out.println(cliente);
	}
	public Cliente devolverUsuario() {
		System.out.println(cliente);
		return this.cliente;
	}
	
	public boolean insertarUsuario(Cliente insertar) {
		gestionBD.insertUsuario(insertar);
		return true;
	}
	public void guardarMusico(String musico) {
		this.musico = gestionBD.sacarMusico(musico);

	}
	
	public Musico devolverMusico() {
		return this.musico;
		
		
	}
	public ArrayList<String> devolverMusicos(){
		return null;
		
	}
}
