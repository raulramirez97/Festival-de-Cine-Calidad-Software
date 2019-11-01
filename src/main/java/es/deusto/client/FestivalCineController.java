package es.deusto.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import es.deusto.client.gui.Inicio;
import es.deusto.client.remote.RMIServiceLocator;
import es.deusto.server.data.*;

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
	//TODO: TODAS LAS COSAS PUESTAS A CONTINUACION EN ESTE METODO SE MANTIENEN PARA AYUDAR EN EL TESTEO Y DEBUG.
	public void generateFixtures(){

		System.out.println("Generating Fixtures when beginning execution:");
		System.out.println("_____________________________________________");
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

		//TODO: SE VA A SUPRIMIR LA PERSISTENCIA DE ACTORES DIRECTAMENTE PARA PERSISTIRLOS CUANDO HAYA PELICULAS.
		//TODO: SE PODRIA PENSAR EN UNA "CACHE" DE ACTORES PARA DESPUES PERSISTIRLOS EN PELICULAS. ESTA "CACHE" SERIA
		//TODO: UNA NUEVA CLASE PARA ACTORES (POR EJEMPLO, ACTORCASTINGDTO).
		System.out.println("Registering some peliculas:");
		List<ActorDTO> randomActors = new ArrayList<ActorDTO>();
//		randomActors.add(new ActorDTO("ID1", "Nicholas", "Cage", 50));
//		randomActors.add(new ActorDTO("ID2", "Perico", "Cage", 120));

		System.out.println("Registering an actor for the first time: Nicholas Cage");
		FestivalCineController.getInstance().registerActor("ID1", "Nicholas", "Cage", 50);
		FestivalCineController.getInstance().registerActor("ID1", "Pepe", "Juanito", 57);
		FestivalCineController.getInstance().registerActor("ID2", "Perico", "Cage", 120);


		//TODO: MOLARIA PODER USAR EL ID DEL ACTOR PARA BUSCARLO... EXTRA.
		randomActors.add(FestivalCineController.getInstance().getActorList().getActorsDTO().get(0));
		randomActors.add(FestivalCineController.getInstance().getActorList().getActorsDTO().get(1));

		FestivalCineController.getInstance().registerPelicula("Lo que el viento se llevo","Uno de los" +
						" mayores clasicos de la historia", "drama",145, 1935,"Alguien","MIURL",
				"Muchos y variados",randomActors);
		FestivalCineController.getInstance().registerPelicula("Lo que el viento se llevo","Uno de los" +
						" mayores clasicos de la historia", "drama",145, 1954,"Alguien","MIURL",
				"Muchos y variados",randomActors);

		randomActors.clear();
//		randomActors.add(new ActorDTO("ID3", "Mufasa", "Mufasa", 5));
//		randomActors.add(new ActorDTO("ID4", "Timon", "Timon", 6));
//		randomActors.add(new ActorDTO("ID5", "Pumba", "Pumba", 7));

		FestivalCineController.getInstance().registerActor("ID3", "Mufasa", "Mufasa", 5);
		FestivalCineController.getInstance().registerActor("ID4", "Timon", "Timon", 6);
		FestivalCineController.getInstance().registerActor("ID5", "Pumba", "Pumba", 7);

		randomActors.add(FestivalCineController.getInstance().getActorList().getActorsDTO().get(2));
		randomActors.add(FestivalCineController.getInstance().getActorList().getActorsDTO().get(3));
		randomActors.add(FestivalCineController.getInstance().getActorList().getActorsDTO().get(4));

		FestivalCineController.getInstance().registerPelicula("El Rey Leon","Otro de los" +
						" mayores clasicos de la historia", "drama",121, 1985,"Alguien","MIURL",
				"Muchos y variados",randomActors);

		randomActors.clear();
		randomActors.add(FestivalCineController.getInstance().getActorList().getActorsDTO().get(0));
		randomActors.add(FestivalCineController.getInstance().getActorList().getActorsDTO().get(3));
		randomActors.add(FestivalCineController.getInstance().getActorList().getActorsDTO().get(4));

		FestivalCineController.getInstance().registerPelicula("La Comedia","Otro de los" +
						" mayores clasicos de la historia", "comedia",97, 2019,"Yo mismo","MIURL",
				"Muchos y variados",randomActors);
		System.out.println("Fixtures generated successfully.");
		System.out.println("_____________________________________________");
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
	public void registerPelicula(String titulo, String sinopsis, String genero, int duracion, int anyo,
								 String director, String enlacetrailer, String premios,
								 List<ActorDTO> actores) {
		rsl.registerPelicula(titulo,sinopsis,genero,duracion,anyo,director,enlacetrailer,premios,actores);
	}
	public PeliculaList getPeliculaList() {
		return rsl.getPeliculaList();
	}
	public void valorarPelicula (String titulo, float valoracion) throws NullPointerException {
		rsl.valorarPelicula(titulo, valoracion);
	}
	public ArrayList<String> getFiltros() { return rsl.getFiltroList();}
	public PeliculaList getFilteredPeliculaList(String filtro) {
		return rsl.getFilteredPeliculaList(filtro);
	}

	public static void main(String[] args) {
		new FestivalCineController(args);
		FestivalCineController.getInstance().generateFixtures();
		if (args.length != 2) {
			System.out.println("Use: java Client.Client [host] [port]");
			System.exit(0);
		}
	}
}
