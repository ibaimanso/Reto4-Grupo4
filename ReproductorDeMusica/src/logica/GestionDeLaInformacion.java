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
}
