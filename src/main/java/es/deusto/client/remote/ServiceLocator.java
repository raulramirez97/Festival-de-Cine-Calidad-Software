package es.deusto.client.remote;

import es.deusto.server.data.*;

import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Logger;

/**
 * Implementación del patrón de diseño ServiceLocator. Este bloque de código es el que recibe las órdenes de la clase
 * FestivalCineController, y es el que establece la conexión con la parte servidora de esta aplicación mediante el
 * consumo de una API RESTful.
 * @author Grupo RMBJ
 * @version 2.0
 * @since 1.0
 */
public class ServiceLocator {

	static Logger logger = Logger.getLogger(ServiceLocator.class.getName());
	private Client client;
	private WebTarget webTargetService;

	public ServiceLocator() {}

	public void setService(String[] args) {
		client = ClientBuilder.newClient();
		webTargetService = client.target(String.format("http://%s:%s/rest/server/", args[0], args[1]));
		logger.info(String.format("http://%s:%s/rest/server/", args[0], args[1]));
	}

	public void registerUser(String login, String password) {
		WebTarget registerUserWebTarget = webTargetService.path("registerUser");
		Invocation.Builder invocationBuilder = registerUserWebTarget.request(MediaType.APPLICATION_JSON);

		UsuarioDTO usuarioDTO = new UsuarioDTO(login, password);
		Response response = invocationBuilder.post(Entity.entity(usuarioDTO, MediaType.APPLICATION_JSON));
		if (response.getStatus() != Status.OK.getStatusCode()) {
			logger.warning("Error connecting with the server. Code: " + response.getStatus());
		} else {
			logger.info("User correctly registered");
		}
	}

	public String sayMessage(String login, String password, String message) {
		WebTarget sayHelloWebTarget = webTargetService.path("sayMessage");
		Invocation.Builder invocationBuilder = sayHelloWebTarget.request(MediaType.APPLICATION_JSON);

		DirectedMessage directedMessage = new DirectedMessage();
		UsuarioDTO usuarioDTO = new UsuarioDTO(login, password);

		directedMessage.setUsuarioDTO(usuarioDTO);
		directedMessage.setMessage(message);

		Response response = invocationBuilder.post(Entity.entity(directedMessage, MediaType.APPLICATION_JSON));
		if (response.getStatus() != Status.OK.getStatusCode()) {
			logger.warning("Error connecting with the server. Code: " + response.getStatus());
			return "";
		} else {
			String responseMessage = response.readEntity(String.class);
			return responseMessage;
		}
	}

	public UsuarioDTO getUser(String login, String pwd) {
		WebTarget sayHelloWebTarget = webTargetService.path("obtainUser");
		sayHelloWebTarget = sayHelloWebTarget.queryParam("login", login);
		Invocation.Builder invocationBuilder = sayHelloWebTarget.queryParam("pwd", pwd).request(MediaType.APPLICATION_JSON);

		Response response = invocationBuilder.get();
		if (response.getStatus() != Status.OK.getStatusCode()) {
			logger.warning("Error connecting with the server. Code: " + response.getStatus());
			return new UsuarioDTO();
		} else {
			UsuarioDTO user = response.readEntity(UsuarioDTO.class);
			return user;
		}
	}

	public MessageList getUserMessages(String login) {
		WebTarget sayHelloWebTarget = webTargetService.path("messages");
		Invocation.Builder invocationBuilder = sayHelloWebTarget.queryParam("login", "dipina").request(MediaType.APPLICATION_JSON);

		Response response = invocationBuilder.get();
		if (response.getStatus() != Status.OK.getStatusCode()) {
			logger.warning("Error connecting with the server. Code: " + response.getStatus());
			return new MessageList();
		} else {
			MessageList messageList = response.readEntity(MessageList.class);
			return messageList;
		}
	}

	public void registerActor(String id, String nombre, String apellido, int edad) {
		WebTarget registerUserWebTarget = webTargetService.path("registerActor");
		Invocation.Builder invocationBuilder = registerUserWebTarget.request(MediaType.APPLICATION_JSON);

		ActorDTO actorDTO = new ActorDTO(id, nombre, apellido, edad);
		Response response = invocationBuilder.post(Entity.entity(actorDTO, MediaType.APPLICATION_JSON));
		if (response.getStatus() != Status.OK.getStatusCode()) {
			logger.warning("Error connecting with the server. Code: " + response.getStatus());
		} else {
			logger.info("Actor correctly registered");
		}
	}

	public ActorList getActorList() {
		WebTarget sayHelloWebTarget = webTargetService.path("obtainActors");
		Invocation.Builder invocationBuilder = sayHelloWebTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.get();
		if (response.getStatus() != Status.OK.getStatusCode()) {
			logger.warning("Error connecting with the server. Code: " + response.getStatus());
			return new ActorList();
		} else {
			ActorList actores = response.readEntity(ActorList.class);
			return actores;
		}
	}

