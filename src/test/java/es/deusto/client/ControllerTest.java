package es.deusto.client;

import junit.framework.JUnit4TestAdapter;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.logging.Logger;

/**
 * Este bloque de código representa un conjunto de pruebas unitarias con el objetivo de validar que el Controller
 * busca la conexión correctamente. Por ello se ha incluido como excepción esperada la javax.ws.rs.ProcessingException,
 * dado que no se ha generado un Servlet que sustituya al Servlet JeTTY creado al lanzar el servidor vía Maven.
 * @author Grupo RMBJ
 * @version 3.0
 * @since 3.0
 */
public class ControllerTest {
//
	private FestivalCineController fcc;
	String testName;
    String [] args = new String[2];

	static Logger logger = Logger.getLogger(ControllerTest.class.getName());

	public static junit.framework.Test suite() {
		return new JUnit4TestAdapter(ControllerTest.class);
	}

	@Before
	public void setUp() {
		args[0]="0.0.0.0";
		args[1]="8080";
		fcc = new FestivalCineController(args, testName);
	}

	@Test (expected = javax.ws.rs.ProcessingException.class)
	public void testFixtureGeneration() {
		testName = "testFixtureGeneration";
		fcc.generateFixtures();
	}

	@Test (expected = javax.ws.rs.ProcessingException.class)
	public void testRegisterUser() {
		testName = "testRegisterUser";
		fcc.registerUser("test","test");
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
