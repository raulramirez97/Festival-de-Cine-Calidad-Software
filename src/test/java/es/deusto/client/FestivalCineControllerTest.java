package es.deusto.client;

import es.deusto.server.data.ActorList;
import es.deusto.server.data.PeliculaList;
import es.deusto.server.data.UsuarioDTO;
import junit.framework.JUnit4TestAdapter;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.servlet.ServletContainer;
import org.junit.*;

import java.net.URI;
import java.util.logging.Logger;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Este bloque de código representa un conjunto de pruebas unitarias con el
 * objetivo de validar que el Controller busca la conexión correctamente.
 * @author Grupo RMBJ
 * @version 3.0
 * @since 3.0
 */
public class FestivalCineControllerTest {

	private static FestivalCineController fcc;
	private static String testName;
    private static String [] args = new String[2];
	private static Server server;
	private static URI serverUri;
	private UsuarioDTO testUsuarioDTO;
	private ActorList testActorList;
	private PeliculaList testPeliculaList;

	static Logger logger = Logger.getLogger(FestivalCineControllerTest
			.class.getName());

	public static junit.framework.Test suite() {
		return new JUnit4TestAdapter(FestivalCineControllerTest.class);
	}

	/**
	 * Método que inicializa el Servidor y Servlet JeTTY contra el cual
	 * interactuarán los tests unitarios de esta clase.
	 * @throws Exception Excepción lanzada en caso de que el Servidor no se
	 * pueda generar correctamente.
	 */
	@BeforeClass
	public static void startJetty() throws Exception
	{
		args[0]="0.0.0.0";
		args[1]="8080";
		fcc = new FestivalCineController(args, testName);

		// Create Server
		server = new Server();
		ServerConnector connector = new ServerConnector(server);
		connector.setHost(args[0]);
		connector.setPort(Integer.parseInt(args[1])); // auto-bind to port
		server.addConnector(connector);

		ServletContextHandler context = new ServletContextHandler();
		ServletHolder defaultServ = new ServletHolder(
				"simple-jdo-jersey-dao", ServletContainer.class);
		defaultServ.setInitParameter(
				"jersey.config.server.provider.packages",
				"es.deusto.server");
		context.addServlet(defaultServ,"/rest/*");
		server.setHandler(context);

		// Start Server
		server.start();

		// Determine Base URI for Server
		String host = connector.getHost();
		if (host == null)
		{
			host = "localhost";
		}
		int port = connector.getLocalPort();
		serverUri = new URI(String.format(
				"http://%s:%s/rest/server",host,port));
	}

	@Test
	public void testFixtureGeneration() {
		testName = "testFixtureGeneration";
		logger.info("Generando fixtures de prueba:");
		fcc.generateFixtures();
	}

	@Test
	public void testRegisterUser() {
		testName = "testRegisterUser";
		logger.info("Registrando información de UsuarioDTO de prueba:");
		fcc.registerUser("testFestController",
				"testFestController");
	}
	@Test
	public void testGetUser() {
		testName = "testGetUser";
		fcc.registerUser("testFestController",
				"testFestController");
		logger.info("Recuperando información de UsuarioDTO de prueba:");
		testUsuarioDTO = fcc.getUser("testFestController",
				"testFestController");
		assertEquals("testFestController",
				testUsuarioDTO.getLogin());
		assertEquals("testFestController",
				testUsuarioDTO.getPassword());
	}
	@Test
	public void testSayMessage() {
		testName = "testSayMessage";
		String response = fcc.sayMessage("testFestController",
				"testFestController",
				"MyMessage");
		logger.info(response);
	}
	@Test
	public void testRegisterActor() {
		testName = "testRegisterActor";
		logger.info("Registrando información de ActorDTO de prueba:");
		fcc.registerActor("IDFestController",
				"FestController",
				"FestController",
				99);
	}
	@Test
	public void testGetActorList() {
		testName = "testGetActorList";
		logger.info("Recuperando información de ActoresDTO:");
		testActorList = fcc.getActorList();
		assertTrue(testActorList.getActorsDTO().size()>0);
	}
	@Test
	public void testGetPeliculaList() {
		testName = "testGetPeliculaList";
		logger.info("Recuperando información de PeliculasDTO:");
		testPeliculaList = fcc.getPeliculaList();
		assertTrue(testPeliculaList.getPeliculasDTO().size()>0);
	}

	/**
	 * El objetivo de este método es mostrar por pantalla al ejecutar Maven
	 * que los tests unitarios se han realizado correctamente.
	 */
	@After
	public void printLastMessage() {
		logger.info(testName + " completado satisfactoriamente.");
	}

	/**
	 * Método que detiene el Servidor JeTTY.
	 */
	@AfterClass
	public static void stopJetty()
	{
		try
		{
			server.stop();
		}
		catch (Exception e)
		{
			logger.warning(e.toString());
		}
	}
}
