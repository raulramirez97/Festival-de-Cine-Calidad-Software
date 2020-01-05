package es.deusto.client;

import es.deusto.client.gui.MenuAnonimo;
import es.deusto.client.gui.ProgressBar;
import es.deusto.client.remote.ServiceLocator;
import es.deusto.server.data.ActorDTO;
import es.deusto.server.data.UsuarioDTO;
import es.deusto.server.data.Message;
import es.deusto.server.data.MessageList;
import es.deusto.server.data.PeliculaList;
import es.deusto.server.data.ActorList;


import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Implementación del patrón de diseño Controller. Este bloque de código es
 * quien coordina las funciones a proveerpara la interfaz del cliente, y está
 * conectado con el ServiceLocator, el cual toma la información de la parte
 * servidora de la aplicación.
 * @author Grupo RMBJ
 * @version 3.0
 * @since 1.0
 */
public class FestivalCineController {

	static Logger logger = Logger.getLogger(FestivalCineController.class
			.getName());
	private static FestivalCineController instance;
	private ServiceLocator rsl;
	private Client client;
	private WebTarget webTarget;

	/**
	 * Método que fuerza a que se tenga solamente una instancia de
	 * FestivalCineController, cumpliendo así con el patrón de diseño
	 * Singleton.
	 * @return Singleton de FestivalCineController
	 */
	public static FestivalCineController getInstance() {
		return instance;
	}

	/**
	 * Constructor generado para las clases de test; en la ejecución en
	 * producción no se utiliza.
	 * @param args Argumentos del main (dirección y puerto).
	 * @param test Argumento no-utilizado para diferenciar este constructor
	 *                del de producción.
	 */
	public FestivalCineController(final String[] args, final String test) {
		instance = this;
		rsl = new ServiceLocator();
		rsl.setService(args);
		client = ClientBuilder.newClient();
		webTarget = client.target(String.format(
				"http://%s:%s/rest/server", args[0], args[1]));
	}

	/**
	 * Constructor de producción generado para la ejecución normal de la
	 * aplicación.
	 * @param args Argumentos del main (dirección y puerto).
	 */
	private FestivalCineController(final String[] args) {
		instance = this;

		rsl = new ServiceLocator();
		rsl.setService(args);
		client = ClientBuilder.newClient();
		webTarget = client.target(String.format(
				"http://%s:%s/rest/server", args[0], args[1]));
		PeliculaList peliculaList = this.getPeliculaList();
		int tam = peliculaList.getPeliculasDTO().size();
		if (tam == 0) {
			ProgressBar bar = new ProgressBar("Insertando los datos"
					+ " por primera vez, espere un poco "
					+ "por favor...");
			bar.setVisible(true);
		} else {
			MenuAnonimo frame = new MenuAnonimo();
			frame.setVisible(true);
		}
	}

