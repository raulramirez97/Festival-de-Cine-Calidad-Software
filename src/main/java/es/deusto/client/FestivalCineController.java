package es.deusto.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import es.deusto.client.gui.Inicio;
import es.deusto.client.remote.RMIServiceLocator;
import es.deusto.server.data.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class FestivalCineController {

	private static FestivalCineController instance;
	private RMIServiceLocator rsl;
	private Client client;
	private WebTarget webTarget;

	public static FestivalCineController getInstance() {
		return instance;
	}

	private FestivalCineController(String[] args) {
		instance = this;
		rsl = new RMIServiceLocator();
		rsl.setService(args);
		client = ClientBuilder.newClient();
		webTarget = client.target(String.format("http://%s:%s/rest/server", args[0], args[1]));
		Inicio frame = new Inicio();
		frame.setVisible(true);
	}

	//TODO: DEJADO PARA DEBUG. SE DEBERIA QUITAR ESTE CONSTRUCTOR A LA LARGA.
	public FestivalCineController(String hostname, String port) {
		client = ClientBuilder.newClient();
		webTarget = client.target(String.format("http://%s:%s/rest/server", hostname, port));
	}

	public void registerUser(String login, String password) {
		rsl.registerUser(login,password);
	}
	public String sayMessage(String login, String password, String message) {
		return rsl.sayMessage(login,password, message);
	}
	public UsuarioDTO getUser(String login, String pwd) {
		return rsl.getUser(login, pwd);
	}
	public MessageList getUserMessages(String login) {
		return rsl.getUserMessages(login);
	}
	public void registerActor(String id, String nombre, String apellido, int edad) {
		rsl.registerActor(id,nombre,apellido,edad);
	}
	public ActorList getActorList() {
		return rsl.getActorList();
	}
	public void registerPelicula(String titulo, String sinopsis, String genero, int duracion,
								 String director, String enlacetrailer, String premios,
								 List<String> actores) {
		rsl.registerPelicula(titulo,sinopsis,genero,duracion,director,enlacetrailer,premios,actores);
	}
	public PeliculaList getPeliculaList() {
		return rsl.getPeliculaList();
	}

	public static void main(String[] args) {
		new FestivalCineController(args);

		if (args.length != 2) {
			System.out.println("Use: java Client.Client [host] [port]");
			System.exit(0);
		}

		//TODO: TODAS LAS COSAS PUESTAS A CONTINUACION SE MANTIENEN PARA AYUDAR EN EL TESTEO.

		String hostname = args[0];
		String port = args[1];

		//FestivalCineController exampleClient = new FestivalCineController(hostname, port);

// 		System.out.println("Register a user for the first time: dipina");
//		exampleClient.registerUser("dipina", "dipina");
//		System.out.println("Change the password as the user is already registered: cortazar");
//		exampleClient.registerUser("dipina", "cortazar");
// 		System.out.println("* Message coming from the server: '"
//				+ exampleClient.sayMessage("dipina", "cortazar", "This is test 1!") + "'");
// 		System.out.println("* Message coming from the server: '"
//				+ exampleClient.sayMessage("dipina", "cortazar", "This is test 2!") + "'");
//
//		MessageList messages = exampleClient.getUserMessages("dipina");

		System.out.println("Register a user for the first time: dipina");
		FestivalCineController.getInstance().registerUser("dipina", "dipina");
		System.out.println("Change the password as the user is already registered: cortazar");
		FestivalCineController.getInstance().registerUser("dipina", "cortazar");
 		System.out.println("* Message coming from the server: '"
				+ FestivalCineController.getInstance().sayMessage("dipina", "cortazar", "This is test 1!") + "'");
 		System.out.println("* Message coming from the server: '"
				+ FestivalCineController.getInstance().sayMessage("dipina", "cortazar", "This is test 2!") + "'");

		MessageList messages = FestivalCineController.getInstance().getUserMessages("dipina");
		for (Message m : messages.getMessages()) {
			System.out.println(m);
		}

 		System.out.println("Registering an actor for the first time: Nicholas Cage");
 		FestivalCineController.getInstance().registerActor("ID1", "Nicholas", "Cage", 50);
		FestivalCineController.getInstance().registerActor("ID1", "Pepe", "Juanito", 57);
		FestivalCineController.getInstance().registerActor("ID2", "Perico", "Cage", 120);

		System.out.println("Registering some peliculas:");
		List<String> randomActors = new ArrayList<String>();
		randomActors.add("Nicholas Cage");
		randomActors.add("La que el viento se llevo");

		FestivalCineController.getInstance().registerPelicula("Lo que el viento se llevo","Uno de los" +
				" mayores clasicos de la historia", "drama",145,"Alguien","MIURL",
				"Muchos y variados",randomActors);
		FestivalCineController.getInstance().registerPelicula("Lo que el viento se llevo","Uno de los" +
						" mayores clasicos de la historia", "drama",145,"Alguien","MIURL",
				"Muchos y variados",randomActors);

		randomActors.clear();
		randomActors.add("Mufasa");
		randomActors.add("Timon");
		randomActors.add("Pumba");
		FestivalCineController.getInstance().registerPelicula("El Rey Leon","Otro de los" +
						" mayores clasicos de la historia", "drama",121,"Alguien","MIURL",
				"Muchos y variados",randomActors);
	}
}
