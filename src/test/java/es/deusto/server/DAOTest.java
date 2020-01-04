package es.deusto.server;

import es.deusto.server.dao.DBManager;
import es.deusto.server.data.*;
import junit.framework.JUnit4TestAdapter;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.logging.Logger;

import static org.junit.Assert.*;
import static org.junit.Assert.assertNotEquals;

public class DAOTest {

    private ActorDTO testActorDTO;
    private PeliculaDTO testPeliculaDTO;
    private UsuarioDTO testUsuarioDTO;
    DBManager db;
    String testName;

    static Logger logger = Logger.getLogger(DAOTest.class.getName());

    public static junit.framework.Test suite() {
        return new JUnit4TestAdapter(DAOTest.class);
    }

    @Before
    public void setUp() throws Exception {
        db = new DBManager();
    }

    @Test
    public void testStoreUsuario() {
        testName = "testStoreUsuario";
        testUsuarioDTO = new UsuarioDTO("test","test");
        logger.info("Registrando UsuarioDTO de test: " + testUsuarioDTO.getLogin());
        db.storeUsuario(testUsuarioDTO);
        db.deleteUsuario(testUsuarioDTO);
    }
    @Test
    public void testRetrieveUsuario() {
        testName = "testRetrieveUsuario";
        testUsuarioDTO = new UsuarioDTO("test","test");
        logger.info("Registrando UsuarioDTO de test: " + testUsuarioDTO.getLogin());
        db.storeUsuario(testUsuarioDTO);
        testUsuarioDTO = db.retrieveUsuario("test");
        logger.info("Recuperando UsuarioDTO de test: " + testUsuarioDTO.getLogin());
        assertEquals("test",testUsuarioDTO.getLogin());
        assertEquals("test",testUsuarioDTO.getPassword());
        db.deleteUsuario(testUsuarioDTO);
    }
    @Test
    public void testUpdateUsuario() {
        testName = "testUpdateUsuario";
        testUsuarioDTO = new UsuarioDTO("test","test");
        logger.info("Registrando UsuarioDTO de test: " + testUsuarioDTO.getLogin());
        db.storeUsuario(testUsuarioDTO);
        testUsuarioDTO.setPassword("myNewPassword");
        logger.info("Modificando UsuarioDTO de test: " + testUsuarioDTO.getLogin());
        db.updateUsuario(testUsuarioDTO);
        db.deleteUsuario(testUsuarioDTO);
    }
    @Test
    public void testStoreActor() {
        testName = "testStoreActor";
        testActorDTO = new ActorDTO("ID1", "Test", "Cage", 40);
        logger.info("Registrando ActorDTO de test: " + testActorDTO.getIdentificador());
        db.storeActor(testActorDTO);
        db.deleteActor(testActorDTO);
    }
    @Test
    public void testRetrieveActor() {
        testName = "testRetrieveActor";
        testActorDTO = new ActorDTO("ID1", "Test", "Cage", 40);
        logger.info("Registrando ActorDTO de test: " + testActorDTO.getIdentificador());
        db.storeActor(testActorDTO);
        testActorDTO = db.retrieveActor("ID1");
        logger.info("Recuperando ActorDTO de test: " + testActorDTO.getIdentificador());
        assertEquals("ID1",testActorDTO.getIdentificador());
        assertEquals("Test",testActorDTO.getNombre());
        assertEquals("Cage",testActorDTO.getApellido());
        assertTrue(testActorDTO.getEdad()==40);
        db.deleteActor(testActorDTO);
    }
    @Test
    public void testUpdateActor() {
        testName = "testUpdateActor";
        testActorDTO = new ActorDTO("ID1", "Test", "Cage", 40);
        logger.info("Registrando ActorDTO de test: " + testActorDTO.getIdentificador());
        db.storeActor(testActorDTO);
        testActorDTO.setNombre("myNewTestName");
        testActorDTO.setApellido("CageTest");
        testActorDTO.setEdad(41);
        logger.info("Modificando ActorDTO de test: " + testActorDTO.getIdentificador());
        db.updateActor(testActorDTO);
        db.deleteActor(testActorDTO);
    }
    @Test
    public void testStorePelicula() {
        testName = "testStorePelicula";
        testActorDTO = new ActorDTO("ID1", "Test", "Cage", 40);
        testPeliculaDTO = new PeliculaDTO("Test", "Este es el inicio de un gran test",
                "TestingDrama", 10, 2019, "Benat",
                "http://www.iliketoquote.com/save-the-drama-for-your-mama/", 10.0,
                "Premio Cannes al mejor Drama", null,"Drama",
                testActorDTO.getNombre() + " "+ testActorDTO.getApellido(), "MyDrama");
        logger.info("Registrando PeliculaDTO de test: " + testPeliculaDTO.getTitulo());
        db.storePelicula(testPeliculaDTO);
        db.deletePelicula(testPeliculaDTO);
    }
    @Test
    public void testRetrievePelicula() {
        testName = "testRetrievePelicula";
        testActorDTO = new ActorDTO("ID1", "Test", "Cage", 40);
        testPeliculaDTO = new PeliculaDTO("Test", "Este es el inicio de un gran test",
                "TestingDrama", 10, 2019, "Benat",
                "http://www.iliketoquote.com/save-the-drama-for-your-mama/", 10.0,
                "Premio Cannes al mejor Drama", null,"Drama",
                testActorDTO.getNombre() + " "+ testActorDTO.getApellido(), "MyDrama");
        logger.info("Registrando PeliculaDTO de test: " + testPeliculaDTO.getTitulo());
        db.storePelicula(testPeliculaDTO);
        testPeliculaDTO = db.retrievePelicula("Test");
        logger.info("Recuperando PeliculaDTO de test: " + testPeliculaDTO.getTitulo());
        assertEquals("Test",testPeliculaDTO.getTitulo());
        assertEquals("Este es el inicio de un gran test",testPeliculaDTO.getSinopsis());
        assertEquals("TestingDrama",testPeliculaDTO.getGenero());
        assertFalse(testPeliculaDTO.getDuracion()==0);
        assertEquals(2019,testPeliculaDTO.getAnyo());
        assertNotEquals("Steven Spielberg",testPeliculaDTO.getDirector());
        assertNotEquals("MIURL",testPeliculaDTO.getEnlaceTrailer());
        assertEquals(10.0, testPeliculaDTO.getValoracionMedia(), 0.01);
        assertEquals("Premio Cannes al mejor Drama",testPeliculaDTO.getPremios());
        assertTrue(testPeliculaDTO.getComentarios().size() == 0);
        assertEquals("Drama",testPeliculaDTO.getSeccionFestival());
        assertEquals("Test Cage",testPeliculaDTO.getActores());
        db.deletePelicula(testPeliculaDTO);
    }
    @Test
    public void testUpdatePelicula() {
        testName = "testUpdatePelicula";
        testActorDTO = new ActorDTO("ID1", "Test", "Cage", 40);
        testPeliculaDTO = new PeliculaDTO("Test", "Este es el inicio de un gran test",
                "TestingDrama", 10, 2019, "Benat",
                "http://www.iliketoquote.com/save-the-drama-for-your-mama/", 10.0,
                "Premio Cannes al mejor Drama", null,"Drama",
                testActorDTO.getNombre() + " "+ testActorDTO.getApellido(), "MyDrama");
        logger.info("Registrando PeliculaDTO de test: " + testPeliculaDTO.getTitulo());
        db.storePelicula(testPeliculaDTO);
        testPeliculaDTO.setSinopsis("myNewTestSinopsis");
        testPeliculaDTO.setGenero("myNewTestingDrama");
        testPeliculaDTO.setDuracion(11);
        testPeliculaDTO.setAnyo(2020);
        testPeliculaDTO.setDirector("myNewTestingBenat");
        testPeliculaDTO.setEnlaceTrailer("myNewTestingURL");
        testPeliculaDTO.setValoracionMedia(10.0);
        testPeliculaDTO.setPremios("Muchos y mejores");
        testPeliculaDTO.setSeccionFestival("myNewTestingDrama");
        testPeliculaDTO.setURIimagen("myNewTestingURIImagen");
        logger.info("Modificando PeliculaDTO de test: " + testPeliculaDTO.getTitulo());
        db.updatePelicula(testPeliculaDTO);
        db.deletePelicula(testPeliculaDTO);
    }
    @After
    public void printLastMessage() {
        logger.info(testName + " completado satisfactoriamente.");
    }
}
