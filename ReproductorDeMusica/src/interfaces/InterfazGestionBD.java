package interfaces;

import java.util.ArrayList;

import modelo.Album;
import modelo.Cancion;
import modelo.Cliente;
import modelo.Musico;
import modelo.PlayList;
import modelo.Podcast;
import modelo.Podcaster;

public interface InterfazGestionBD {

	// Conexion a la Base de Datos
	void iniciarConexion();

	void cerrarConexion();

	boolean verificarUsuario(String cliente);

	boolean login(String usuario, String contraseña);

	boolean insertUsuario(Cliente cliente);

	Cliente pedirUsuario(String usuario);

	ArrayList<Musico> llenarListaMusico();

	ArrayList<Album> llenarListaDeAlbums(Musico musico);

	int contarCanciones(String album);

	ArrayList<Cancion> llenarListaDeCanciones(Album album);

	ArrayList<Cancion> llenarListaDeCancionesConAudio(Album album);

	ArrayList<Podcast> llenarListaDePodcasts(Podcaster podcaster);

	ArrayList<Podcast> llenarListaDePodcastsConAudio(Podcaster podcaster);

	boolean eliminarArtistaAdministrador(String id);

	boolean editarArtistaAdministrador(String nombre, String id, String desc, String tipo);

	boolean insertNuevoMusico(String nombre, String desc, String tipo);

	ArrayList<Podcaster> llenarListaPodcaster();

	boolean editarAlbumAdministrador(String id, String nombre, String año, String genero);

	boolean eliminarAlbumAdministrador(String id);

	boolean editarCancionesAdministrador(String ldAudio, String Idalbum, String textduracion, String nombreAudio,
			String textidcancion);

	boolean eliminarCancionAdministrador(String id);

	ArrayList<Album> llenarListaDeAlbumsAdmin();

	ArrayList<Cancion> llenarListaDeCancionesAdmin();

	boolean insertNuevoAlbum(String nombre, String id, String genero, String año);

	ArrayList<Cancion> buscarAnuncios();

	ArrayList<PlayList> llenarListaDePlaylists(Cliente cliente);

	ArrayList<Cancion> llenarListaDeCancionesPorPlayList(PlayList playList);

	ArrayList<Cancion> llenarListaDeCancionesConAudioPorPlayList(PlayList playList);

	int contarPlayList(Cliente cliente);

	int contarCantidadDeCancionEnPlayList(PlayList playlist);

	boolean crearPlayList(String nombre, Cliente cliente);

	boolean borrarPlayList(PlayList playList);

	boolean borrarCancionesDePlayList(PlayList playList);

	boolean insertarCancionesEnPlayList(String id, String cancion);

}