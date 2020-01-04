package es.deusto.client;

import es.deusto.client.gui.*;
import es.deusto.server.data.*;
import junit.framework.JUnit4TestAdapter;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.logging.Logger;

/**
 * Este bloque de código representa un conjunto de pruebas unitarias con el objetivo de validar que las ventanas
 * se generan correctamente. A estas pruebas unitarias se les ha añadido tests de rendimiento para validar que su
 * generación es rápida.
 * @author Grupo RMBJ
 * @version 3.0
 * @since 3.0
 */

public class GeneracionVentanasTest {

	private ActorDTO testActorDTO;
	private PeliculaDTO testPeliculaDTO;
	private PeliculaList testPeliculaList;
	private UsuarioDTO testUsuarioDTO;
	String testName;
	String testTitle;

	static Logger logger = Logger.getLogger(GeneracionVentanasTest.class.getName());

	public static junit.framework.Test suite() {
		return new JUnit4TestAdapter(GeneracionVentanasTest.class);
	}

	@Before
	public void setUp() {}

	@Test (timeout = 18000)
	public void testProgressBar() {
		testName = "testProgressBar";
		testTitle = testName;
        ProgressBar testPB = new ProgressBar(testTitle);
        testPB.setVisible(true);
	}

	@Test
	public void testMenuAnonimo() {
		testName = "testMenuAnonimo";
		testActorDTO = new ActorDTO("ID1", "Test", "Cage", 40);
		testPeliculaDTO = new PeliculaDTO("Test", "Este es el inicio de un gran test",
				"TestingDrama", 10, 2019, "Benat",
				"http://www.iliketoquote.com/save-the-drama-for-your-mama/", 10.0,
				"Premio Cannes al mejor Drama", null,"Drama",
				testActorDTO.getNombre() + " "+ testActorDTO.getApellido(), "MyDrama");
		testPeliculaList = new PeliculaList();
		testPeliculaList.addPeliculaDTO(testPeliculaDTO);
		MenuAnonimo testMA = new MenuAnonimo(testPeliculaList);
		testMA.setVisible(true);
	}
	@Test
	public void testMenu() {
		testName = "testMenu";
		testActorDTO = new ActorDTO("ID1", "Test", "Cage", 40);
		testPeliculaDTO = new PeliculaDTO("Test", "Este es el inicio de un gran test",
				"TestingDrama", 10, 2019, "Benat",
				"http://www.iliketoquote.com/save-the-drama-for-your-mama/", 10.0,
				"Premio Cannes al mejor Drama", null,"Drama",
				testActorDTO.getNombre() + " "+ testActorDTO.getApellido(), "MyDrama");
		testPeliculaList = new PeliculaList();
		testPeliculaList.addPeliculaDTO(testPeliculaDTO);
		testUsuarioDTO = new UsuarioDTO("usuario", "pass");

		Menu testM = new Menu(testPeliculaList, testUsuarioDTO);
		testM.setVisible(true);
	}
	@Test
	public void testMenuAdmin() {
		testName = "testMenuAdmin";
		testActorDTO = new ActorDTO("ID1", "Test", "Cage", 40);
		testPeliculaDTO = new PeliculaDTO("Test", "Este es el inicio de un gran test",
				"TestingDrama", 10, 2019, "Benat",
				"http://www.iliketoquote.com/save-the-drama-for-your-mama/", 10.0,
				"Premio Cannes al mejor Drama", null,"Drama",
				testActorDTO.getNombre() + " "+ testActorDTO.getApellido(), "MyDrama");
		testPeliculaList = new PeliculaList();
		testPeliculaList.addPeliculaDTO(testPeliculaDTO);
		testUsuarioDTO = new UsuarioDTO("admin", "admin");

		Menu testM = new Menu(testPeliculaList, testUsuarioDTO);
		testM.setVisible(true);
	}
	@Test
	public void testInicio() {
		testName = "testInicio";
		Inicio testI = new Inicio();
		testI.setVisible(true);
	}
	@Test
	public void testAlta() {
		testName = "testAlta";
		Alta testA = new Alta();
		testA.setVisible(true);
	}
	@Test
	public void testLogin() {
		testName = "testLogin";
		Login testL = new Login();
		testL.setVisible(true);
	}
	@Test
	public void testCreacionActor() {
		testName = "testCreacionActor";
		testUsuarioDTO = new UsuarioDTO("admin", "admin");
		CreacionActor testCA = new CreacionActor(testUsuarioDTO);
		testCA.setVisible(true);
	}
	@Test
	public void testCreacionPelicula() {
		testName = "testCreacionPelicula";
		testUsuarioDTO = new UsuarioDTO("admin", "admin");
		CreacionPelicula testCP = new CreacionPelicula(testUsuarioDTO);
		testCP.setVisible(true);
	}
	@Test
	public void testResultadoFiltradosAnonimo() {
		testName = "testResultadoFiltradosAnonimo";
		testActorDTO = new ActorDTO("ID1", "Test", "Cage", 40);
		testPeliculaDTO = new PeliculaDTO("Test", "Este es el inicio de un gran test",
				"TestingDrama", 10, 2019, "Benat",
				"http://www.iliketoquote.com/save-the-drama-for-your-mama/", 10.0,
				"Premio Cannes al mejor Drama", null,"Drama",
				testActorDTO.getNombre() + " "+ testActorDTO.getApellido(), "MyDrama");
		testPeliculaList = new PeliculaList();
		testPeliculaList.addPeliculaDTO(testPeliculaDTO);

		ResultadoFiltradosAnonimo testRFA = new ResultadoFiltradosAnonimo(testPeliculaList);
		testRFA.setVisible(true);
	}
	@Test
	public void testResultadoFiltrados() {
		testName = "testResultadoFiltrados";
		testActorDTO = new ActorDTO("ID1", "Test", "Cage", 40);
		testPeliculaDTO = new PeliculaDTO("Test", "Este es el inicio de un gran test",
				"TestingDrama", 10, 2019, "Benat",
				"http://www.iliketoquote.com/save-the-drama-for-your-mama/", 10.0,
				"Premio Cannes al mejor Drama", null,"Drama",
				testActorDTO.getNombre() + " "+ testActorDTO.getApellido(), "MyDrama");
		testPeliculaList = new PeliculaList();
		testPeliculaList.addPeliculaDTO(testPeliculaDTO);
		testUsuarioDTO = new UsuarioDTO("usuario", "pass");

		ResultadoFiltrados testRF = new ResultadoFiltrados(testPeliculaList, testUsuarioDTO);
		testRF.setVisible(true);
	}

