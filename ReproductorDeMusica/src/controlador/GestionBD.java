package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import modelo.Cliente;
import modelo.Musico;

public class GestionBD {

	public GestionBD() {
		iniciarConexion();

	}

	private Connection conexion;

	// Conexion a la Base de Datos
	public void iniciarConexion() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/reto4", "root", "");
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

	public boolean verificarUsuario(String cliente) {
		boolean correcto = true;
		try {
			Statement consulta = conexion.createStatement();

			String query = "SELECT * FROM cliente ";
			ResultSet resultadoConsulta = consulta.executeQuery(query);
			while (resultadoConsulta.next()) {
				if (resultadoConsulta.getString(5).equalsIgnoreCase(cliente)) {
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

	public boolean Login(String usuario, String contraseña) {
		boolean login = false;
		try {
			Statement consulta = conexion.createStatement();

			String query = "SELECT * FROM cliente ";
			ResultSet resultadoConsulta = consulta.executeQuery(query);
			while (resultadoConsulta.next()) {
				if (resultadoConsulta.getString(5).contentEquals(usuario)
						& resultadoConsulta.getString(6).contentEquals(contraseña)) {
					login = true;
				}

			}
			consulta.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block

			e.printStackTrace();
		}
		return login;

	}

	public boolean insertUsuario(Cliente cliente) {
		boolean correcto = false;
		try {
			Statement consulta = conexion.createStatement();

			String insert = "insert into cliente (Nombre, Apellido, Idioma, Usuario, Contraseña, FechaNacimiento, FechaRegistro, Tipo) VALUES ('"
					+ cliente.getNombre() + "', '" + cliente.getApellido() + "', '" + cliente.getIdioma() + "', '"
					+ cliente.getUsuario() + "', '" + cliente.getContraseña() + "', '"
					+ cliente.getFecha_de_nacimiento() + "', CURRENT_DATE, '" + cliente.getPremium() + "')";
			System.out.println(insert);
			consulta.executeUpdate(insert);
			JOptionPane.showMessageDialog(null, "Usuario creado correctamente");
			consulta.close();
			correcto = true;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Campos inválidos");
			e.printStackTrace();
		}
		return correcto;
	}

	public Cliente pedirUsuario(String usuario) {

		Cliente cliente = new Cliente();
		try {
			Statement consulta = conexion.createStatement();

			String query = "SELECT * FROM cliente WHERE usuario LIKE '" + usuario + "' ";
			ResultSet resultadoConsulta = consulta.executeQuery(query);
			while (resultadoConsulta.next()) {
				cliente = new Cliente(resultadoConsulta.getString(1), resultadoConsulta.getString(2),
						resultadoConsulta.getString(3), resultadoConsulta.getString(4), resultadoConsulta.getString(5),
						resultadoConsulta.getString(6), resultadoConsulta.getString(7), resultadoConsulta.getString(8),
						resultadoConsulta.getString(9));
			}
			System.out.println(cliente);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Campos inválidos");
		}
		return cliente;

	}

	public Musico sacarMusico(String musico) {

		Musico cantante = new Musico();

		try {
			Statement consulta = conexion.createStatement();

			String query = "SELECT * FROM musico WHERE NombreArtistico LIKE '" + musico + "'";
			ResultSet resultadoConsulta = consulta.executeQuery(query);
			while (resultadoConsulta.next()) {
				cantante = new Musico(resultadoConsulta.getString(2), resultadoConsulta.getString(4),
						resultadoConsulta.getString(5));
			}
			System.out.println(musico);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Campos inválidos");
			e.printStackTrace();
		}
		return cantante;

	}

	public void llenarLista(String nombre) {

		ArrayList<String> artista = new ArrayList<String>();
		try {
			Statement consulta = conexion.createStatement();

			String query = "SELECT NombreArtistico FROM musico";
			ResultSet resultadoConsulta = consulta.executeQuery(query);
			while (resultadoConsulta.next()) {
				artista.add(resultadoConsulta.getString(2));

			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Campos inválidos");
			e.printStackTrace();
		}

	}
}
