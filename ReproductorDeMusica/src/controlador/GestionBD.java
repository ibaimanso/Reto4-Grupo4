package controlador;

import java.io.File;
import java.io.FileOutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import modelo.Album;
import modelo.Cancion;
import modelo.Cliente;
import modelo.Musico;
import modelo.PlayList;
import modelo.Podcast;
import modelo.Podcaster;

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

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Campos inválidos");
		}
		return cliente;

	}

	public ArrayList<Musico> llenarListaMusico() {

		ArrayList<Musico> artista = new ArrayList<Musico>();
		try {
			Statement consulta = conexion.createStatement();

			String query = "SELECT * FROM musico";
			ResultSet resultadoConsulta = consulta.executeQuery(query);
			while (resultadoConsulta.next()) {
				if (resultadoConsulta.getBlob(3) == null) {
					artista.add(new Musico(resultadoConsulta.getString(1), resultadoConsulta.getString(2), null,
							resultadoConsulta.getString(4), resultadoConsulta.getString(5)));
				} else {
					Blob imagenBlob = resultadoConsulta.getBlob(3);
					byte[] arrayImagen = imagenBlob.getBytes(1, (int) imagenBlob.length());
					ImageIcon imagen = new ImageIcon(arrayImagen);
					artista.add(new Musico(resultadoConsulta.getString(1), resultadoConsulta.getString(2), imagen,
							resultadoConsulta.getString(4), resultadoConsulta.getString(5)));
				}
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Campos inválidos");
			e.printStackTrace();
			artista = null;
		}
		return artista;
	}

	public ArrayList<Album> llenarListaDeAlbums(Musico musico) {
		ArrayList<Album> albums = new ArrayList<Album>();
		try {
			Statement consulta = conexion.createStatement();

			String query = "SELECT * FROM album where IDMusico like '" + musico.getId() + "'";
			ResultSet resultadoConsulta = consulta.executeQuery(query);
			while (resultadoConsulta.next()) {

				if (resultadoConsulta.getBlob(5) == null) {
					albums.add(new Album(resultadoConsulta.getString(1), resultadoConsulta.getString(2),
							resultadoConsulta.getString(3), resultadoConsulta.getString(4), null,
							resultadoConsulta.getString(6), contarCanciones(resultadoConsulta.getString(1))));
				} else {

					if (resultadoConsulta.getBlob(5) == null) {
						albums.add(new Album(resultadoConsulta.getString(1), resultadoConsulta.getString(2),
								resultadoConsulta.getString(3), resultadoConsulta.getString(4), null,
								resultadoConsulta.getString(6)));
					} else {
						Blob imagenBlob = resultadoConsulta.getBlob(5);
						byte[] arrayImagen = imagenBlob.getBytes(1, (int) imagenBlob.length());
						ImageIcon imagen = new ImageIcon(arrayImagen);
						albums.add(new Album(resultadoConsulta.getString(1), resultadoConsulta.getString(2),
								resultadoConsulta.getString(3), resultadoConsulta.getString(4), imagen,
								resultadoConsulta.getString(6), contarCanciones(resultadoConsulta.getString(1))));
					}
				}
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Campos inválidos");
			e.printStackTrace();
			albums = null;
		}
		return albums;
	}

	public int contarCanciones(String album) {
		int canciones = 0;
		try {
			Statement consulta = conexion.createStatement();

			String query = "SELECT count(IDAlbum) FROM `canciones` where IDAlbum like '" + album + "'";
			ResultSet resultadoConsulta = consulta.executeQuery(query);
			while (resultadoConsulta.next()) {
				canciones = resultadoConsulta.getInt(1);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Campos inválidos");
			e.printStackTrace();
		}
		return canciones;
	}

	public ArrayList<Cancion> llenarListaDeCanciones(Album album) {
		ArrayList<Cancion> canciones = new ArrayList<Cancion>();
		try {
			Statement consulta = conexion.createStatement();

			String query = "SELECT au.IDAudio, au.Nombre, au.Duracion, au.Imagen, can.IDCancion, can.IDAlbum FROM `audio` as au join canciones as can on au.IDAudio = can.IDAudio where can.IDAlbum like '"
					+ album.getIdAlbum() + "'";
			ResultSet resultadoConsulta = consulta.executeQuery(query);
			while (resultadoConsulta.next()) {
				if (resultadoConsulta.getBlob(4) == null) {
					canciones.add(new Cancion(resultadoConsulta.getString(1), resultadoConsulta.getString(2),
							resultadoConsulta.getInt(3), null, resultadoConsulta.getString(5),
							resultadoConsulta.getString(6)));
				} else {
					Blob imagenBlob = resultadoConsulta.getBlob(4);
					byte[] arrayImagen = imagenBlob.getBytes(1, (int) imagenBlob.length());
					ImageIcon imagen = new ImageIcon(arrayImagen);
					canciones.add(new Cancion(resultadoConsulta.getString(1), resultadoConsulta.getString(2),
							resultadoConsulta.getInt(3), imagen, resultadoConsulta.getString(5),
							resultadoConsulta.getString(6)));
				}
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Campos inválidos");
			e.printStackTrace();
			canciones = null;
		}
		return canciones;
	}

	public ArrayList<Cancion> llenarListaDeCancionesConAudio(Album album) {
		ArrayList<Cancion> canciones = new ArrayList<Cancion>();
		try {
			Statement consulta = conexion.createStatement();

			String query = "SELECT au.IDAudio, au.Nombre, au.Duracion, au.Imagen, au.pista, can.IDCancion, can.IDAlbum FROM `audio` as au join canciones as can on au.IDAudio = can.IDAudio where can.IDAlbum like '"
					+ album.getIdAlbum() + "'";
			ResultSet resultadoConsulta = consulta.executeQuery(query);
			while (resultadoConsulta.next()) {
				ImageIcon imagen = new ImageIcon();
				if (resultadoConsulta.getBlob(4) == null) {
					imagen = null;
				} else {
					Blob imagenBlob = resultadoConsulta.getBlob(4);
					byte[] arrayImagen = imagenBlob.getBytes(1, (int) imagenBlob.length());
					imagen = new ImageIcon(arrayImagen);
				}

				File cancion = null;
				if (resultadoConsulta.getBlob(5) == null) {
					cancion = null;
				} else {
					Blob cancionBlob = resultadoConsulta.getBlob(5);
					byte[] arrayCancion = cancionBlob.getBytes(1, (int) cancionBlob.length());
					cancion = File.createTempFile("aud--", ".wav", new File("./canciones"));
					FileOutputStream out = new FileOutputStream(cancion);
					out.write(arrayCancion);
					out.close();

				}
				canciones.add(new Cancion(resultadoConsulta.getString(1), resultadoConsulta.getString(2),
						resultadoConsulta.getInt(3), imagen, cancion, resultadoConsulta.getString(6),
						resultadoConsulta.getString(7)));
			}
		} catch (Exception e) {
			e.printStackTrace();
			canciones = null;
		}
		return canciones;
	}

	public ArrayList<Podcast> llenarListaDePodcasts(Podcaster podcaster) {
		ArrayList<Podcast> podcasts = new ArrayList<Podcast>();
		try {
			Statement consulta = conexion.createStatement();

			String query = "SELECT au.IDAudio, au.Nombre, au.Duracion, au.Imagen, pod.IDPodcast, pod.Colaboradores FROM `audio` as au join podcast as pod on au.IDAudio = pod.IDAudio where pod.IDPodcaster like '"
					+ podcaster.getId() + "'";
			ResultSet resultadoConsulta = consulta.executeQuery(query);
			while (resultadoConsulta.next()) {
				if (resultadoConsulta.getBlob(4) == null) {
					podcasts.add(new Podcast(resultadoConsulta.getString(1), resultadoConsulta.getString(2),
							resultadoConsulta.getInt(3), null, resultadoConsulta.getString(5),
							resultadoConsulta.getString(6)));
				} else {
					Blob imagenBlob = resultadoConsulta.getBlob(4);
					byte[] arrayImagen = imagenBlob.getBytes(1, (int) imagenBlob.length());
					ImageIcon imagen = new ImageIcon(arrayImagen);
					podcasts.add(new Podcast(resultadoConsulta.getString(1), resultadoConsulta.getString(2),
							resultadoConsulta.getInt(3), imagen, resultadoConsulta.getString(5),
							resultadoConsulta.getString(6)));
				}
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Campos inválidos");
			e.printStackTrace();
			podcasts = null;
		}
		return podcasts;
	}

	public ArrayList<Podcast> llenarListaDePodcastsConAudio(Podcaster podcaster) {
		ArrayList<Podcast> podcasts = new ArrayList<Podcast>();
		try {
			Statement consulta = conexion.createStatement();

			String query = "SELECT au.IDAudio, au.Nombre, au.Duracion, au.Imagen, au.pista, pod.IDPodcast, pod.Colaboradores FROM `audio` as au join podcast as pod on au.IDAudio = pod.IDAudio where pod.IDPodcaster like '"
					+ podcaster.getId() + "'";
			ResultSet resultadoConsulta = consulta.executeQuery(query);
			while (resultadoConsulta.next()) {
				ImageIcon imagen = new ImageIcon();
				if (resultadoConsulta.getBlob(4) == null) {
					imagen = null;
				} else {
					Blob imagenBlob = resultadoConsulta.getBlob(4);
					byte[] arrayImagen = imagenBlob.getBytes(1, (int) imagenBlob.length());
					imagen = new ImageIcon(arrayImagen);
				}

				File cancion = null;
				if (resultadoConsulta.getBlob(5) == null) {
					cancion = null;
				} else {
					Blob cancionBlob = resultadoConsulta.getBlob(5);
					byte[] arrayCancion = cancionBlob.getBytes(1, (int) cancionBlob.length());
					cancion = File.createTempFile("aud--", ".wav", new File("./canciones"));
					FileOutputStream out = new FileOutputStream(cancion);
					out.write(arrayCancion);
					out.close();

				}
				podcasts.add(new Podcast(resultadoConsulta.getString(1), resultadoConsulta.getString(2),
						resultadoConsulta.getInt(3), imagen, cancion, resultadoConsulta.getString(6),
						resultadoConsulta.getString(7)));
			}
		} catch (Exception e) {
			e.printStackTrace();
			podcasts = null;
		}
		return podcasts;
	}

	public boolean eliminarArtistaAdministrador(String id) {

		boolean correcto = false;

		try {
			Statement consulta = conexion.createStatement();

			String update = "DELETE FROM musico WHERE IDMusico=" + "'" + id + "';";

			consulta.executeUpdate(update);
			JOptionPane.showMessageDialog(null, "Musico eliminado correctamente");
			consulta.close();
			correcto = true;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Campos inválidos");
			e.printStackTrace();
		}

		return correcto;
	}

	public boolean editarArtistaAdministrador(String nombre, String id, String desc, String tipo) {
		boolean correcto = false;

		try {
			Statement consulta = conexion.createStatement();

			String update = "UPDATE musico SET IDMusico=" + "'" + id + "'" + ", NombreArtistico=" + "'" + nombre + "'"
					+ ", Caracteristica=" + "'" + tipo + "'" + ", Descripcion=" + "'" + desc + "'" + "WHERE IDMusico="
					+ "'" + id + "'";

			consulta.executeUpdate(update);
			JOptionPane.showMessageDialog(null, "Musico actualizado correctamente");
			consulta.close();
			correcto = true;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Campos inválidos");
			e.printStackTrace();
		}

		return correcto;
	}

	public boolean eliminarArtistaAdministrador(String nombre, String id, String desc, String tipo) {
		boolean correcto = false;

		try {
			Statement consulta = conexion.createStatement();

			String update = "DELETE musico SET IDMusico=" + "'" + id + "'" + ", NombreArtistico=" + "'" + nombre + "'"
					+ ", Caracteristica=" + "'" + tipo + "'" + ", Descripcion=" + "'" + desc + "'" + "WHERE IDMusico="
					+ "'" + id + "'";

			consulta.executeUpdate(update);
			JOptionPane.showMessageDialog(null, "Musico actualizado correctamente");
			consulta.close();
			correcto = true;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Campos inválidos");
			e.printStackTrace();
		}

		return correcto;
	}

	public boolean insertNuevoMusico(String nombre, String desc, String tipo) {
		boolean correcto = false;
		try {
			Statement consulta = conexion.createStatement();

			String insert = "insert into musico (NombreArtistico, Caracteristica, Descripcion) VALUES ('" + nombre
					+ "','" + tipo + "','" + desc + "')";

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

	public ArrayList<Podcaster> llenarListaPodcaster() {

		ArrayList<Podcaster> podcaster = new ArrayList<Podcaster>();
		try {
			Statement consulta = conexion.createStatement();

			String query = "SELECT * FROM podcaster";
			ResultSet resultadoConsulta = consulta.executeQuery(query);
			while (resultadoConsulta.next()) {
				if (resultadoConsulta.getBlob(3) == null) {
					podcaster.add(new Podcaster(resultadoConsulta.getString(1), resultadoConsulta.getString(2), null,
							resultadoConsulta.getString(4)));
				} else {
					Blob imagenBlob = resultadoConsulta.getBlob(3);
					byte[] arrayImagen = imagenBlob.getBytes(1, (int) imagenBlob.length());
					ImageIcon imagen = new ImageIcon(arrayImagen);
					podcaster.add(new Podcaster(resultadoConsulta.getString(1), resultadoConsulta.getString(2), imagen,
							resultadoConsulta.getString(4)));
				}
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Campos inválidos");
			e.printStackTrace();
			podcaster = null;
		}
		return podcaster;
	}

	/**
	 * ArrayList para llenar la lista de podcast no funciona
	 */
//	public ArrayList<Podcast> llenarListaPodcast(Podcast podcast) {

//		ArrayList<Podcast> podcasts = new ArrayList<Podcast>();
//		try {
//			Statement consulta = conexion.createStatement();
//
//			String query = "SELECT * FROM podcast WHERE IDPodcaster=" +"'"+podcast.getIdPodcaster()+"'" ;
//			ResultSet resultadoConsulta = consulta.executeQuery(query);
//			while (resultadoConsulta.next()) {
//				if(resultadoConsulta.getBlob(4) == null) {
//					podcasts.add(new Podcast(resultadoConsulta.getString(1), resultadoConsulta.getString(2), resultadoConsulta.getString(3),, null, resultadoConsulta.getInt(5)));
//				}else {
//
//				if (resultadoConsulta.getBlob(4) == null) {
//					podcasts.add(new Podcast(resultadoConsulta.getString(1), resultadoConsulta.getString(2),
//							resultadoConsulta.getString(3), null,
//							resultadoConsulta.getInt(5)));
//				} else {
//					Blob imagenBlob = resultadoConsulta.getBlob(5);
//					byte[] arrayImagen = imagenBlob.getBytes(1, (int) imagenBlob.length());
//					ImageIcon imagen = new ImageIcon(arrayImagen);
//					podcasts.add(new Podcast(resultadoConsulta.getString(1), resultadoConsulta.getString(2), resultadoConsulta.getString(3),  imagen, resultadoConsulta.getInt(5)));
//				}
//			}
//				
//			
//
//			}
//		} catch (Exception e) {
//			JOptionPane.showMessageDialog(null, "Campos inválidos");
//			e.printStackTrace();
//			podcasts = null;
//		}
//		return podcasts;
//	}
	public boolean eliminarAlbumAdministrador(String nombre, String id, String genero, String año) {
		boolean correcto = false;

		try {
			Statement consulta = conexion.createStatement();

			String update = "UPDATE album SET IDAlbum=" + "'" + id + "'" + ", Titulo=" + "'" + nombre + "'" + ", Año="
					+ "'" + año + "'" + ", Genero=" + "'" + genero + "'" + "WHERE IDAlbum=" + "'" + id + "'";

			consulta.executeUpdate(update);
			JOptionPane.showMessageDialog(null, "Album eliminado correctamente");
			consulta.close();
			correcto = true;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Campos inválidos");
			e.printStackTrace();
		}

		return correcto;
	}

//	public boolean editarCancionesAdministrador(String ldAudio, String Idalbum, String textduracion, String nombreAudio,String textidcancion) {
//	boolean correcto = false;
//
////		try {
//			Statement consulta = conexion.createStatement();
//
//			String update = "UPDATE Audio SET IDAudio=" + "'" + ldAudio + "'" + ", nombre=" + "'" + nombreAudio + "'" + ", Duracion="
//					+ "'" + textduracion + "'" + ", Genero=" + "'" + genero + "'" + "WHERE IDAlbum=" + "'" + id + "'";
//
//			consulta.executeUpdate(update);
//			JOptionPane.showMessageDialog(null, "Album actualizado correctamente");
//			consulta.close();
//			correcto = true;
//		} catch (Exception e) {
//			JOptionPane.showMessageDialog(null, "Campos inválidos");
//			e.printStackTrace();
//		}
//
//		return correcto;
//	}

	public ArrayList<Album> llenarListaDeAlbumsAdmin() {
		ArrayList<Album> albums = new ArrayList<Album>();
		try {
			Statement consulta = conexion.createStatement();

			String query = "SELECT * FROM album";
			ResultSet resultadoConsulta = consulta.executeQuery(query);
			while (resultadoConsulta.next()) {

				if (resultadoConsulta.getBlob(5) == null) {
					albums.add(new Album(resultadoConsulta.getString(1), resultadoConsulta.getString(2),
							resultadoConsulta.getString(3), resultadoConsulta.getString(4), null,
							resultadoConsulta.getString(6), contarCanciones(resultadoConsulta.getString(1))));
				} else {

					if (resultadoConsulta.getBlob(5) == null) {
						albums.add(new Album(resultadoConsulta.getString(1), resultadoConsulta.getString(2),
								resultadoConsulta.getString(3), resultadoConsulta.getString(4), null,
								resultadoConsulta.getString(6)));
					} else {
						Blob imagenBlob = resultadoConsulta.getBlob(5);
						byte[] arrayImagen = imagenBlob.getBytes(1, (int) imagenBlob.length());
						ImageIcon imagen = new ImageIcon(arrayImagen);
						albums.add(new Album(resultadoConsulta.getString(1), resultadoConsulta.getString(2),
								resultadoConsulta.getString(3), resultadoConsulta.getString(4), imagen,
								resultadoConsulta.getString(6), contarCanciones(resultadoConsulta.getString(1))));

					}
				}
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Campos inválidos");
			e.printStackTrace();
			albums = null;
		}
		return albums;
	}

	public ArrayList<Cancion> llenarListaDeCancionesAdmin() {
		ArrayList<Cancion> canciones = new ArrayList<Cancion>();
		try {
			Statement consulta = conexion.createStatement();

			String query = " SELECT au.IDAudio, au.Nombre, au.Duracion, au.Imagen, au.pista, can.IDCancion, can.IDAlbum FROM `audio` as au join canciones as can on au.IDAudio = can.IDAudio";
			ResultSet resultadoConsulta = consulta.executeQuery(query);
			while (resultadoConsulta.next()) {
				ImageIcon imagen = new ImageIcon();
				if (resultadoConsulta.getBlob(4) == null) {
					imagen = null;
				} else {
					Blob imagenBlob = resultadoConsulta.getBlob(4);
					byte[] arrayImagen = imagenBlob.getBytes(1, (int) imagenBlob.length());
					imagen = new ImageIcon(arrayImagen);
				}

				File cancion = null;
				if (resultadoConsulta.getBlob(5) == null) {
					cancion = null;
				} else {
					Blob cancionBlob = resultadoConsulta.getBlob(5);
					byte[] arrayCancion = cancionBlob.getBytes(1, (int) cancionBlob.length());
					cancion = File.createTempFile("aud--", ".wav", new File("./canciones"));
					FileOutputStream out = new FileOutputStream(cancion);
					out.write(arrayCancion);
					out.close();

				}
				canciones.add(new Cancion(resultadoConsulta.getString(1), resultadoConsulta.getString(2),
						resultadoConsulta.getInt(3), imagen, cancion, resultadoConsulta.getString(6),
						resultadoConsulta.getString(7)));
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Campos inválidos");
			e.printStackTrace();
			canciones = null;
		}
		return canciones;
	}

	public boolean insertNuevoAlbum(String nombre, String id, String genero, String año) {
		boolean correcto = false;
		try {
			Statement consulta = conexion.createStatement();

			String insert = "insert into album (Titulo, Año, Genero) VALUES ('" + nombre + "','" + año + "','" + genero
					+ "')";

			System.out.println(insert);
			consulta.executeUpdate(insert);
			JOptionPane.showMessageDialog(null, "Album creado correctamente");

			consulta.close();

			correcto = true;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Campos inválidos");
			e.printStackTrace();
		}
		return correcto;
	}

	public ArrayList<Cancion> buscarAnuncios() {
		ArrayList<Cancion> anuncios = new ArrayList<Cancion>();
		try {
			Statement consulta = conexion.createStatement();

			String query = "SELECT au.IDAudio, au.Nombre, au.Duracion, au.Imagen, au.pista, can.IDCancion, can.IDAlbum FROM `audio` as au join canciones as can on au.IDAudio = can.IDAudio where can.IDAlbum like 'AL060'";
			ResultSet resultadoConsulta = consulta.executeQuery(query);
			while (resultadoConsulta.next()) {
				ImageIcon imagen = new ImageIcon();
				if (resultadoConsulta.getBlob(4) == null) {
					imagen = null;
				} else {
					Blob imagenBlob = resultadoConsulta.getBlob(4);
					byte[] arrayImagen = imagenBlob.getBytes(1, (int) imagenBlob.length());
					imagen = new ImageIcon(arrayImagen);
				}

				File cancion = null;
				if (resultadoConsulta.getBlob(5) == null) {
					cancion = null;
				} else {
					Blob cancionBlob = resultadoConsulta.getBlob(5);
					byte[] arrayCancion = cancionBlob.getBytes(1, (int) cancionBlob.length());
					cancion = File.createTempFile("aud--", ".wav", new File("./canciones"));
					FileOutputStream out = new FileOutputStream(cancion);
					out.write(arrayCancion);
					out.close();

				}
				anuncios.add(new Cancion(resultadoConsulta.getString(1), resultadoConsulta.getString(2),
						resultadoConsulta.getInt(3), imagen, cancion, resultadoConsulta.getString(6),
						resultadoConsulta.getString(7)));
			}
		} catch (Exception e) {
			e.printStackTrace();
			anuncios = null;
		}
		return anuncios;
	}

	public ArrayList<PlayList> llenarListaDePlaylists(Cliente cliente) {
		ArrayList<PlayList> playlist = new ArrayList<PlayList>();
		try {
			Statement consulta = conexion.createStatement();

			String query = "SELECT * FROM `playlist` WHERE IDCliente like '" + cliente.getIdCliente() + "'";
			ResultSet resultadoConsulta = consulta.executeQuery(query);
			while (resultadoConsulta.next()) {
				playlist.add(new PlayList(resultadoConsulta.getString(1), resultadoConsulta.getString(2),
						resultadoConsulta.getString(3)));
			}

		} catch (Exception e) {
			e.printStackTrace();
			playlist = null;
		}
		return playlist;
	}

	public ArrayList<Cancion> llenarListaDeCancionesPorPlayList(PlayList playList) {
		ArrayList<Cancion> canciones = new ArrayList<Cancion>();
		try {
			Statement consulta = conexion.createStatement();

			String query = "SELECT au.IDAudio, au.Nombre, au.Duracion, au.Imagen, can.IDCancion, can.IDAlbum FROM `audio` as au join canciones as can on au.IDAudio = can.IDAudio join playlist_canciones as play on play.IDCancion = can.IDCancion where play.IDList like '"
					+ playList.getIDList() + "'";
			ResultSet resultadoConsulta = consulta.executeQuery(query);
			while (resultadoConsulta.next()) {
				if (resultadoConsulta.getBlob(4) == null) {
					canciones.add(new Cancion(resultadoConsulta.getString(1), resultadoConsulta.getString(2),
							resultadoConsulta.getInt(3), null, resultadoConsulta.getString(5),
							resultadoConsulta.getString(6)));
				} else {
					Blob imagenBlob = resultadoConsulta.getBlob(4);
					byte[] arrayImagen = imagenBlob.getBytes(1, (int) imagenBlob.length());
					ImageIcon imagen = new ImageIcon(arrayImagen);
					canciones.add(new Cancion(resultadoConsulta.getString(1), resultadoConsulta.getString(2),
							resultadoConsulta.getInt(3), imagen, resultadoConsulta.getString(5),
							resultadoConsulta.getString(6)));
				}
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Campos inválidos");
			e.printStackTrace();
			canciones = null;
		}
		return canciones;
	}

	public ArrayList<Cancion> llenarListaDeCancionesConAudioPorPlayList(PlayList playList) {
		ArrayList<Cancion> canciones = new ArrayList<Cancion>();
		try {
			Statement consulta = conexion.createStatement();

			String query = "SELECT au.IDAudio, au.Nombre, au.Duracion, au.Imagen, au.pista, can.IDCancion, can.IDAlbum FROM `audio` as au join canciones as can on au.IDAudio = can.IDAudio join playlist_canciones as play on play.IDCancion = can.IDCancion where play.IDList like '"
					+ playList.getIDList() + "'";
			ResultSet resultadoConsulta = consulta.executeQuery(query);
			while (resultadoConsulta.next()) {
				ImageIcon imagen = new ImageIcon();
				if (resultadoConsulta.getBlob(4) == null) {
					imagen = null;
				} else {
					Blob imagenBlob = resultadoConsulta.getBlob(4);
					byte[] arrayImagen = imagenBlob.getBytes(1, (int) imagenBlob.length());
					imagen = new ImageIcon(arrayImagen);
				}

				File cancion = null;
				if (resultadoConsulta.getBlob(5) == null) {
					cancion = null;
				} else {
					Blob cancionBlob = resultadoConsulta.getBlob(5);
					byte[] arrayCancion = cancionBlob.getBytes(1, (int) cancionBlob.length());
					cancion = File.createTempFile("aud--", ".wav", new File("./canciones"));
					FileOutputStream out = new FileOutputStream(cancion);
					out.write(arrayCancion);
					out.close();

				}
				canciones.add(new Cancion(resultadoConsulta.getString(1), resultadoConsulta.getString(2),
						resultadoConsulta.getInt(3), imagen, cancion, resultadoConsulta.getString(6),
						resultadoConsulta.getString(7)));
			}
		} catch (Exception e) {
			e.printStackTrace();
			canciones = null;
		}
		return canciones;
	}

	public int contarPlayList(Cliente cliente) {
		int playlist = 0;
		try {
			Statement consulta = conexion.createStatement();

			String query = "SELECT COUNT(IDCliente) FROM `playlist` WHERE IDCliente like '" + cliente.getIdCliente()
					+ "'";
			ResultSet resultadoConsulta = consulta.executeQuery(query);
			while (resultadoConsulta.next()) {
				playlist = resultadoConsulta.getInt(1);
			}

		} catch (Exception e) {
			e.printStackTrace();
			playlist = 0;
		}
		return playlist;
	}

	public int contarCantidadDeCancionEnPlayList(PlayList playlist) {
		int num = 0;
		try {
			Statement consulta = conexion.createStatement();

			String query = "SELECT COUNT(IDList) FROM `playlist_canciones` WHERE IDList like '" + playlist.getIDList()
					+ "'";
			ResultSet resultadoConsulta = consulta.executeQuery(query);
			while (resultadoConsulta.next()) {
				num = resultadoConsulta.getInt(1);
			}

		} catch (Exception e) {
			e.printStackTrace();
			num = 0;
		}
		return num;
	}

	public void crearPlayList(String nombre, Cliente cliente) {
		try {
			Statement consulta = conexion.createStatement();

			String insert = "INSERT INTO `playlist` (`Titulo`, `IDCliente`) VALUES ('" + nombre + "', '"
					+ cliente.getIdCliente() + "');";
			consulta.executeUpdate(insert);
			JOptionPane.showMessageDialog(null, "PlayList creada correctamente");

			consulta.close();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Campos inválidos");
			e.printStackTrace();
		}

	}

	public void borrarPlayList(PlayList playList) {
		try {
			Statement consulta = conexion.createStatement();

			String insert = "delete FROM `playlist` WHERE IDList = " + playList.getIDList() + "";
			consulta.executeUpdate(insert);
			consulta.close();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Campos inválidos");
			e.printStackTrace();
		}
	}

	public void borrarCancionesDePlayList(PlayList playList) {
		try {
			Statement consulta = conexion.createStatement();

			String insert = "delete FROM `playlist_canciones` WHERE IDList = " + playList.getIDList() + "";
			consulta.executeUpdate(insert);
			consulta.close();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Campos inválidos");
			e.printStackTrace();
		}
	}

	public void insertarCancionesEnPlayList(String id, String cancion) {
		try {
			Statement consulta = conexion.createStatement();

			String insert = "INSERT INTO `playlist_canciones` (`IDList`, `IDCancion`, `fechaPlaylist_Cancion`) VALUES ('"
					+ id + "', '" + cancion + "', current_timestamp());";
			consulta.executeUpdate(insert);
			consulta.close();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Campos inválidos");
			e.printStackTrace();
		}
	}

}
