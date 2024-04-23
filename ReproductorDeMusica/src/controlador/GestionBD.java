package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import modelo.Cliente;

public class GestionBD {

	public GestionBD() {
		iniciarConexion();

	}

	private Connection conexion;

	// Conexion a la Base de Datos
	public void iniciarConexion() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
//			conexion = DriverManager.getConnection("jdbc:mysql://localhost:3307/cinegrupo5", "root", "");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/cinegrupo5", "root", "");
		} catch (ClassNotFoundException e) {
			System.out.println("No se ha encontrado la libreria");
		} catch (SQLException e) {
			System.out.println("Base de datos no encontrada");
		}

	}

	// Cierre de conexion a la base de datos

	public void cerrarConexion() {
		System.out.println("Cerrando...");
		try {
			if (!conexion.isClosed()) {
				conexion.close();
			}
		} catch (SQLException e) {
			System.out.println("No hay conexion con la Base de Datos");
		}
		System.out.println("Conexion cerrada");
	}

	
	public boolean verificarUsuario(Cliente cliente) {
		boolean correcto = true;
		try {
			Statement consulta = conexion.createStatement();

			String query = "SELECT * FROM clientes ";
			ResultSet resultadoConsulta = consulta.executeQuery(query);
			while (resultadoConsulta.next()) {
				if (resultadoConsulta.getString(1).contentEquals(cliente.getContraseña())) {
					correcto = false;
				}

			}
			consulta.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block

			e.printStackTrace();
		}
		return correcto;
	}

}
