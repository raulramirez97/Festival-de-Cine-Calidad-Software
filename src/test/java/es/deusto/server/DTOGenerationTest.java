package es.deusto.server;

import es.deusto.server.data.*;
import junit.framework.JUnit4TestAdapter;
import org.databene.contiperf.PerfTest;
import org.databene.contiperf.Required;
import org.databene.contiperf.junit.ContiPerfRule;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.ArrayList;
import java.util.logging.Logger;

import static org.junit.Assert.*;

//import org.junit.Ignore;

/**
 * Este bloque de código representa un conjunto de pruebas unitarias con el objetivo de validar que las clases DTO
 * se generan correctamente, tanto en su contenido como en el proceso de creación (p. ej. para añadir un ComentarioDTO
 * a una PeliculaDTO). A estas pruebas unitarias se les ha añadido tests de rendimiento para validar que su generación
 * es rápida.
 * @author Grupo RMBJ
 * @version 3.0
 * @since 2.0
 */
@PerfTest(invocations = 3)
@Required(max = 100, average = 50)
public class DTOGenerationTest {

	private ActorDTO testActorDTO;
	private ComentarioDTO testComentarioDTO;
	private PeliculaDTO testPeliculaDTO;
	private UsuarioDTO testUsuarioDTO;
	private ValoracionDTO testValoracionDTO;
	String testName;

	static Logger logger = Logger.getLogger(DTOGenerationTest.class.getName());

	@Rule
	public ContiPerfRule rule = new ContiPerfRule();

	public static junit.framework.Test suite() {
		return new JUnit4TestAdapter(DTOGenerationTest.class);
	}

	@Before
	public void setUp() {}

	@Test
	public void testGenerateUsuarioDTOCorrectly() {
		testName = "testGenerateUsuarioDTOCorrectly";
		testUsuarioDTO = new UsuarioDTO("usuario", "pass");
		assertEquals("usuario",testUsuarioDTO.getLogin());
		assertEquals("pass",testUsuarioDTO.getPassword());
		assertTrue(testUsuarioDTO.getMessages().size()==0);
	}
	@Test
	public void testGenerateActorDTOCorrectly() {
		testName = "testGenerateActorDTOCorrectly";
		testActorDTO = new ActorDTO("ID1", "Test", "Cage", 40);
		assertEquals("ID1",testActorDTO.getIdentificador());
		assertEquals("Test",testActorDTO.getNombre());
		assertFalse(testActorDTO.getApellido() == "Test");
		assertEquals("Cage",testActorDTO.getApellido());
		assertTrue(testActorDTO.getEdad() == 40);
	}
	@Test
	public void testGeneratePeliculaDTOCorrectly() {
		testName = "testGeneratePeliculaDTOCorrectly";
		testActorDTO = new ActorDTO("ID1", "Test", "Cage", 40);

		testPeliculaDTO = new PeliculaDTO("Test", "Este es el inicio de un gran test",
				"TestingDrama", 10, 2019, "Benat",
				"http://www.iliketoquote.com/save-the-drama-for-your-mama/", 10.0,
				"Premio Cannes al mejor Drama", null,"Drama",
				testActorDTO.getNombre() + " "+ testActorDTO.getApellido());
		assertEquals("Test",testPeliculaDTO.getTitulo());
		assertEquals("Este es el inicio de un gran test",testPeliculaDTO.getSinopsis());
		assertEquals("TestingDrama",testPeliculaDTO.getGenero());
		assertFalse(testPeliculaDTO.getDuracion()==0);
		assertEquals(2019,testPeliculaDTO.getAnyo());
		assertNotEquals("Steven Spielberg",testPeliculaDTO.getDirector());
		assertNotEquals("MIURL",testPeliculaDTO.getEnlaceTrailer());
		assertEquals(10.0, testPeliculaDTO.getValoracionMedia(), 0.01);
		assertEquals("Premio Cannes al mejor Drama",testPeliculaDTO.getPremios());
		assertTrue(testPeliculaDTO.getComentarios() == null);
		assertEquals("Drama",testPeliculaDTO.getSeccionFestival());
		assertEquals("Test Cage",testPeliculaDTO.getActores());
	}
	@Test
	public void testGenerateValoracionDTOCorrectly() {
		testName = "testGenerateValoracionDTOCorrectly";
		testValoracionDTO = new ValoracionDTO("Test", 10.0);
		assertTrue("Test".compareTo(testValoracionDTO.getTitulo())==0);
		assertFalse(testValoracionDTO.getValoracion()<9);
		ValoracionDTO expected = new ValoracionDTO(1, "AnotherTest", 7);
		assertEquals(testValoracionDTO.getId(), expected.getId());
	}
	@Test
	public void testGenerateComentarioDTOCorrectly() {
		testName = "testGenerateComentarioDTOCorrectly";
		testUsuarioDTO = new UsuarioDTO("usuario", "pass");

		testActorDTO = new ActorDTO("ID1", "Test", "Cage", 40);

		testPeliculaDTO = new PeliculaDTO("Test", "Este es el inicio de un gran test",
				"TestingDrama", 10, 2019, "Benat",
				"http://www.iliketoquote.com/save-the-drama-for-your-mama/", 10.0,
				"Premio Cannes al mejor Drama", null,"Drama",
				testActorDTO.getNombre() + " "+ testActorDTO.getApellido());

		long currentTime = System.currentTimeMillis();
		testComentarioDTO = new ComentarioDTO(testPeliculaDTO, testUsuarioDTO.getLogin(),
				"Es una gran pelicula de test!");
		assertEquals("Test", testComentarioDTO.getPelicula().getTitulo());
		assertEquals("usuario", testComentarioDTO.getUsuario());
		assertFalse(testComentarioDTO.getContenido().compareTo("Es una basurilla de test")==0);
		logger.info("Comprobando que el ComentarioDTO se ha creado en una diferencia de tiempo razonable...");
		assertEquals(currentTime,testComentarioDTO.getTimestamp(),0.5);
	}

