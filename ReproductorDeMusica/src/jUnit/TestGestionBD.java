package jUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import controlador.GestionBD;
import modelo.Album;
import modelo.Cancion;
import modelo.Cliente;
import modelo.Musico;
import modelo.PlayList;
import modelo.Podcaster;

public class TestGestionBD {

	private static GestionBD conexion;
	private static Cliente cliente;
	private static Cancion cancion;
	private static Album album;
	private static Musico musico;
	private static Podcaster podcaster;
	private static PlayList playList;

	/**
	 * TODAS los test comentados son funcionales pero estan comentados debido a que
	 * interfieren con el tiempo de uso de los test y el correcto funcionamiento de
	 * otros
	 */

	@BeforeClass
	public static void iniciarConexion() {
		conexion = new GestionBD();
		cliente = new Cliente("C14ef", "Kaiet", "Zarzosa", "ES", "a", "a", "2005-05-22", "2024-05-06", "Free");
		musico = new Musico("MU490", "Clase", null, "grupo", "Un grupo que cuanta la histria de unos increibles");
		album = new Album("AL82a", "Grupo1", "2024-05-17", "Rock", null, "MU490", 4);
		cancion = new Cancion("A716b", "El fanatico de los pepitos", 120, null, "CAN01", "AL82a");
		podcaster = new Podcaster("POD04", "Testing serio", null, "Podcaster de prueba con canciones");
		playList = new PlayList("5", "Favoritos", "2024-05-10");
	}

	@AfterClass
	public static void cerrarConexion() {
		conexion.cerrarConexion();
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testVerificarUsuario() {
		assertFalse(conexion.verificarUsuario(cliente.getUsuario()));
	}

	@Test
	public void testLogin() {
		assertTrue(conexion.login(cliente.getUsuario(), cliente.getContraseña()));
	}

	@Test
	public void testInsertUsuario() {
		assertFalse(conexion.insertUsuario(cliente));
	}

	@Test
	public void testPedirUsuario() {
		assertEquals(cliente.getUsuario(), conexion.pedirUsuario(cliente.getUsuario()).getUsuario());
	}

	@Test
	public void testLlenarListaMusico() {
		assertFalse(conexion.llenarListaMusico().isEmpty());
	}

	@Test
	public void testLlenarListaAlbums() {
		assertFalse(conexion.llenarListaDeAlbums(musico).isEmpty());
	}

	@Test
	public void testLlenarListaDeCanciones() {
		assertFalse(conexion.llenarListaDeCanciones(album).isEmpty());
	}

//	@Test
//	public void testLlenarListaDeCancionesConAudio() {
//		assertFalse(conexion.llenarListaDeCancionesConAudio(album).isEmpty());
//	}

	@Test
	public void testLlenarListaPodcaster() {
		assertFalse(conexion.llenarListaPodcaster().isEmpty());
	}

	@Test
	public void testLlenarListaDePodcasts() {
		assertFalse(conexion.llenarListaDePodcasts(podcaster).isEmpty());
	}

//	@Test
//	public void testLlenarListaDePodcastsConAudio() {
//		assertFalse(conexion.llenarListaDePodcastsConAudio(podcaster).isEmpty());
//	}

	@Test
	public void testLlenarListaDeAlbumsAdmin() {
		assertFalse(conexion.llenarListaDeAlbumsAdmin().isEmpty());
	}

	@Test
	public void testLlenarListaDeCancionesAdmin() {
		assertFalse(conexion.llenarListaDeCancionesAdmin().isEmpty());
	}

	@Test
	public void testEliminarArtistaAdministrador() {
		assertTrue(conexion.eliminarArtistaAdministrador("0001"));
	}

	@Test
	public void testEditarArtistaAdministrador() {
		assertTrue(conexion.editarArtistaAdministrador(musico.getNombre(), musico.getId(), musico.getDescripcion(),
				musico.getClase()));
	}

	@Test
	public void testInsertNuevoMusico() {
		assertFalse(conexion.insertNuevoMusico(musico.getNombre(), musico.getDescripcion(), musico.getClase()));
	}

	@Test
	public void testEliminarAlbumAdministrador() {
		assertTrue(conexion.eliminarAlbumAdministrador("0001"));
	}

	@Test
	public void testEditarAlbumAdministrador() {
		assertFalse(conexion.editarAlbumAdministrador(album.getIdAlbum(), album.getTitulo(), album.getGenero(),
				album.getAño()));
	}

	@Test
	public void testInsertNuevoAlbum() {
		assertFalse(
				conexion.insertNuevoAlbum(album.getIdAlbum(), album.getTitulo(), album.getGenero(), album.getAño()));
	}

	@Test
	public void testEliminarCancionAdministrador() {
		assertTrue(conexion.eliminarCancionAdministrador("0001"));
	}

	@Test
	public void testEditarCancionesAdministrador() {
		assertFalse(conexion.editarCancionesAdministrador(cancion.getIdAudio(), cancion.getIdAlbum(),
				"" + cancion.getDuracion(), cancion.getNombreAudio(), cancion.getIdCancion()));
	}

//	@Test
//	public void testBuscarAnuncios() {
//		assertFalse(conexion.buscarAnuncios().isEmpty());
//	}

	@Test
	public void testLlenarListaDePlaylists() {
		assertFalse(conexion.llenarListaDePlaylists(cliente).isEmpty());
	}

	@Test
	public void testLlenarListaDeCancionesPorPlaylists() {
		assertTrue(conexion.llenarListaDeCancionesPorPlayList(playList).isEmpty());
	}

//	@Test
//	public void LlenarListaDeCancionesConAudioPorPlaylists() {
//		assertFalse(conexion.llenarListaDeCancionesConAudioPorPlayList(playList).isEmpty());
//	}

	@Test
	public void testContarPlayList() {
		assertEquals(1, conexion.contarPlayList(cliente));
	}

	@Test
	public void testContarCantidadDeCancionEnPlayList() {
		assertEquals(0, conexion.contarCantidadDeCancionEnPlayList(playList));
	}

//	@Test
//	public void testCrearPlayList() {
//		assertTrue(conexion.crearPlayList("Favoritos", cliente));
//	}

	@Test
	public void testBorrarPlayList() {
		assertFalse(conexion.borrarPlayList(null));
	}

	@Test
	public void testBorrarCancionesDePlayList() {
		assertFalse(conexion.borrarCancionesDePlayList(null));
	}

//	@Test
//	public void insertarCancionesEnPlayList() {
//		assertTrue(conexion.insertarCancionesEnPlayList(playList.getIDList(), null));
//	}
}
