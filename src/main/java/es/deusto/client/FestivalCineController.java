package es.deusto.client;

import es.deusto.client.gui.MenuAnonimo;
import es.deusto.client.remote.ServiceLocator;
import es.deusto.server.data.*;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Implementación del patrón de diseño Controller. Este bloque de código es quien coordina las funciones a proveer
 * para la interfaz del cliente, y está conectado con el ServiceLocator, el cual toma la información de la parte
 * servidora de la aplicación.
 * @author Grupo RMBJ
 * @version 3.0
 * @since 1.0
 */
public class FestivalCineController {

	static Logger logger = Logger.getLogger(FestivalCineController.class.getName());
	private static FestivalCineController instance;
	private ServiceLocator rsl;
	private Client client;
	private WebTarget webTarget;

	public static FestivalCineController getInstance() {
		return instance;
	}

	private FestivalCineController(String[] args) {
		instance = this;

		rsl = new ServiceLocator();
		rsl.setService(args);
		client = ClientBuilder.newClient();
		webTarget = client.target(String.format("http://%s:%s/rest/server", args[0], args[1]));
		MenuAnonimo frame = new MenuAnonimo();
		frame.setVisible(true);
	}

	/**
	 * Este método permite generar los datos de partida para que la aplicación pueda operar con algo. Además, cubre
	 * una función importante, que es la de generar el usuario "admin", el cual es el único que puede crear más
	 * películas y actores dentro del sistema.
	 *
	 * De este modo, este método es importante tanto para el debug de la aplicación como para el propio funcionamiento
	 * de la misma.
	 */
	public void generateFixtures(){

		logger.info("Generating Fixtures when beginning execution:");
		logger.info("Register a user for the first time: admin");
		FestivalCineController.getInstance().registerUser("admin", "admin");
		logger.info("Change the password as the user is already registered: admin");
		FestivalCineController.getInstance().registerUser("admin", "admin");
		logger.info("* Message coming from the server: '"
				+ FestivalCineController.getInstance().sayMessage("admin",
				"admin", "This is test 1!") + "'");
		logger.info("* Message coming from the server: '"
				+ FestivalCineController.getInstance().sayMessage("admin",
				"admin", "This is test 2!") + "'");

		MessageList messages = FestivalCineController.getInstance().getUserMessages("admin");
		for (Message m : messages.getMessages()) {
			logger.info(m.toString());
		}


		logger.info("Registering some peliculas:");
		List<ActorDTO> randomActors = new ArrayList<ActorDTO>();
		String store = System.getProperty("user.dir")+"/src/main/resources/img";

		logger.info("Registering an actor for the first time: Nicholas Cage");
		FestivalCineController.getInstance().registerActor("ID1", "Nicholas", "Cage", 50);
		FestivalCineController.getInstance().registerActor("ID1", "Pepe", "Juanito", 57);
		FestivalCineController.getInstance().registerActor("ID2", "Perico", "Cage", 120);


		randomActors.add(FestivalCineController.getInstance().getActorList().getActorsDTO().get(0));
		randomActors.add(FestivalCineController.getInstance().getActorList().getActorsDTO().get(1));

		FestivalCineController.getInstance().registerPelicula("Lo que el viento se llevo","Uno de los" +
						" mayores clasicos de la historia", "drama",145, 1962,"Alguien",
				"MIURL", "Muchos y variados","clasicos",randomActors,
				store+"/loqueelvientosellevo.jpg");

		randomActors.clear();

		FestivalCineController.getInstance().registerActor("ID3", "Mufasa", "Mufasa", 5);
		FestivalCineController.getInstance().registerActor("ID4", "Timon", "Timon", 6);
		FestivalCineController.getInstance().registerActor("ID5", "Pumba", "Pumba", 7);

		randomActors.add(FestivalCineController.getInstance().getActorList().getActorsDTO().get(2));
		randomActors.add(FestivalCineController.getInstance().getActorList().getActorsDTO().get(3));
		randomActors.add(FestivalCineController.getInstance().getActorList().getActorsDTO().get(4));

		FestivalCineController.getInstance().registerPelicula("El Rey Leon","Otro de los" +
						" mayores clasicos de la historia", "drama",121, 1985,"Alguien",
				"MIURL", "Muchos y variados","clasicos",randomActors,
				store+"/elreyleon.jpg");

		randomActors.clear();
		randomActors.add(FestivalCineController.getInstance().getActorList().getActorsDTO().get(0));
		randomActors.add(FestivalCineController.getInstance().getActorList().getActorsDTO().get(3));
		randomActors.add(FestivalCineController.getInstance().getActorList().getActorsDTO().get(4));

		FestivalCineController.getInstance().registerPelicula("La Comedia","Otro de los" +
						" mayores clasicos de la historia", "comedia",97, 2019,
				"Yo mismo","MIURL", "Muchos y variados","novedades",randomActors,
				store+"/lacomedia.jpg");
		logger.info("Fixtures generated successfully.");

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
								 String director, String enlacetrailer, String premios, String seccion,
								 List<ActorDTO> actores, String imagen) {
		rsl.registerPelicula(titulo,sinopsis,genero,duracion,anyo,director,enlacetrailer,premios, seccion, actores,
				imagen);
	}
	public PeliculaList getPeliculaList() {
		return rsl.getPeliculaList();
	}
	public void valorarPelicula (String titulo, float valoracion) throws NullPointerException {
		rsl.valorarPelicula(titulo, valoracion);
	}
	public ArrayList<String> getFiltros(String filtro) { return rsl.getFiltroList(filtro);}
	public PeliculaList getFilteredPeliculaList(String filtro, String criterio) {
		return rsl.getFilteredPeliculaList(filtro, criterio);
	}

	public void comentarPelicula (String titulo, String usuario, String contenido) throws NullPointerException {
		rsl.comentarPelicula(titulo, usuario, contenido);
	}

	public static void main(String[] args) {
		new FestivalCineController(args);
		FestivalCineController.getInstance().generateFixtures();
		if (args.length != 2) {
			logger.warning("Use: java Client.Client [host] [port]");
			System.exit(0);
		}
	}
}
