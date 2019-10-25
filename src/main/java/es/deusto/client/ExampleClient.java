package es.deusto.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import es.deusto.server.data.DirectedMessage;
import es.deusto.server.data.Message;
import es.deusto.server.data.MessageList;
import es.deusto.server.data.User;

//TODO: Clase a borrar; no hace falta para el Festival de Cine.
//TODO: Aún no se ha borrado para que no peten las dependencias con clases base que se pueden tomar como
//TODO: inspiración para modificar.


public class ExampleClient {

	private Client client;
	private WebTarget webTarget;

	public ExampleClient(String hostname, String port) {
		client = ClientBuilder.newClient();
		webTarget = client.target(String.format("http://%s:%s/rest/server", hostname, port));
	}

	public void registerUser(String login, String password) {
		WebTarget registerUserWebTarget = webTarget.path("register");
		Invocation.Builder invocationBuilder = registerUserWebTarget.request(MediaType.APPLICATION_JSON);

		User user = new User(login, password);
		Response response = invocationBuilder.post(Entity.entity(user, MediaType.APPLICATION_JSON));
		if (response.getStatus() != Status.OK.getStatusCode()) {
			System.out.println("Error connecting with the server. Code: " + response.getStatus());
		} else {
			System.out.println("User correctly registered");
		}
	}

	public String sayMessage(String login, String password, String message) {
		WebTarget sayHelloWebTarget = webTarget.path("sayMessage");
		Invocation.Builder invocationBuilder = sayHelloWebTarget.request(MediaType.APPLICATION_JSON);

		DirectedMessage directedMessage = new DirectedMessage();
		User user = new User(login, password);

		directedMessage.setUser(user);
		directedMessage.setMessage(message);

		Response response = invocationBuilder.post(Entity.entity(directedMessage, MediaType.APPLICATION_JSON));
		if (response.getStatus() != Status.OK.getStatusCode()) {
			System.out.println("Error connecting with the server. Code: " + response.getStatus());
			return "";
		} else {
			String responseMessage = response.readEntity(String.class);
			return responseMessage;
		}
	}

	public MessageList getUserMessages(String login) {
		WebTarget sayHelloWebTarget = webTarget.path("messages");
		Invocation.Builder invocationBuilder = sayHelloWebTarget.queryParam("login", "dipina").request(MediaType.APPLICATION_JSON);

		Response response = invocationBuilder.get();
		if (response.getStatus() != Status.OK.getStatusCode()) {
			System.out.println("Error connecting with the server. Code: " + response.getStatus());
			return new MessageList();
		} else {
			MessageList messageList = response.readEntity(MessageList.class);
			return messageList;
		}
	}

	public static void main(String[] args) {
		if (args.length != 2) {
			System.out.println("Use: java Client.Client [host] [port]");
			System.exit(0);
		}

		String hostname = args[0];
		String port = args[1];

		ExampleClient exampleClient = new ExampleClient(hostname, port);

 		System.out.println("Register a user for the first time: dipina");
		exampleClient.registerUser("dipina", "dipina");
		System.out.println("Change the password as the user is already registered: cortazar");
		exampleClient.registerUser("dipina", "cortazar");
 		System.out.println("* Message coming from the server: '"
				+ exampleClient.sayMessage("dipina", "cortazar", "This is test 1!") + "'");
 		System.out.println("* Message coming from the server: '"
				+ exampleClient.sayMessage("dipina", "cortazar", "This is test 2!") + "'");

  		MessageList messages = exampleClient.getUserMessages("dipina");
		for (Message m : messages.getMessages()) {
			System.out.println(m);
		}
	}
}
