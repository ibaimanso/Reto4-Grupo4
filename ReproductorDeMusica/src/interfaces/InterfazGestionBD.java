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

	
	/**
	 * Método para iniciar la conexión con la base de datos.
	 */
	void iniciarConexion();

	/**
	 * Método para cerrar la conexión con la base de datos.
	 */
	void cerrarConexion();

	/**
	 * Método para verificar si un usuario existe en el sistema.
	 * @param cliente El nombre del cliente a verificar.
	 */
	boolean verificarUsuario(String cliente);

	/**
	 * Método para realizar el inicio de sesión de un usuario.
	 * @param usuario El nombre de usuario.
	 * @param contraseña La contraseña del usuario.
	 */
	boolean login(String usuario, String contraseña);

	/**
	 * Método para insertar un nuevo usuario en el sistema.
	 * @param cliente El objeto Cliente a insertar.
	 */
	boolean insertUsuario(Cliente cliente);

	/**
	 * Método para obtener la información de un usuario.
	 * @param usuario El nombre del usuario.
	 */
	Cliente pedirUsuario(String usuario);

	/**
	 * Método para obtener una lista de músicos.
	 */
	ArrayList<Musico> llenarListaMusico();

	/**
	 * Método para obtener una lista de álbumes de un músico.
	 * @param musico El músico del cual se desea obtener los álbumes.
	 */
	ArrayList<Album> llenarListaDeAlbums(Musico musico);

	/**
	 * Método para contar la cantidad de canciones en un álbum.
	 * @param album El álbum del cual se desea contar las canciones.
	 */
	int contarCanciones(String album);

	/**
	 * Método para obtener una lista de canciones de un álbum.
	 * @param album El álbum del cual se desea obtener las canciones.
	 */
	ArrayList<Cancion> llenarListaDeCanciones(Album album);

	/**
	 * Método para obtener una lista de canciones con audio de un álbum.
	 * @param album El álbum del cual se desea obtener las canciones con audio.
	 */
	ArrayList<Cancion> llenarListaDeCancionesConAudio(Album album);

	/**
	 * Método para obtener una lista de podcasts de un podcaster.
	 * @param podcaster El podcaster del cual se desea obtener los podcasts.
	 */
	ArrayList<Podcast> llenarListaDePodcasts(Podcaster podcaster);

	/**
	 * Método para obtener una lista de podcasts con audio de un podcaster.
	 * @param podcaster El podcaster del cual se desea obtener los podcasts con audio.
	 */
	ArrayList<Podcast> llenarListaDePodcastsConAudio(Podcaster podcaster);

	/**
	 * Método para eliminar un artista como administrador.
	 * @param id El ID del artista a eliminar.
	 */
	boolean eliminarArtistaAdministrador(String id);

	/**
	 * Método para editar la información de un artista como administrador.
	 * @param nombre El nuevo nombre del artista.
	 * @param id El ID del artista a editar.
	 * @param desc La nueva descripción del artista.
	 * @param tipo El nuevo tipo de artista.
	 */
	boolean editarArtistaAdministrador(String nombre, String id, String desc, String tipo);

	/**
	 * Método para insertar un nuevo músico en el sistema.
	 * @param nombre El nombre del nuevo músico.
	 * @param desc La descripción del nuevo músico.
	 * @param tipo El tipo del nuevo músico.
	 */
	boolean insertNuevoMusico(String nombre, String desc, String tipo);

	/**
	 * Método para obtener una lista de podcasters.
	 */
	ArrayList<Podcaster> llenarListaPodcaster();

	/**
	 * Método para editar la información de un álbum como administrador.
	 * @param id El ID del álbum a editar.
	 * @param nombre El nuevo nombre del álbum.
	 * @param año El nuevo año de lanzamiento del álbum.
	 * @param genero El nuevo género del álbum.
	 */
	boolean editarAlbumAdministrador(String id, String nombre, String año, String genero);

	/**
	 * Método para eliminar un álbum como administrador.
	 * @param id El ID del álbum a eliminar.
	 */
	boolean eliminarAlbumAdministrador(String id);

	/**
	 * Método para editar la información de las canciones como administrador.
	 * @param ldAudio El nuevo enlace de audio de la canción.
	 * @param Idalbum El ID del álbum al que pertenece la canción.
	 * @param textduracion El nuevo texto de duración de la canción.
	 * @param nombreAudio El nuevo nombre del archivo de audio de la canción.
	 * @param textidcancion El nuevo texto del ID de la canción.
	 */
	boolean editarCancionesAdministrador(String ldAudio, String Idalbum, String textduracion, String nombreAudio,
	        String textidcancion);

	/**
	 * Método para eliminar una canción como administrador.
	 * @param id El ID de la canción a eliminar.
	 */
	boolean eliminarCancionAdministrador(String id);

	/**
	 * Método para obtener una lista de álbumes como administrador.
	 */
	ArrayList<Album> llenarListaDeAlbumsAdmin();

	/**
	 * Método para obtener una lista de canciones como administrador.
	 */
	ArrayList<Cancion> llenarListaDeCancionesAdmin();

	/**
	 * Método para insertar un nuevo álbum en el sistema como administrador.
	 * @param nombre El nombre del nuevo álbum.
	 * @param id El ID del nuevo álbum.
	 * @param genero El género del nuevo álbum.
	 * @param año El año de lanzamiento del nuevo álbum.
	 */
	boolean insertNuevoAlbum(String nombre, String id, String genero, String año);

	/**
	 * Método para buscar anuncios.
	 */
	ArrayList<Cancion> buscarAnuncios();

	/**
	 * Método para obtener una lista de playlists de un cliente.
	 * @param cliente El cliente del cual se desea obtener las playlists.
	 */
	ArrayList<PlayList> llenarListaDePlaylists(Cliente cliente);

	/**
	 * Método para obtener una lista de canciones de una playlist.
	 * @param playList La playlist de la cual se desea obtener las canciones.
	 */
	ArrayList<Cancion> llenarListaDeCancionesPorPlayList(PlayList playList);

	/**
	 * Método para obtener una lista de canciones con audio de una playlist.
	 * @param playList La playlist de la cual se desea obtener las canciones con audio.
	 */
	ArrayList<Cancion> llenarListaDeCancionesConAudioPorPlayList(PlayList playList);

	/**
	 * Método para contar la cantidad de playlists de un cliente.
	 * @param cliente El cliente del cual se desea contar las playlists.
	 */
	int contarPlayList(Cliente cliente);

	/**
	 * Método para contar la cantidad de canciones en una playlist.
	 * @param playlist La playlist de la cual se desea contar las canciones.
	 */
	int contarCantidadDeCancionEnPlayList(PlayList playlist);

	/**
	 * Método para crear una nueva playlist.
	 * @param nombre El nombre de la nueva playlist.
	 * @param cliente El cliente al que pertenece la playlist.
	 */
	boolean crearPlayList(String nombre, Cliente cliente);

	/**
	 * Método para borrar una playlist.
	 * @param playList La playlist que se desea borrar.
	 */
	boolean borrarPlayList(PlayList playList);

	/**
	 * Método para borrar canciones de una playlist.
	 * @param playList La playlist de la cual se desean borrar canciones.
	 */
	boolean borrarCancionesDePlayList(PlayList playList);

	/**
	 * Método para insertar canciones en una playlist.
	 * @param id
	 */

	boolean insertarCancionesEnPlayList(String id, String cancion);

}