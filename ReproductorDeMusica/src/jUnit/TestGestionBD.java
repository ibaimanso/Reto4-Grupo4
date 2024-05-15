package jUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

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
import modelo.Podcast;
import modelo.Podcaster;

public class TestGestionBD {
	
	private static GestionBD conexion;
	private static Cliente cliente;
	private static Cancion cancion;
	private static Podcast podcast;
	private static Album album;
	private static Musico musico;
	private static Podcaster podcaster;

	@BeforeClass
	public static void iniciarConexion() {
		conexion = new GestionBD();
		cliente = new Cliente("C14ef", "Kaiet", "Zarzosa", "ES", "a", "a", "2005-05-22", "2024-05-06", "Free");
		musico = new Musico("MU490", "Clase", null, "grupo", "Un grupo que cuanta la histria de unos increibles");
		album = new Album("AL82a", "Grupo1", "2024-05-17", "Rock", null, "MU490", 4);
		cancion = new Cancion("A716b", "El fanatico de los pepitos", 120, null, "CAN01", "AL82a");
		podcaster = new Podcaster("POD04", "Testing serio", null, "Podcaster de prueba con canciones");
		
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
		assertEquals(cliente.getUsuario(),conexion.pedirUsuario(cliente.getUsuario()).getUsuario());
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
	public void testEliminarArtistaAdministrador() {
		assertTrue(conexion.eliminarArtistaAdministrador("0001"));
	}
	
	@Test
	public void testEditarArtistaAdministrador() {
		assertFalse(conexion.editarArtistaAdministrador(musico.getNombre(), musico.getId(), musico.getDescripcion(), musico.getClase()));
	}
	
	@Test
	public void testInsertNuevoMusico() {
		assertFalse(conexion.editarArtistaAdministrador(musico.getNombre(), musico.getId(), musico.getDescripcion(), musico.getClase()));
	}
	
	
	@Test
	public void testEditarAlbumAdministrador() {
		assertTrue(conexion.editarAlbumAdministrador("01111", "", "", ""));
	}
	
	
}