	public void registerPelicula(String titulo, String sinopsis, String genero, int duracion, int anyo,
								 String director, String enlacetrailer, String premios, String seccion,
								 List<ActorDTO> actores, String imagen) {
		WebTarget registerUserWebTarget = webTargetService.path("registerPelicula");
		Invocation.Builder invocationBuilder = registerUserWebTarget.request(MediaType.APPLICATION_JSON);
		StringBuilder strActores = new StringBuilder();
		for (ActorDTO aux : actores) {
			strActores.append(aux.getNombre() + " " + aux.getApellido() + ", ");
		}
		PeliculaDTO peliculaDTO = new PeliculaDTO(titulo, sinopsis, genero, duracion, anyo, director, enlacetrailer,
				0, premios,null, seccion, strActores.toString(), imagen);

		logger.info("Enviando pelicula: " + peliculaDTO.getTitulo());
		Response response = invocationBuilder.post(Entity.entity(peliculaDTO, MediaType.APPLICATION_JSON));
		if (response.getStatus() != Status.OK.getStatusCode()) {
			logger.warning("Error connecting with the server. Code: " + response.getStatus());
		} else {
			logger.info("Pelicula correctly registered");
		}
	}

	public PeliculaList getPeliculaList() {
		WebTarget sayHelloWebTarget = webTargetService.path("obtainPeliculas");
		Invocation.Builder invocationBuilder = sayHelloWebTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.get();
		if (response.getStatus() != Status.OK.getStatusCode()) {
			logger.warning("Error connecting with the server. Code: " + response.getStatus());
			return new PeliculaList();
		} else {
			PeliculaList peliculas = response.readEntity(PeliculaList.class);
			return peliculas;
		}
	}

	public void valorarPelicula(String titulo, float valoracion) throws NullPointerException {
		WebTarget registerValoracionWebTarget = webTargetService.path("registerValoracion");
		Invocation.Builder invocationBuilder = registerValoracionWebTarget.request(MediaType.APPLICATION_JSON);
		ValoracionDTO valoracionDTO = new ValoracionDTO(titulo, valoracion);

		Response response = invocationBuilder.post(Entity.entity(valoracionDTO, MediaType.APPLICATION_JSON));
		if (response.getStatus() != Status.OK.getStatusCode()) {
			logger.warning("Error connecting with the server. Code: " + response.getStatus());
		} else {
			logger.info("Valoracion correctly registered");
		}
	}

	public void comentarPelicula(String titulo, String usuario, String contenido) {
		WebTarget registerUserWebTarget = webTargetService.path("registerComment");
		Invocation.Builder invocationBuilder = registerUserWebTarget.request(MediaType.APPLICATION_JSON);
		ComentarioDTO miComentario = null;
		List<PeliculaDTO> misPelis = getPeliculaList().getPeliculasDTO();

		for (PeliculaDTO aux: misPelis){
			if (aux.getTitulo().compareTo(titulo)==0){
				miComentario = new ComentarioDTO(aux,usuario,contenido);
				break;
			}
		}

		logger.info("Enviando comentario: " + miComentario.getPelicula().getTitulo());
		Response response = invocationBuilder.post(Entity.entity(miComentario, MediaType.APPLICATION_JSON));
		if (response.getStatus() != Status.OK.getStatusCode()) {
			logger.warning("Error connecting with the server. Code: " + response.getStatus());
		} else {
			logger.info("Comentario correctly registered");
		}
	}

	public ArrayList<String> getFiltroList(String filtro) throws NullPointerException {
		List<PeliculaDTO> peliculasFestival = new ArrayList<PeliculaDTO>();
		peliculasFestival = getPeliculaList().getPeliculasDTO();
		ArrayList<String> filtrosPelis = new ArrayList<String>();
		if (peliculasFestival.size() == 0) {
			throw new NullPointerException();
		}
		else {
			if (filtro.compareTo("Género")==0) { // Filtro para Género.
				Map<String, String> filtersMap = new TreeMap<String, String>();
				for (PeliculaDTO aux : peliculasFestival) {
					if (!(filtersMap.containsKey(aux.getGenero()))) {
						filtersMap.put(aux.getGenero(), aux.getGenero());
					}
				}
				filtrosPelis.addAll(filtersMap.values());
				return filtrosPelis;
			}
			else if (filtro.compareTo("Sección del Festival")==0) { // Filtro para Sección del Festival.
				Map<String, String> filtersMap = new TreeMap<String, String>();
				for (PeliculaDTO aux : peliculasFestival) {
					if (!(filtersMap.containsKey(aux.getSeccionFestival()))) {
						filtersMap.put(aux.getSeccionFestival(), aux.getSeccionFestival());
					}
				}
				filtrosPelis.addAll(filtersMap.values());
				return filtrosPelis;
			}
			else if (filtro.compareTo("Año")==0) { // Filtro para Año
				Map<String, String> filtersMap = new TreeMap<String, String>();
				for (PeliculaDTO aux : peliculasFestival) {
					if (!(filtersMap.containsKey(Integer.toString(aux.getAnyo())))) {
						filtersMap.put(Integer.toString(aux.getAnyo()), Integer.toString(aux.getAnyo()));
					}
				}
				filtrosPelis.addAll(filtersMap.values());
				return filtrosPelis;
			}

			else if (filtro.compareTo("Director")==0) { // Filtro para Director
				Map<String, String> filtersMap = new TreeMap<String, String>();
				for (PeliculaDTO aux : peliculasFestival) {
					if (!(filtersMap.containsKey(aux.getDirector()))){
						filtersMap.put(aux.getDirector(), aux.getDirector());
					}
				}
				filtrosPelis.addAll(filtersMap.values());
				return filtrosPelis;
			}
			else if (filtro.compareTo("Premio")==0) { // Filtro para Premio
				Map<String, String> filtersMap = new TreeMap<String, String>();
				for (PeliculaDTO aux : peliculasFestival) {
					if (!(filtersMap.containsKey(aux.getPremios()))){
						filtersMap.put(aux.getPremios(), aux.getPremios());
					}
				}
				filtrosPelis.addAll(filtersMap.values());
				return filtrosPelis;
			}
			else { // Filtro para Película
				Map<String, String> filtersMap = new TreeMap<String, String>();
				for (PeliculaDTO aux : peliculasFestival) {
					if (!(filtersMap.containsKey(aux.getTitulo()))){
						filtersMap.put(aux.getTitulo(), aux.getTitulo());
					}
				}
				filtrosPelis.addAll(filtersMap.values());
				return filtrosPelis;
			}
		}
	}