	@Test (expected=NullPointerException.class)
	public void testSetComentarioDTOIncorrectly() {
		testName = "testSetComentarioDTOIncorrectly";
		testUsuarioDTO = new UsuarioDTO("usuario", "pass");

		testActorDTO = new ActorDTO("ID1", "Test", "Cage", 40);

		testPeliculaDTO = new PeliculaDTO("Test", "Este es el inicio de un gran test",
				"TestingDrama", 10, 2019, "Benat",
				"http://www.iliketoquote.com/save-the-drama-for-your-mama/", 10.0,
				"Premio Cannes al mejor Drama", null,"Drama",
				testActorDTO.getNombre() + " "+ testActorDTO.getApellido());

		testComentarioDTO = new ComentarioDTO(testPeliculaDTO, testUsuarioDTO.getLogin(),
				"Es una gran pelicula de test!");
		logger.info("Generando excepción al settear erróneamente el ComentarioDTO...");
		testPeliculaDTO.setComentario(testComentarioDTO);
	}

	@Test
	public void testSetComentarioDTOCorrectly() {
		testName = "testSetComentarioDTOCorrectly";
		testUsuarioDTO = new UsuarioDTO("usuario", "pass");

		testActorDTO = new ActorDTO("ID1", "Test", "Cage", 40);

		testPeliculaDTO = new PeliculaDTO("Test", "Este es el inicio de un gran test",
				"TestingDrama", 10, 2019, "Benat",
				"http://www.iliketoquote.com/save-the-drama-for-your-mama/", 10.0,
				"Premio Cannes al mejor Drama", null,"Drama",
				testActorDTO.getNombre() + " "+ testActorDTO.getApellido());

		testComentarioDTO = new ComentarioDTO(testPeliculaDTO, testUsuarioDTO.getLogin(),
				"Es una gran pelicula de test!");
		ArrayList<ComentarioDTO> listaComentarios = new ArrayList<>();
		testPeliculaDTO.setComentarios(listaComentarios);
		testPeliculaDTO.setComentario(testComentarioDTO);
		logger.info("Ejecutando aserto al insertar un ComentarioDTO correctamente...");
		assertEquals("Es una gran pelicula de test!",
				testComentarioDTO.getPelicula().getComentarios().get(0).getContenido());

		ArrayList<ComentarioDTO> nuevaListaComentarios = new ArrayList<>();
		nuevaListaComentarios.add(testComentarioDTO);
		testPeliculaDTO.setComentarios(nuevaListaComentarios);
		logger.info("Ejecutando aserto al insertar la lista de ComentariosDTO...");
		assertEquals("Es una gran pelicula de test!",
				testComentarioDTO.getPelicula().getComentarios().get(0).getContenido());
	}

	/**
	 * El objetivo de este método es mostrar por pantalla al ejecutar Maven que los tests unitarios se han realizado
	 * correctamente.
	 */
	@After
	public void printLastMessage() {
		logger.info(testName + " completado satisfactoriamente.");
	}
}
