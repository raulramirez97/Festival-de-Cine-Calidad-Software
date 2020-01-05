package es.deusto.client.remote;

import es.deusto.server.data.DirectedMessage;
import es.deusto.server.data.MessageList;
import es.deusto.server.data.UsuarioDTO;
import es.deusto.server.data.ActorDTO;
import es.deusto.server.data.ActorList;
import es.deusto.server.data.PeliculaDTO;
import es.deusto.server.data.PeliculaList;
import es.deusto.server.data.ValoracionDTO;
import es.deusto.server.data.ComentarioDTO;


import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.client.Entity;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Logger;

/**
 * Implementación del patrón de diseño ServiceLocator. Este bloque de código
 * es el que recibe las órdenes de la clase FestivalCineController, y es el
 * que establece la conexión con la parte servidora de esta aplicación
 * mediante el consumo de una API RESTful.
 * @author Grupo RMBJ
 * @version 3.0
 * @since 1.0
 */
public class ServiceLocator {

	static Logger logger = Logger.getLogger(ServiceLocator.class.getName());
	private Client client;
	private WebTarget webTargetService;

	public ServiceLocator() { }

	/**
	 * Método que prepara el servicio Cliente para que se pueda ejecutar
	 * contra el Servidor.
	 * @param args Array de Strings que contienen la dirección host y
	 *                el puerto.
	 */
	public void setService(String[] args) {
		client = ClientBuilder.newClient();
		webTargetService = client.target(
				String.format(
						"http://%s:%s/rest/server/",
						args[0], args[1]));
		logger.info(
				String.format(
						"http://%s:%s/rest/server/",
						args[0], args[1]));
	}

	/**
	 * Método que permite el registro de un usuario en el sistema,
	 * enviando la información al Servidor.
	 * @param login Nombre de usuario.
	 * @param password Contraseña del usuario.
	 */
	public void registerUser(String login, String password) {
		WebTarget registerUserWebTarget = webTargetService
				.path("registerUser");
		Invocation.Builder invocationBuilder = registerUserWebTarget
				.request(MediaType.APPLICATION_JSON);

		UsuarioDTO usuarioDTO = new UsuarioDTO(login, password);
		Response response = invocationBuilder
				.post(Entity.entity(usuarioDTO,
				MediaType.APPLICATION_JSON));
		if (response.getStatus() != Status.OK.getStatusCode()) {
			logger.warning("Error connecting with the server."
					+ " Code: " + response.getStatus());
		} else {
			logger.info("User correctly registered");
		}
	}

	/**
	 * Método que permite recuperar un usuario del servidor del sistema,
	 * enviando la petición al Servidor.
	 * @param login Nombre de usuario a buscar.
	 * @param pwd Contraseña que ha insertado el usuario.
	 * @return Usuario encontrado con credenciales correctas.
	 */
	public UsuarioDTO getUser(String login, String pwd) {
		WebTarget sayHelloWebTarget = webTargetService
				.path("obtainUser");
		sayHelloWebTarget = sayHelloWebTarget
				.queryParam("login", login);
		Invocation.Builder invocationBuilder = sayHelloWebTarget
				.queryParam("pwd", pwd)
				.request(MediaType.APPLICATION_JSON);

		Response response = invocationBuilder.get();
		if (response.getStatus() != Status.OK.getStatusCode()) {
			logger.warning("Error connecting with the server."
					+ " Code: " + response.getStatus());
			return new UsuarioDTO();
		} else {
			UsuarioDTO user = response.readEntity(UsuarioDTO.class);
			return user;
		}
	}

