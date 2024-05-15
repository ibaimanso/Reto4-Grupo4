package interfaces;

import java.io.File;
import java.util.ArrayList;

import modelo.Album;
import modelo.Cancion;
import modelo.Cliente;
import modelo.Musico;
import modelo.PlayList;
import modelo.Podcast;
import modelo.Podcaster;

public interface InterfazGestionDeLaInformacion {

	/**
	 * Método para limpiar.
	 */
	void limpiar();

	/**
	 * Método para probar el usuario y contraseña.
	 * @param usuario El nombre de usuario.
	 * @param contraseña La contraseña del usuario.
	 * @return True si el usuario y contraseña son válidos, False si no.
	 */
	boolean testUsuarioYContraseña(String usuario, String contraseña);

	/**
	 * Método para recoger información de un formulario.
	 * @param fecha La fecha del formulario.
	 */
	boolean recogerInformacionFormulario(String fecha);

	/**
	 * Método para validar la existencia en la base de datos.
	 * @param usuario El usuario a validar.
	 * @return True si el usuario existe en la base de datos, False si no.
	 */
	boolean validarExistenciaEnLaBaseDeDatos(String usuario);

	/**
	 * Método para guardar un usuario.
	 * @param usuario El usuario a guardar.
	 */
	void guardarUsuario(String usuario);

	/**
	 * Método para devolver un usuario.
	 * @return El objeto Cliente correspondiente al usuario.
	 */
	Cliente devolverUsuario();

	/**
	 * Método para insertar un usuario en la base de datos.
	 * @param insertar El objeto Cliente a insertar.
	 * @return True si la inserción es exitosa, False si no.
	 */
	boolean insertarUsuario(Cliente insertar);

	/**
	 * Método para guardar un músico.
	 * @param musico El músico a guardar.
	 */
	void guardarMusico(Musico musico);

	/**
	 * Método para devolver un músico.
	 * @return El objeto Musico correspondiente al músico.
	 */
	Musico devolverMusico();

	/**
	 * Método para devolver una lista de músicos.
	 * @return Un ArrayList de objetos Musico.
	 */
	ArrayList<Musico> devolverMusicos();

	/**
	 * Método para recoger músicos de la base de datos.
	 */
	void recogerMusicosDeLaBaseDeDatos();

	/**
	 * Método para guardar un álbum.
	 * @param album El álbum a guardar.
	 */
	void guardarAlbum(Album album);

	/**
	 * Método para devolver un álbum.
	 * @return El objeto Album correspondiente al álbum.
	 */
	Album devolverAlbum();

	/**
	 * Método para devolver una lista de álbumes.
	 * @return Un ArrayList de objetos Album.
	 */
	ArrayList<Album> devolverAlbums();

	/**
	 * Método para recoger álbumes de la base de datos.
	 */
	void recogerAlbumsDeLaBaseDeDatos();

	/**
	 * Método para guardar una canción.
	 * @param cancion La canción a guardar.
	 */
	void guardarCancion(Cancion cancion);

	/**
	 * Método para devolver una canción.
	 * @return El objeto Cancion correspondiente a la canción.
	 */
	Cancion devolverCancion();

	/**
	 * Método para devolver una lista de canciones.
	 * @return Un ArrayList de objetos Cancion.
	 */
	ArrayList<Cancion> devolverCanciones();

	/**
	 * Método para recoger canciones de la base de datos.
	 */
	void recogerCancionesDeLaBaseDeDatos();

	/**
	 * Método para recoger canciones de la base de datos con audio.
	 */
	void recogerCancionesDeLaBaseDeDatosConAudio();

	/**
	 * Método para borrar audios del sistema.
	 */
	void borrarAudiosDelSistema();

	/**
	 * Método para recoger anuncios de la base de datos con audio.
	 * @return Un ArrayList de objetos Cancion.
	 */
	ArrayList<Cancion> recogerAnunciosDeLaBaseDeDatosConAudio();

	/**
	 * Método para guardar una playlist.
	 * @param playList La playlist a guardar.
	 */
	void guardarPlayList(PlayList playList);

	/**
	 * Método para devolver una playlist.
	 * @return El objeto PlayList correspondiente a la playlist.
	 */
	PlayList devolverPlayList();

	/**
	 * Método para devolver una lista de playlists.
	 * @return Un ArrayList de objetos PlayList.
	 */
	ArrayList<PlayList> devolverPlayLists();

	/**
	 * Método para recoger playlists de la base de datos.
	 */
	void recogerPlayListsDeLaBaseDeDatos();

	/**
	 * Método para obtener la cantidad de playlists.
	 * @return La cantidad de playlists.
	 */
	int cantidadDePlayList();

	/**
	 * Método para obtener la cantidad de canciones en una playlist.
	 * @return La cantidad de canciones en la playlist.
	 */
	int cantidadDeCancionesEnPlayList();

	/**
	 * Método para crear una nueva playlist.
	 * @param nombre El nombre de la nueva playlist.
	 */
	void crearPlayList(String nombre);

	/**
	 * Método para borrar una playlist.
	 * @param playList La playlist a borrar.
	 */
	void borrarPlayList(PlayList playList);

