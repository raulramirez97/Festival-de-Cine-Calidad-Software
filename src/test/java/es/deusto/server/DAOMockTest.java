package es.deusto.server;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.rmi.RemoteException;

import es.deusto.server.data.UsuarioDTO;
import org.junit.Before;
import org.junit.Test;
//import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import es.deusto.server.dao.IDAO;
import es.deusto.server.data.Message;
import es.deusto.server.data.DirectedMessage;
import junit.framework.JUnit4TestAdapter;

/**
 * 
 * @author cortazar Testing of the Service Layer, mocking the DAO layer
 */
@RunWith(MockitoJUnitRunner.class)
public class DAOMockTest {

	/*TODO: Tests y elementos a agregar:
	Test unitario con JUnit 3 / 4.
	Test de rendimiento con ContiPERF.
	Mocks con Mockito.
	Visualización de carga con Visual VM.
	Integración de CI con TravisCI.
	EXTRA (para Sprint 3): Documentación con Doxygen.
	 */
	FestivalCineManager m;

	@Mock
    IDAO dao;

	public static junit.framework.Test suite() {
		return new JUnit4TestAdapter(DAOMockTest.class);
	}

	@Before
	public void setUp() throws Exception {
		m = new FestivalCineManager(dao);

	}

	@Test
	// @Ignore
	public void testRegisterUserCorrectly() {

		// Stubbing - return a given value when a specific method is called
		when(dao.retrieveUsuario("admin")).thenReturn(null);
		m.registerUser(new UsuarioDTO("admin", "admin"));

		// Use ArgumentCaptor to capture argument values for further assertions.
		ArgumentCaptor<UsuarioDTO> userCaptor = ArgumentCaptor.forClass(UsuarioDTO.class);

		// Setting expectations - the method storeUser() is called once and the argument
		// is intercepted
		verify(dao).storeUsuario(userCaptor.capture());
		UsuarioDTO newUsuarioDTO = userCaptor.getValue();
		System.out.println("Registering mock new user: " + newUsuarioDTO.getLogin());

		assertEquals("admin", newUsuarioDTO.getLogin());

	}

	@Test
	public void testRegisterUserAlreadyExists() {
		UsuarioDTO u = new UsuarioDTO("admin", "admin");

		when(dao.retrieveUsuario("admin")).thenReturn(u);
		// When the user exist, we update the password
		m.registerUser(new UsuarioDTO("admin", "admin"));

		ArgumentCaptor<UsuarioDTO> userCaptor = ArgumentCaptor.forClass(UsuarioDTO.class);
		verify(dao).updateUsuario(userCaptor.capture());
		UsuarioDTO newUsuarioDTO = userCaptor.getValue();
		System.out.println("Changing password of mock user: " + newUsuarioDTO.getPassword());
		assertEquals("admin", newUsuarioDTO.getPassword());

	}

	@Test
	public void testSayMessageUserValid() throws RemoteException {
		// Setting up the test data
		UsuarioDTO u = new UsuarioDTO("admin", "admin");
		Message mes = new Message("testing message");
		mes.setUsuarioDTO(u);
		u.addMessage(mes);

		// Stubbing
		when(dao.retrieveUsuario("admin")).thenReturn(u);

		// Calling the method under test

		m.sayMessage(new DirectedMessage("admin", "admin", "testing message"));

		// Verifying the outcome
		ArgumentCaptor<UsuarioDTO> userCaptor = ArgumentCaptor.forClass(UsuarioDTO.class);
		verify(dao).updateUsuario(userCaptor.capture());
		UsuarioDTO newUsuarioDTO = userCaptor.getValue();

		assertEquals("admin", newUsuarioDTO.getMessages().get(0).getUsuarioDTO().getLogin());
	}
}