	/**
	 * Método utilizado para su Mockeo en las clases de Test. El objetivo es
	 * "enviar un mensaje", aunque no tiene que ver con la aplicación
	 * desarrollada en sí.
	 * @param login Nombre de usuario que envía el mensaje.
	 * @param password Contraseña que ha insertado el usuario que envía
	 *                    el mensaje.
	 * @param message Mensaje a enviar.
	 * @return Confirmación de mensaje enviado, en caso de haberse
	 * hecho correctamente.
	 */
	public String sayMessage(String login, String password,
							 String message) {
		WebTarget sayHelloWebTarget = webTargetService
				.path("sayMessage");
		Invocation.Builder invocationBuilder = sayHelloWebTarget
				.request(MediaType.APPLICATION_JSON);

		DirectedMessage directedMessage = new DirectedMessage();
		UsuarioDTO usuarioDTO = new UsuarioDTO(login, password);

		directedMessage.setUsuarioDTO(usuarioDTO);
		directedMessage.setMessage(message);

		Response response = invocationBuilder.post(Entity.entity(
				directedMessage, MediaType.APPLICATION_JSON));
		if (response.getStatus() != Status.OK.getStatusCode()) {
			logger.warning("Error connecting with the server."
					+ " Code: " + response.getStatus());
			return "";
		} else {
			String responseMessage = response
					.readEntity(String.class);
			return responseMessage;
		}
	}

	/**
	 * Método utilizado para recuperar una lista de mensajes enviados por un
	 * usuario con nombre "login".
	 * @param login Nombre de usuario para el cual se busca la lista
	 *                 de mensajes enviados.
	 * @return Listado de mensajes enviado por el usuario.
	 */
	public MessageList getUserMessages(String login) {
		WebTarget sayHelloWebTarget = webTargetService.path("messages");
		Invocation.Builder invocationBuilder = sayHelloWebTarget
				.queryParam("login", "dipina")
				.request(MediaType.APPLICATION_JSON);

		Response response = invocationBuilder.get();
		if (response.getStatus() != Status.OK.getStatusCode()) {
			logger.warning("Error connecting with the server."
					+ " Code: " + response.getStatus());
			return new MessageList();
		} else {
			MessageList messageList = response
					.readEntity(MessageList.class);
			return messageList;
		}
	}

	/**
	 * Método que permite registrar un actor en el sistema, enviando su
	 * información al Servidor.
	 * @param id Identificativo unívoco del actor.
	 * @param nombre Nombre del actor.
	 * @param apellido Primer apellido del actor.
	 * @param edad Edad del actor.
	 */
	public void registerActor(String id, String nombre, String apellido,
							  int edad) {
		WebTarget registerUserWebTarget = webTargetService.path(
				"registerActor");
		Invocation.Builder invocationBuilder = registerUserWebTarget
				.request(MediaType.APPLICATION_JSON);

		ActorDTO actorDTO = new ActorDTO(id, nombre, apellido, edad);
		Response response = invocationBuilder.post(
				Entity.entity(actorDTO,
				MediaType.APPLICATION_JSON));
		if (response.getStatus() != Status.OK.getStatusCode()) {
			logger.warning("Error connecting with the server."
					+ " Code: " + response.getStatus());
		} else {
			logger.info("Actor correctly registered");
		}
	}

	/**
	 * Método que permite recuperar una lista de actores registrados en
	 * el sistema.
	 * @return Listado de actores registrados en el sistema.
	 */
	public ActorList getActorList() {
		WebTarget sayHelloWebTarget = webTargetService
				.path("obtainActors");
		Invocation.Builder invocationBuilder = sayHelloWebTarget
				.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.get();
		if (response.getStatus() != Status.OK.getStatusCode()) {
			logger.warning("Error connecting with the server."
					+ " Code: " + response.getStatus());
			return new ActorList();
		} else {
			ActorList actores = response
					.readEntity(ActorList.class);
			return actores;
		}
	}

