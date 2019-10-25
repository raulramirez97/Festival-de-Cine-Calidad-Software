package es.deusto.server;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import es.deusto.server.dao.IUserDAO;
import es.deusto.server.dao.UserDAO;
import es.deusto.server.data.DirectedMessage;
import es.deusto.server.data.Message;
import es.deusto.server.data.MessageList;
import es.deusto.server.data.User;

//TODO: Clase a modificar para encontrar analogías entre comunicación REST (aquí usada) y comunicación
//TODO: vía Sockets (usada en el proyecto de EasyBooking).

@Path("/server")
@Produces(MediaType.APPLICATION_JSON)
public class Messenger {

	private int cont = 0;
	IUserDAO dao;

	public Messenger() {
		super();
		dao = new UserDAO();
	}

	public Messenger(IUserDAO udao) {
		super();
		dao = udao;
	}

	@POST
	@Path("/register")
	public Response registerUser(User userData) {
		System.out.println("Checking whether the user already exits or not: '" + userData.getLogin() + "'");
		User user = null;
		try {
			user = dao.retrieveUser(userData.getLogin());
		} catch (Exception e) {
			System.out.println("Exception launched: " + e.getMessage());
		}

		if (user != null) {
			System.out.println("The user exists. So, setting new password for User: " + userData.getLogin());
			user.setPassword(userData.getPassword());
			System.out.println("Password set for User: " + userData.getLogin());
			dao.updateUser(user);
		} else {
			System.out.println("Creating user: " + userData.getLogin());
			user = new User(userData.getLogin(), userData.getPassword());
			dao.storeUser(user);
			System.out.println("User created: " + userData.getLogin());
		}

		return Response.ok().build();
	}

	@POST
	@Path("/sayMessage")
	public Response sayMessage(DirectedMessage directedMessage) {
		System.out.println("Retrieving the user: '" + directedMessage.getUser().getLogin() + "'");
		User user = null;
		try {
			user = dao.retrieveUser(directedMessage.getUser().getLogin());
		} catch (Exception e) {
			System.out.println("Exception launched: " + e.getMessage());
		}

		System.out.println("User retrieved: " + user);
		if (user != null) {
			Message message = new Message(directedMessage.getMessage());
			message.setUser(user);
			user.getMessages().add(message);
			dao.updateUser(user);
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
	public Response getUserMessages(@QueryParam("login") String login) {
		System.out.println("Checking whether the user already exits or not: '" + login + "'");
		User user = null;
		try {
			user = dao.retrieveUser(login);
		} catch (Exception e) {
			System.out.println("Exception launched: " + e.getMessage());
		}

		if (user != null) {
			System.out.println("Returning the messages to the client: " + login);

			MessageList messageList = new MessageList();
			for (Message m : user.getMessages()) {
				messageList.addMessage(m);
			}
			return Response.ok(messageList).build();
		} else {
			System.out.println("The user does not exist, no possibility of retrieving messages ...: " + login);
			return Response.status(Status.BAD_REQUEST).entity("Login details supplied for message delivery are not correct").build();
		}
	}
}