	@Test
	public void testInformePelicula() {
		testName = "testInformePelicula";

		testActorDTO = new ActorDTO("ID1", "Test", "Cage", 40);
		testPeliculaDTO = new PeliculaDTO("Test", "Este es el inicio de un gran test",
				"TestingDrama", 10, 2019, "Benat",
				"http://www.iliketoquote.com/save-the-drama-for-your-mama/", 10.0,
				"Premio Cannes al mejor Drama", null,"Drama",
				testActorDTO.getNombre() + " "+ testActorDTO.getApellido(), "MyDrama");
		testUsuarioDTO = new UsuarioDTO("usuario", "pass");

		InformePelicula testIP = new InformePelicula(testPeliculaDTO, testUsuarioDTO);
		testIP.setVisible(true);
	}
	@Test
	public void testInformePeliculaAnonimo() {
		testName = "testInformePeliculaAnonimo";

		testActorDTO = new ActorDTO("ID1", "Test", "Cage", 40);
		testPeliculaDTO = new PeliculaDTO("Test", "Este es el inicio de un gran test",
				"TestingDrama", 10, 2019, "Benat",
				"http://www.iliketoquote.com/save-the-drama-for-your-mama/", 10.0,
				"Premio Cannes al mejor Drama", null,"Drama",
				testActorDTO.getNombre() + " "+ testActorDTO.getApellido(), "MyDrama");

		InformePeliculaAnonimo testIPA = new InformePeliculaAnonimo(testPeliculaDTO);
		testIPA.setVisible(true);
	}
	@Test
	public void testComentarPelicula() {
		testName = "testInformePeliculaAnonimo";

		testActorDTO = new ActorDTO("ID1", "Test", "Cage", 40);
		testPeliculaDTO = new PeliculaDTO("Test", "Este es el inicio de un gran test",
				"TestingDrama", 10, 2019, "Benat",
				"http://www.iliketoquote.com/save-the-drama-for-your-mama/", 10.0,
				"Premio Cannes al mejor Drama", null,"Drama",
				testActorDTO.getNombre() + " "+ testActorDTO.getApellido(), "MyDrama");
		testUsuarioDTO = new UsuarioDTO("usuario", "pass");

		ComentarPelicula testCP = new ComentarPelicula(testUsuarioDTO, testPeliculaDTO);
		testCP.setVisible(true);
	}

	@Test
	public void testVerComentariosPelicula() {
		testName = "testVerComentariosPelicula";

		testActorDTO = new ActorDTO("ID1", "Test", "Cage", 40);
		testPeliculaDTO = new PeliculaDTO("Test", "Este es el inicio de un gran test",
				"TestingDrama", 10, 2019, "Benat",
				"http://www.iliketoquote.com/save-the-drama-for-your-mama/", 10.0,
				"Premio Cannes al mejor Drama", null,"Drama",
				testActorDTO.getNombre() + " "+ testActorDTO.getApellido(), "MyDrama");
		testUsuarioDTO = new UsuarioDTO("usuario", "pass");

		VerComentariosPelicula testVCP = new VerComentariosPelicula(testUsuarioDTO, testPeliculaDTO);
		testVCP.setVisible(true);
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