	/**
	 * Método que permite registrar una película en el sistema, enviando
	 * su información al Servidor.
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
	 * @param imagen Ruta de la imagen asociada a la cartelera
	 *                  de la película.
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
		WebTarget registerUserWebTarget = webTargetService.path(
				"registerPelicula");
		Invocation.Builder invocationBuilder = registerUserWebTarget
				.request(MediaType.APPLICATION_JSON);
		StringBuilder strActores = new StringBuilder();
		for (ActorDTO aux : actores) {
			strActores.append(aux.getNombre() + " "
					+ aux.getApellido() + ", ");
		}
		PeliculaDTO peliculaDTO = new PeliculaDTO(titulo, sinopsis,
				genero, duracion, anyo, director,
				enlacetrailer, 0,
				premios, null, seccion,
				strActores.toString(), imagen);

		logger.info("Enviando pelicula: " + peliculaDTO.getTitulo());
		Response response = invocationBuilder.post(Entity.entity(
				peliculaDTO, MediaType.APPLICATION_JSON));
		if (response.getStatus() != Status.OK.getStatusCode()) {
			logger.warning("Error connecting with the server. "
					+ "Code: " + response.getStatus());
		} else {
			logger.info("Pelicula correctly registered");
		}
	}

	/**
	 * Método que permite recuperar el listado de películas existentes en
	 * el sistema.
	 * @return Listado de películas existentes en el sistema.
	 */
	public PeliculaList getPeliculaList() {
		WebTarget sayHelloWebTarget = webTargetService
				.path("obtainPeliculas");
		Invocation.Builder invocationBuilder = sayHelloWebTarget
				.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.get();
		if (response.getStatus() != Status.OK.getStatusCode()) {
			logger.warning("Error connecting with the server. "
					+ "Code: " + response.getStatus());
			return new PeliculaList();
		} else {
			PeliculaList peliculas = response
					.readEntity(PeliculaList.class);
			return peliculas;
		}
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
		WebTarget registerValoracionWebTarget = webTargetService.path(
				"registerValoracion");
		Invocation.Builder invocationBuilder =
				registerValoracionWebTarget
				.request(MediaType.APPLICATION_JSON);
		ValoracionDTO valoracionDTO = new ValoracionDTO(
				titulo, valoracion);
		Response response = invocationBuilder.post(Entity.entity(
				valoracionDTO, MediaType.APPLICATION_JSON));
		if (response.getStatus() != Status.OK.getStatusCode()) {
			logger.warning("Error connecting with the server."
					+ " Code: " + response.getStatus());
		} else {
			logger.info("Valoracion correctly registered");
		}
	}

	/**
	 * Método que permite comentar una película, enviando la información
	 * relevante al Servidor.
	 * @param titulo Nombre de la película sobre la que comentar.
	 * @param usuario Nombre de usuario que comenta en la película.
	 * @param contenido Contenido del comentario que se hace sobre la
	 *                     película.
	 * @throws NullPointerException Excepción lanzada al no encontrar
	 * películas a comentar.
	 */
	public void comentarPelicula(String titulo, String usuario,
								 String contenido) {
		WebTarget registerUserWebTarget = webTargetService.path(
				"registerComment");
		Invocation.Builder invocationBuilder = registerUserWebTarget
				.request(MediaType.APPLICATION_JSON);
		ComentarioDTO miComentario = null;
		List<PeliculaDTO> misPelis = getPeliculaList()
				.getPeliculasDTO();
		for (PeliculaDTO aux: misPelis) {
			if (aux.getTitulo().compareTo(titulo) == 0) {
				miComentario = new ComentarioDTO(aux,
						usuario, contenido);
				break;
			}
		}
		logger.info("Enviando comentario: " + miComentario
				.getPelicula().getTitulo());
		Response response = invocationBuilder.post(Entity.entity(
				miComentario, MediaType.APPLICATION_JSON));
		if (response.getStatus() != Status.OK.getStatusCode()) {
			logger.warning("Error connecting with the server. "
					+ "Code: " + response.getStatus());
		} else {
			logger.info("Comentario correctly registered");
		}
	}

