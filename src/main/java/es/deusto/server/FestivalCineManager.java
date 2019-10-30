package es.deusto.server;

import es.deusto.server.data.Usuario;
import es.deusto.server.db.DBManager;
import es.deusto.server.db.IDAO;
import es.deusto.server.dto.UsuarioDTO;
import es.deusto.server.remote.IUsuarioAdmin;
import es.deusto.server.remote.UsuarioAdmin;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.rmi.RemoteException;
import java.util.ArrayList;

@Path("server")
@Produces(MediaType.APPLICATION_JSON)
public class FestivalCineManager {

	private int cont = 0;
	IDAO dao;
	private IUsuarioAdmin usuarioService;

	/**
	 * dao = DBManager.getInstance();
	 * usuarioService = new UsuarioAdmin();
	 */

	public FestivalCineManager() {
		super();
		dao = DBManager.getInstance();
		usuarioService = new UsuarioAdmin();
	}

	public FestivalCineManager(IDAO udao) {
		super();
		dao = DBManager.getInstance();
		usuarioService = new UsuarioAdmin();
		//dao = udao;
	}
/*
	@GET
	@Path("/register")
	public Response registerUsuario() {

		return Response.ok().build();*/
		/*System.out.println("Checking whether the usuario already exists or not: '" + usuarioData.getEmail() + "'");
		usuarioService.generarNuevoUsuario(usuarioData.getEmail(), usuarioData.getContrasena());
		return Response.ok().build();*/
	//}

	@POST
	@Path("/register")
	public Response registerUsuario(UsuarioDTO usuarioData) {

		return Response.ok().build();
		/*System.out.println("Checking whether the usuario already exists or not: '" + usuarioData.getEmail() + "'");
		usuarioService.generarNuevoUsuario(usuarioData.getEmail(), usuarioData.getContrasena());


		/*return Response.ok().build();*/
	}
		}
		/*ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
		try {
			listaUsuarios = dao.getUsuarios();
			for(Usuario aux : listaUsuarios)
			{
				if(aux.getEmail()compareTo(msg)==0)
					existe=0;
			}
			//usuario = dao.retrieveUsuario(usuarioData.getLogin());
		} catch (Exception e) {
			System.out.println("Exception launched: " + e.getMessage());
		}*/

		/*if (usuario != null) {
			System.out.println("The usuario exists. So, setting new password for Usuario: " + usuarioData.getLogin());
			usuario.setPassword(usuarioData.getPassword());
			System.out.println("Password set for Usuario: " + usuarioData.getLogin());
			dao.updateUsuario(usuario);
		} else {
			System.out.println("Creating usuario: " + usuarioData.getLogin());
			usuario = new Usuario(usuarioData.getLogin(), usuarioData.getPassword());
			dao.storeUsuario(usuario);
			System.out.println("Usuario created: " + usuarioData.getLogin());
		}*/



	/*@POST
	@Path("/sayMessage")
	public Response sayMessage(DirectedMessage directedMessage) {
		System.out.println("Retrieving the usuario: '" + directedMessage.getUsuario().getLogin() + "'");
		Usuario usuario = null;
		try {
			usuario = dao.retrieveUsuario(directedMessage.getUsuario().getLogin());
		} catch (Exception e) {
			System.out.println("Exception launched: " + e.getMessage());
		}

		System.out.println("Usuario retrieved: " + usuario);
		if (usuario != null) {
			Message message = new Message(directedMessage.getMessage());
			message.setUsuario(usuario);
			usuario.getMessages().add(message);
			dao.updateUsuario(usuario);
			cont++;
			System.out.println(" * Client number: " + cont);
			return Response.ok(directedMessage.getMessage()).build();
		} else {
			System.out.println("Login details supplied for message delivery are not correct");
			return Response.status(Status.BAD_REQUEST).entity("Login details supplied for message delivery are not correct").build();
		}
	}

	@GET
	@Path("/messages")
	public Response getUsuarioMessages(@QueryParam("login") String login) {
		System.out.println("Checking whether the usuario already exits or not: '" + login + "'");
		Usuario usuario = null;
		try {
			usuario = dao.retrieveUsuario(login);
		} catch (Exception e) {
			System.out.println("Exception launched: " + e.getMessage());
		}

		if (usuario != null) {
			System.out.println("Returning the messages to the client: " + login);

			MessageList messageList = new MessageList();
			for (Message m : usuario.getMessages()) {
				messageList.addMessage(m);
			}
			return Response.ok(messageList).build();
		} else {
			System.out.println("The usuario does not exist, no possibility of retrieving messages ...: " + login);
			return Response.status(Status.BAD_REQUEST).entity("Login details supplied for message delivery are not correct").build();
		}
	}*/