	/**
	 * Método para borrar una playlist como administrador.
	 * @param playList La playlist a borrar.
	 */
	void borrarPlayListAdmin(PlayList playList);

	/**
	 * Método para editar la información de un artista como administrador.
	 * @param nombre El nuevo nombre del artista.
	 * @param id El ID del artista a editar.
	 * @param desc La nueva descripción del artista.
	 * @param tipo El nuevo tipo de artista.
	 * @return True si la edición es exitosa, False si no.
	 */
	boolean editarArtistaAdministrador(String nombre, String id, String desc, String tipo);

	/**
	 * Método para eliminar una canción como administrador.
	 * @param id El ID de la canción a eliminar.
	 * @return True si la eliminación es exitosa, False si no.
	 */
	boolean eliminarCancionAdministrador(String id);

	/**
	 * Método para eliminar un artista como administrador.
	 * @param id El ID del artista a eliminar.
	 * @return True si la eliminación es exitosa, False si no.
	 */
	boolean eliminarArtistaAdministrador(String id);

	/**
	 * Método para eliminar un álbum como administrador.
	 * @param id El ID del álbum a eliminar.
	 * @return True si la eliminación es exitosa, False si no.
	 */
	boolean eliminarAlbumAdministrador(String id);

	/**
	 * Método para añadir un músico a la base de datos.
	 * @param nombre El nombre del músico.
	 * @param desc La descripción del músico.
	 * @param tipo El tipo del músico.
	 * @return True si la inserción es exitosa, False si no.
	 */
	boolean añadirMusicoABaseDeDatos(String nombre, String desc, String tipo);

	/**
	 * Método para guardar un podcaster.
	 * @param p El podcaster a guardar.
	 */
	void guardarPodcaster(Podcaster p);

	/**
	 * Método para devolver un podcaster.
	 * @return El objeto Podcaster correspondiente al podcaster.
	 */
	Podcaster devolverPodcaster();

	/**
	 * Método para devolver una lista de podcasters.
	 * @return Un ArrayList de objetos Podcaster.
	 */
	ArrayList<Podcaster> devolverPodcasters();

	/**
	 * Método para recoger podcasters de la base de datos.
	 */
	void recogerPodcastersDeLaBaseDeDatos();

	/**
	 * Método para devolver una lista de podcasts.
	 * @return Un ArrayList de objetos Podcast.
	 */
	ArrayList<Podcast> devolverPodcasts();

	/**
	 * Método para recoger podcasts de la base de datos.
	 */
	void recogerPodcastsDeLaBaseDeDatos();

	/**
	 * Método para recoger podcasts de la base de datos con audio.
	 */
	void recogerPodcastsDeLaBaseDeDatosConAudio();

	/**
	 * Método para editar la información de un álbum como administrador.
	 * @param id El ID del álbum a editar.
	 * @param nombre El nuevo nombre del álbum.
	 * @param año El nuevo año de lanzamiento del álbum.
	 * @param genero El nuevo género del álbum.
	 * @return True si la edición es exitosa, False si no.
	 */
	boolean editarAlbumAdministrador(String id, String nombre, String año, String genero);

	/**
	 * Método para editar la información de una canción como administrador.
	 * @param ldAudio El nuevo enlace de audio de la canción.
	 * @param textidcancion El nuevo texto del ID de la canción.
	 * @param nombreAudio El nuevo nombre del archivo de audio de la canción.
	 * @param textduracion El nuevo texto de duración de la canción.
	 * @param Idalbum El ID del álbum al que pertenece la canción.
	 * @return True si la edición es exitosa, False si no.
	 */
	boolean editarCancionAdministrador(String ldAudio, String textidcancion, String nombreAudio, String textduracion,
	        String Idalbum);

	/**
	 * Método para recoger álbumes de la base de datos como administrador.
	 */
	void recogerAlbumsDeLaBaseDeDatosAdmin();

	/**
	 * Método para añadir un álbum a la base de datos.
	 * @param nombre El nombre del álbum.
	 * @param desc La descripción del álbum.
	 * @param tipo El tipo del álbum.
	 * @return True si la inserción es exitosa, False si no.
	 */
	boolean añadirAlbumABaseDeDatos(String nombre, String desc, String tipo);

	/**
	 * Método para recoger canciones de la base de datos como administrador.
	 */
	void recogerCancionesDeLaBaseDeDatosAdmin();

	/**
	 * Método para escribir en un fichero.
	 */
	void escribirFichero();

	/**
	 * Método para insertar un fichero.
	 * @param fichero El fichero a insertar.
	 */
	void insertarFichero(File fichero);

	/**
	 * Método para insertar canciones en una playlist.
	 */
	void insertarCacionesEnPlayList();

	/**
	 * Método para crear una nueva playlist.
	 * @param nombre El nombre de la nueva playlist.
	 */
	void nuevaPlayList(String nombre);

	/**
	 * Método para insertar una canción en una playlist.
	 * @param cancion La canción a insertar en la playlist.
	 */
	void insertarCacionEnPlayList(Cancion cancion);

}