	/**
	 * Método que permite obtener un listado de Filtros secundarios
	 * disponibles, en base a un Filtro primario.
	 * @param filtro Filtro primario (Género, Director, Año, etc.) que
	 *                 el usuario elige en el primer ComboBox.
	 * @return ArrayList de Strings de Filtros secundarios.
	 * @throws NullPointerException Excepción lanzada en caso de no
	 * encontrar ningún filtro secundario que se corresponda con el
	 * String recibido como Filtro primario.
	 */
	public ArrayList<String> getFiltroList(String filtro)
			throws NullPointerException {
		List<PeliculaDTO> peliculasFestival = new ArrayList<>();
		peliculasFestival = getPeliculaList().getPeliculasDTO();
		ArrayList<String> filtrosPelis = new ArrayList<String>();
		if (peliculasFestival.size() == 0) {
			throw new NullPointerException();
		} else {
			if (filtro.compareTo("Género") == 0) {
				// Filtro para Género.
				Map<String, String> filtersMap =
						new TreeMap<String, String>();
				for (PeliculaDTO aux : peliculasFestival) {
					if (!(filtersMap.containsKey(
							aux.getGenero()))) {
						filtersMap.put(aux.getGenero(),
								aux.getGenero());
					}
				}
				filtrosPelis.addAll(filtersMap.values());
				return filtrosPelis;
			} else if (filtro
					.compareTo("Sección del Festival") == 0) {
				// Filtro para Sección del Festival.
				Map<String, String> filtersMap =
						new TreeMap<String, String>();
				for (PeliculaDTO aux : peliculasFestival) {
					if (!(filtersMap.containsKey(
							aux.getSeccionFestival()))) {
						filtersMap.put(aux.getSeccionFestival(),
								aux.getSeccionFestival());
					}
				}
				filtrosPelis.addAll(filtersMap.values());
				return filtrosPelis;
			} else if (filtro.compareTo("Año") == 0) {
				// Filtro para Año
				Map<String, String> filtersMap =
						new TreeMap<String, String>();
				for (PeliculaDTO aux : peliculasFestival) {
					if (!(filtersMap.containsKey(
							Integer.toString(
							aux.getAnyo())))) {
						filtersMap.put(Integer.toString(
								aux.getAnyo()),
								Integer.toString(
										aux.getAnyo()));
					}
				}
				filtrosPelis.addAll(filtersMap.values());
				return filtrosPelis;
			} else if (filtro.compareTo("Director") == 0) {
				// Filtro para Director
				Map<String, String> filtersMap =
						new TreeMap<String, String>();
				for (PeliculaDTO aux : peliculasFestival) {
					if (!(filtersMap.containsKey(
							aux.getDirector()))) {
						filtersMap.put(aux.getDirector(),
								aux.getDirector());
					}
				}
				filtrosPelis.addAll(filtersMap.values());
				return filtrosPelis;
			} else if (filtro.compareTo("Premio") == 0) {
				// Filtro para Premio
				Map<String, String> filtersMap =
						new TreeMap<String, String>();
				for (PeliculaDTO aux : peliculasFestival) {
					if (!(filtersMap.containsKey(
							aux.getPremios()))) {
						filtersMap.put(aux.getPremios(),
								aux.getPremios());
					}
				}
				filtrosPelis.addAll(filtersMap.values());
				return filtrosPelis;
			} else { // Filtro para Película
				Map<String, String> filtersMap =
						new TreeMap<String, String>();
				for (PeliculaDTO aux : peliculasFestival) {
					if (!(filtersMap.containsKey(
							aux.getTitulo()))) {
						filtersMap.put(aux.getTitulo(),
								aux.getTitulo());
					}
				}
				filtrosPelis.addAll(filtersMap.values());
				return filtrosPelis;
			}
		}
	}