	public PeliculaList getFilteredPeliculaList(String filtro, String criterio) {
		List<PeliculaDTO> peliculasFestival = new ArrayList<PeliculaDTO>();
		peliculasFestival = getPeliculaList().getPeliculasDTO();
		PeliculaList peliculasFiltradas = new PeliculaList();
		if (criterio.compareTo("Género")==0) { // Criterio de orden superior para Género.
			for (PeliculaDTO aux : peliculasFestival) {
				if (aux.getGenero().compareTo(filtro) == 0) {
					peliculasFiltradas.addPeliculaDTO(aux);
				}
			}
			return peliculasFiltradas;
		}
		else if (criterio.compareTo("Sección del Festival")==0) { // Criterio de orden superior para Sección del Festival.
			for (PeliculaDTO aux : peliculasFestival) {
				if (aux.getSeccionFestival().compareTo(filtro) == 0) {
					peliculasFiltradas.addPeliculaDTO(aux);
				}
			}
			return peliculasFiltradas;
		}
		else if (criterio.compareTo("Año")==0) { // Criterio de orden superior para Año.
			for (PeliculaDTO aux : peliculasFestival) {
				if (Integer.toString(aux.getAnyo()).compareTo(filtro) == 0) {
					peliculasFiltradas.addPeliculaDTO(aux);
				}
			}
			return peliculasFiltradas;
		}
		else if (criterio.compareTo("Valoración")==0) { // Criterio de orden superior para Valoración.
			double valoracionFiltro = Double.parseDouble(filtro);
			for (PeliculaDTO aux : peliculasFestival) {
				if (valoracionFiltro <= aux.getValoracionMedia()) {
					peliculasFiltradas.addPeliculaDTO(aux);
				}
			}
			return peliculasFiltradas;
		}
		else if (criterio.compareTo("Duración")==0) { // Criterio de orden superior para Duración.
			int duracionFiltro = Integer.parseInt(filtro);
			for (PeliculaDTO aux : peliculasFestival) {
				if (duracionFiltro <= aux.getDuracion()) {
					peliculasFiltradas.addPeliculaDTO(aux);
				}
			}
			return peliculasFiltradas;
		}
		else if (criterio.compareTo("Director")==0) { // Criterio de orden superior para Director.
			for (PeliculaDTO aux : peliculasFestival) {
				if (aux.getDirector().compareTo(filtro) == 0) {
					peliculasFiltradas.addPeliculaDTO(aux);
				}
			}
			return peliculasFiltradas;
		}
		else if (criterio.compareTo("Actor")==0) { // Criterio de orden superior para Actor.
			String filtroActor = filtro.toUpperCase();
			for (PeliculaDTO aux : peliculasFestival) {
				if (aux.getActores().toUpperCase().contains(filtroActor)) {
					peliculasFiltradas.addPeliculaDTO(aux);
				}
			}
			return peliculasFiltradas;
		}
		else if (criterio.compareTo("Premio")==0) { // Criterio de orden superior para Premio.
			for (PeliculaDTO aux : peliculasFestival) {
				if (aux.getPremios().compareTo(filtro) == 0) {
					peliculasFiltradas.addPeliculaDTO(aux);
				}
			}
			return peliculasFiltradas;
		}
		else { // Criterio de orden superior para Película.
			for (PeliculaDTO aux : peliculasFestival) {
				if (aux.getTitulo().compareTo(filtro) == 0) {
					peliculasFiltradas.addPeliculaDTO(aux);
				}
			}
			return peliculasFiltradas;
		}
	}
}
