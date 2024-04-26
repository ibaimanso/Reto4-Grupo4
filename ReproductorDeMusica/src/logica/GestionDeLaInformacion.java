package logica;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import controlador.GestionBD;
import modelo.Cliente;

public class GestionDeLaInformacion {

	private GestionBD gestionBD;
	private Cliente usuario;

	public GestionDeLaInformacion() {
		gestionBD = new GestionBD();
	}

	public boolean testUsuarioYContraseña(String usuario, String contraseña) {
		boolean login = false;
		login = gestionBD.Login(usuario, contraseña);
		return login;
	}
//	public boolean recogerInformacionFormulario(Cliente cliente) {
//		boolean correcto = true;
//		/**
//		 * Regex para que en el panel de registro toda la informacion se introduzca
//		 * correctamente
//		 */
//		
//		Pattern patron1 = Pattern.compile("^\\d{4}([\\-/.])(0?[1-9]|1[1-2])\\1(3[01]|[12][0-9]|0?[1-9])$");
//		Matcher pass = patron1.matcher(cliente.getFecha_de_nacimiento());
//
//		if (!pass.find()) {
//			correcto = false;
//		} 
//		
//		return correcto;
//	}
//	
	public boolean validarExistenciaEnLaBaseDeDatos(Cliente cliente) {
		boolean correcto = false;
		correcto = gestionBD.verificarUsuario(cliente);
		return correcto;
	}
	/**
	 * Metodo para devolver un string con el nombre y apellidos del cliente
	 * 
	 * @return String con el nombre y apellido del cliente
	 */
	public String devolverNombreUsuario() {
		String respuesta = usuario.getUsuario();
		return respuesta;
	}
}