	/**
	 * Método que busca obtener un listado de películas en base a un Filtro
	 * primario y un Criterio o Filtro secundario.
	 * @param filtro Filtro primario (Género, Director, Año, etc.) que el
	 *                 usuario elige en el primer ComboBox.
	 * @param criterio Filtro secundario que el usuario elige en el
	 *                   segundo ComboBox o en un TextField.
	 * @return Listado de películas que cumplen ambos filtros.
	 */
	public PeliculaList getFilteredPeliculaList(String filtro,
												String criterio) {
		List<PeliculaDTO> peliculasFestival = new ArrayList<>();
		peliculasFestival = getPeliculaList().getPeliculasDTO();
		PeliculaList peliculasFiltradas = new PeliculaList();
		if (criterio.compareTo("Género") == 0) {
			// Criterio de orden superior para Género.
			for (PeliculaDTO aux : peliculasFestival) {
				if (aux.getGenero().compareTo(filtro) == 0) {
					peliculasFiltradas.addPeliculaDTO(aux);
				}
			}
			return peliculasFiltradas;
		} else if (criterio.compareTo("Sección del Festival") == 0) {
			// Criterio de orden superior para Sección del Festival.
			for (PeliculaDTO aux : peliculasFestival) {
				if (aux.getSeccionFestival()
						.compareTo(filtro) == 0) {
					peliculasFiltradas.addPeliculaDTO(aux);
				}
			}
			return peliculasFiltradas;
		} else if (criterio.compareTo("Año") == 0) {
			// Criterio de orden superior para Año.
			for (PeliculaDTO aux : peliculasFestival) {
				if (Integer.toString(aux.getAnyo())
						.compareTo(filtro) == 0) {
					peliculasFiltradas.addPeliculaDTO(aux);
				}
			}
			return peliculasFiltradas;
		} else if (criterio.compareTo("Valoración") == 0) {
			// Criterio de orden superior para Valoración.
			double valoracionFiltro = Double.parseDouble(filtro);
			for (PeliculaDTO aux : peliculasFestival) {
				if (valoracionFiltro <= aux
						.getValoracionMedia()) {
					peliculasFiltradas.addPeliculaDTO(aux);
				}
			}
			return peliculasFiltradas;
		} else if (criterio.compareTo("Duración") == 0) {
			// Criterio de orden superior para Duración.
			int duracionFiltro = Integer.parseInt(filtro);
			for (PeliculaDTO aux : peliculasFestival) {
				if (duracionFiltro <= aux.getDuracion()) {
					peliculasFiltradas.addPeliculaDTO(aux);
				}
			}
			return peliculasFiltradas;
		} else if (criterio.compareTo("Director") == 0) {
			// Criterio de orden superior para Director.
			for (PeliculaDTO aux : peliculasFestival) {
				if (aux.getDirector().compareTo(filtro) == 0) {
					peliculasFiltradas.addPeliculaDTO(aux);
				}
			}
			return peliculasFiltradas;
		} else if (criterio.compareTo("Actor") == 0) {
			// Criterio de orden superior para Actor.
			String filtroActor = filtro.toUpperCase();
			for (PeliculaDTO aux : peliculasFestival) {
				if (aux.getActores().toUpperCase()
						.contains(filtroActor)) {
					peliculasFiltradas.addPeliculaDTO(aux);
				}
			}
			return peliculasFiltradas;
		} else if (criterio.compareTo("Premio") == 0) {
			// Criterio de orden superior para Premio.
			for (PeliculaDTO aux : peliculasFestival) {
				if (aux.getPremios().compareTo(filtro) == 0) {
					peliculasFiltradas.addPeliculaDTO(aux);
				}
			}
			return peliculasFiltradas;
		} else { // Criterio de orden superior para Película.
			for (PeliculaDTO aux : peliculasFestival) {
				if (aux.getTitulo().compareTo(filtro) == 0) {
					peliculasFiltradas.addPeliculaDTO(aux);
				}
			}
			return peliculasFiltradas;
		}
	}
}
