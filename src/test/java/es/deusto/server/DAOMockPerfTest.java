package es.deusto.server;

import es.deusto.server.dao.IDAO;
import es.deusto.server.data.DirectedMessage;
import es.deusto.server.data.Message;
import es.deusto.server.data.UsuarioDTO;
import junit.framework.JUnit4TestAdapter;
import org.databene.contiperf.PerfTest;
import org.databene.contiperf.Required;
import org.databene.contiperf.junit.ContiPerfRule;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.rmi.RemoteException;
import java.util.logging.Logger;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Este bloque de código representa un testeo del patrón DAO implementado en
 * esta aplicación. Para ello, se han mockeado los retornos de la base de
 * datos y evaluado algunas operaciones del servidor con Mockito.
 * <p>Además, se han añadido algunas anotaciones de ContiPERF para evaluar el
 * coste de extracción de base de datos de estos tests.</p>
 * <p>A modo de detalle, se ha tenido que insertar el número de invocaciones
 * de los métodos de Mock a 1, porque si no Mockito lanzaba excepciones del
 * tipo <b>org.mockito.exceptions.verification.TooManyActualInvocations
 * </b>.</p>
 * @author Grupo RMBJ
 * @version 3.0
 * @since 2.0
 */
@RunWith(MockitoJUnitRunner.class)
@PerfTest(invocations = 1)
@Required(max = 1200, average = 500)
public class DAOMockPerfTest {

	FestivalCineManager m;
	String testName;

	@Mock
    IDAO dao;

	static Logger logger = Logger.getLogger(DAOMockPerfTest.class.getName());

	@Rule
	public ContiPerfRule rule = new ContiPerfRule();

	public static junit.framework.Test suite() {
		return new JUnit4TestAdapter(DAOMockPerfTest.class);
	}

	@Before
	public void setUp() throws Exception {
		m = new FestivalCineManager(dao);
	}

	@Test
	public void testRegisterDAOUserCorrectly() {
		testName = "testRegisterDAOUserCorrectly";
		when(dao.retrieveUsuario("admin")).thenReturn(null);
		m.registerUser(new UsuarioDTO("admin", "admin"));

		ArgumentCaptor<UsuarioDTO> userCaptor = ArgumentCaptor
				.forClass(UsuarioDTO.class);

		verify(dao).storeUsuario(userCaptor.capture());
		UsuarioDTO newUsuarioDTO = userCaptor.getValue();
		logger.info("Registrando nuevo UsuarioDTO: "
				+ newUsuarioDTO.getLogin());

		assertEquals("admin", newUsuarioDTO.getLogin());
	}

	@Test
	public void testRegisterDAOUserAlreadyExists() {
		testName = "testRegisterDAOUserAlreadyExists";
		UsuarioDTO u = new UsuarioDTO("admin", "admin");

		when(dao.retrieveUsuario("admin")).thenReturn(u);
		m.registerUser(new UsuarioDTO("admin", "admin"));
		ArgumentCaptor<UsuarioDTO> userCaptor = ArgumentCaptor
				.forClass(UsuarioDTO.class);
		verify(dao).updateUsuario(userCaptor.capture());
		UsuarioDTO newUsuarioDTO = userCaptor.getValue();
		logger.info("Cambiando contraseña de UsuarioDTO Mockeado: "
				+ newUsuarioDTO.getPassword());
		assertEquals("admin", newUsuarioDTO.getPassword());
	}

	@Test
	public void testSayMessageDAOUserValid() throws RemoteException {
		testName = "testSayMessageDAOUserValid";
		logger.info("Configurando información para validar "
				+ "si el envío de un mensaje es correcto...");
		UsuarioDTO u = new UsuarioDTO("admin", "admin");
		Message mes = new Message("testing message");
		mes.setUsuarioDTO(u);
		u.addMessage(mes);

		when(dao.retrieveUsuario("admin")).thenReturn(u);
		m.sayMessage(new DirectedMessage("admin", "admin",
				"testing message"));

		ArgumentCaptor<UsuarioDTO> userCaptor = ArgumentCaptor
				.forClass(UsuarioDTO.class);
		verify(dao).updateUsuario(userCaptor.capture());
		UsuarioDTO newUsuarioDTO = userCaptor.getValue();

		assertEquals("admin", newUsuarioDTO.getMessages()
				.get(0).getUsuarioDTO().getLogin());
	}
	/**
	 * El objetivo de este método es mostrar por pantalla al ejecutar Maven
	 * que los tests unitarios se han realizado correctamente.
	 */
	@After
	public void printLastMessage() {
		logger.info(testName + " completado satisfactoriamente.");
	}
}