	/**
	 * Este método permite generar los datos de partida para que la
	 * aplicación pueda operar con algo. Además, cubre una función
	 * importante, que es la de generar el usuario "admin", el cual es el
	 * único que puede crear más películas y actores dentro del sistema.
	 *
	 * De este modo, este método es importante tanto para el debug de la
	 * aplicación como para el propio funcionamiento
	 * de la misma.
	 */
	public void generateFixtures() {
		logger.info("Generating Fixtures when beginning execution:");
		logger.info("Register a user for the first time: admin");
		FestivalCineController.getInstance().registerUser("admin",
				"admin");
		logger.info("Change the password as the user is already "
				+ "registered: admin");
		FestivalCineController.getInstance().registerUser("admin",
				"admin");
		logger.info("* Message coming from the server: '"
				+ FestivalCineController.getInstance()
				.sayMessage("admin",
				"admin", "This is test 1!") + "'");
		logger.info("* Message coming from the server: '"
				+ FestivalCineController.getInstance()
				.sayMessage("admin",
				"admin", "This is test 2!") + "'");

		MessageList messages = FestivalCineController.getInstance()
				.getUserMessages("admin");
		for (Message m : messages.getMessages()) {
			logger.info(m.toString());
		}

		logger.info("Registering some peliculas:");
		List<ActorDTO> randomActors = new ArrayList<>();
		String store = "/src/main/resources/img";

		logger.info("Registering an actor for the first time: "
				+ "Nicholas Cage");
		FestivalCineController.getInstance().registerActor("ID1",
				"Nicholas", "Cage", 50);
		FestivalCineController.getInstance().registerActor("ID1",
				"Pepe", "Juanito", 57);
		FestivalCineController.getInstance().registerActor("ID2",
				"Perico", "Cage", 120);


		randomActors.add(FestivalCineController.getInstance()
				.getActorList().getActorsDTO().get(0));
		randomActors.add(FestivalCineController.getInstance()
				.getActorList().getActorsDTO().get(1));

		FestivalCineController.getInstance().registerPelicula(
				"Lo que el viento se llevo",
				"Uno de los mayores clasicos de la historia",
				"drama",
				145,
				1962,
				"Alguien",
				"MIURL",
				"Muchos y variados",
				"clasicos",
				randomActors,
				store
						+ "/loqueelvientosellevo.jpg");

		randomActors.clear();

		FestivalCineController.getInstance().registerActor("ID3",
				"Mufasa", "Mufasa", 5);
		FestivalCineController.getInstance().registerActor("ID4",
				"Timon", "Timon", 6);
		FestivalCineController.getInstance().registerActor("ID5",
				"Pumba", "Pumba", 7);

		randomActors.add(FestivalCineController.getInstance()
				.getActorList().getActorsDTO().get(2));
		randomActors.add(FestivalCineController.getInstance()
				.getActorList().getActorsDTO().get(3));
		randomActors.add(FestivalCineController.getInstance()
				.getActorList().getActorsDTO().get(4));

		FestivalCineController.getInstance().registerPelicula(
				"El Rey Leon",
				"Otro de los mayores clasicos de la historia",
				"drama",
				121,
				1985,
				"Alguien",
				"MIURL",
				"Muchos y variados",
				"clasicos",
				randomActors,
				store
						+ "/elreyleon.jpg");

		randomActors.clear();
		randomActors.add(FestivalCineController.getInstance()
				.getActorList().getActorsDTO().get(0));
		randomActors.add(FestivalCineController.getInstance()
				.getActorList().getActorsDTO().get(3));
		randomActors.add(FestivalCineController.getInstance()
				.getActorList().getActorsDTO().get(4));

		FestivalCineController.getInstance().registerPelicula(
				"La Comedia",
				"Otro de los mayores clasicos de la historia",
				"comedia",
				97,
				2019,
				"Yo mismo",
				"MIURL",
				"Muchos y variados",
				"novedades",
				randomActors,
				store
						+ "/lacomedia.jpg");
		logger.info("Fixtures generated successfully.");
	}

	/**
	 * Método que permite el registro de un usuario en el sistema,
	 * enviando la información al ServiceLocator.
	 * @param login Nombre de usuario.
	 * @param password Contraseña del usuario.
	 */
	public void registerUser(String login, String password) {
		rsl.registerUser(login, password);
	}

	/**
	 * Método que permite recuperar un usuario del servidor del sistema,
	 * enviando la petición al ServiceLocator.
	 * @param login Nombre de usuario a buscar.
	 * @param pwd Contraseña que ha insertado el usuario.
	 * @return Usuario encontrado con credenciales correctas.
	 */
	public UsuarioDTO getUser(String login, String pwd) {
		return rsl.getUser(login, pwd);
	}

	/**
	 * Método utilizado para su Mockeo en las clases de Test. El objetivo es
	 * "enviar un mensaje", aunque no tiene que ver con la aplicación
	 * desarrollada en sí.
	 * @param login Nombre de usuario que envía el mensaje.
	 * @param password Contraseña que ha insertado el usuario que envía el
	 *                    mensaje.
	 * @param message Mensaje a enviar.
	 * @return Confirmación de mensaje enviado, en caso de haberse hecho
	 * correctamente.
	 */
	public String sayMessage(String login,
							 String password,
							 String message) {
		return rsl.sayMessage(login, password, message);
	}

	/**
	 * Método utilizado para recuperar una lista de mensajes enviados por un
	 * usuario con nombre "login".
	 * @param login Nombre de usuario para el cual se busca la lista de
	 *                 mensajes enviados.
	 * @return Listado de mensajes enviado por el usuario.
	 */
	public MessageList getUserMessages(String login) {
		return rsl.getUserMessages(login);
	}

	/**
	 * Método que permite registrar un actor en el sistema, enviando su
	 * información al ServiceLocator.
	 * @param id Identificativo unívoco del actor.
	 * @param nombre Nombre del actor.
	 * @param apellido Primer apellido del actor.
	 * @param edad Edad del actor.
	 */
	public void registerActor(String id, String nombre, String apellido,
							  int edad) {
		rsl.registerActor(id, nombre, apellido, edad);
	}

	/**
	 * Método que permite recuperar una lista de actores registrados en el
	 * sistema.
	 * @return Listado de actores registrados en el sistema.
	 */
	public ActorList getActorList() {
		return rsl.getActorList();
	}

	/**
	 * Método que permite registrar una película en el sistema, enviando su
	 * información al ServiceLocator.
	 * @param titulo Nombre de la película.
	 * @param sinopsis Sinopsis de la película.
	 * @param genero Género de la película.
	 * @param duracion Duración (en minutos) de la película.
	 * @param anyo Año de la película.
	 * @param director Director de la película.
	 * @param enlacetrailer URL del trailer de la película.
	 * @param premios Premios que ha recibido la película en formato texto.
	 * @param seccion Sección del Festival de Cine en la que se encuentra
	 *                   la película.
	 * @param actores Actores principales que participan en la película.
	 * @param imagen Ruta de la imagen asociada a la cartelera de
	 *                  la película.
	 */
	public void registerPelicula(String titulo,
								 String sinopsis,
								 String genero,
								 int duracion,
								 int anyo,
								 String director,
								 String enlacetrailer,
								 String premios,
								 String seccion,
								 List<ActorDTO> actores,
								 String imagen) {
		rsl.registerPelicula(titulo, sinopsis, genero, duracion,
				anyo, director, enlacetrailer, premios, seccion,
				actores, imagen);
	}

	/**
	 * Método que permite recuperar el listado de películas existentes en el
	 * sistema.
	 * @return Listado de películas existentes en el sistema.
	 */
	public PeliculaList getPeliculaList() {
		return rsl.getPeliculaList();
	}

	/**
	 * Método cuyo objetivo es valorar una película entre el 1 y el 10.
	 * @param titulo Título de la película que se valorará.
	 * @param valoracion Puntuación (entre el 1 y el 10) que el usuario ha
	 *                     dado a una película.
	 * @throws NullPointerException Excepción lanzada al no encontrar
	 * películas a valorar.
	 */
	public void valorarPelicula(String titulo, float valoracion)
			throws NullPointerException {
		rsl.valorarPelicula(titulo, valoracion);
	}

	/**
	 * Método que permite comentar una película, enviando la información
	 * relevante al ServiceLocator.
	 * @param titulo Nombre de la película sobre la que comentar.
	 * @param usuario Nombre de usuario que comenta en la película.
	 * @param contenido Contenido del comentario que se hace sobre la
	 *                     película.
	 * @throws NullPointerException Excepción lanzada al no encontrar
	 * películas a comentar.
	 */
	public void comentarPelicula(String titulo, String usuario,
								  String contenido)
			throws NullPointerException {
		rsl.comentarPelicula(titulo, usuario, contenido);
	}

	/**
	 * Método que permite obtener un listado de Filtros secundarios
	 * disponibles, en base a un Filtro primario.
	 * @param filtro Filtro primario (Género, Director, Año, etc.) que el
	 *                 usuario elige en el primer ComboBox.
	 * @return ArrayList de Strings de Filtros secundarios.
	 */
	public ArrayList<String> getFiltros(String filtro) {
		return rsl.getFiltroList(filtro);
	}

	/**
	 * Método que busca obtener un listado de películas en base a un Filtro
	 * primario y un Criterio o Filtro secundario.
	 * @param filtro Filtro primario (Género, Director, Año, etc.) que el
	 *                 usuario elige en el primer ComboBox.
	 * @param criterio Filtro secundario que el usuario elige en el segundo
	 *                   ComboBox o en un TextField.
	 * @return Listado de películas que cumplen ambos filtros.
	 */
	public PeliculaList getFilteredPeliculaList(String filtro,
												String criterio) {
		return rsl.getFilteredPeliculaList(filtro, criterio);
	}

	/**
	 * Método main que se ejecuta mediante el profile de Cliente en Maven.
	 * @param args Array de Strings que contiene la dirección host y el
	 *               puerto al que se debe conectar el Cliente.
	 */
	public static void main(String[] args) {
		new FestivalCineController(args);
		FestivalCineController.getInstance().generateFixtures();
		if (args.length != 2) {
			logger.warning("Use: java Client.Client [host] [port]");
			System.exit(0);
		}
	}
}
