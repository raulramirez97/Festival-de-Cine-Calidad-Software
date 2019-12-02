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

public class ServiceLocator {
	private Client client;
	private WebTarget webTargetService;

	public ServiceLocator() {}

	public void setService(String[] args) {
		client = ClientBuilder.newClient();
		webTargetService = client.target(String.format("http://%s:%s/rest/server/", args[0], args[1]));
		System.out.println(String.format("http://%s:%s/rest/server/", args[0], args[1]));
	}

	public void registerUser(String login, String password) {
		WebTarget registerUserWebTarget = webTargetService.path("registerUser");
		Invocation.Builder invocationBuilder = registerUserWebTarget.request(MediaType.APPLICATION_JSON);

		UsuarioDTO usuarioDTO = new UsuarioDTO(login, password);
		Response response = invocationBuilder.post(Entity.entity(usuarioDTO, MediaType.APPLICATION_JSON));
		if (response.getStatus() != Status.OK.getStatusCode()) {
			System.out.println("Error connecting with the server. Code: " + response.getStatus());
		} else {
			System.out.println("User correctly registered");
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
			System.out.println("Error connecting with the server. Code: " + response.getStatus());
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
			System.out.println("Error connecting with the server. Code: " + response.getStatus());
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
			System.out.println("Error connecting with the server. Code: " + response.getStatus());
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
			System.out.println("Error connecting with the server. Code: " + response.getStatus());
		} else {
			System.out.println("Actor correctly registered");
		}
	}

	public ActorList getActorList() {
		WebTarget sayHelloWebTarget = webTargetService.path("obtainActors");
		Invocation.Builder invocationBuilder = sayHelloWebTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.get();
		if (response.getStatus() != Status.OK.getStatusCode()) {
			System.out.println("Error connecting with the server. Code: " + response.getStatus());
			return new ActorList();
		} else {
			ActorList actores = response.readEntity(ActorList.class);
			return actores;
		}
	}

	public void registerPelicula(String titulo, String sinopsis, String genero, int duracion, int anyo,
								 String director, String enlacetrailer, String premios, String seccion,
								 List<ActorDTO> actores) {
		WebTarget registerUserWebTarget = webTargetService.path("registerPelicula");
		Invocation.Builder invocationBuilder = registerUserWebTarget.request(MediaType.APPLICATION_JSON);
		StringBuilder strActores = new StringBuilder();
		for (ActorDTO aux : actores) {
			strActores.append(aux.getNombre() + " " + aux.getApellido() + ", ");
		}
		PeliculaDTO peliculaDTO = new PeliculaDTO(titulo, sinopsis, genero, duracion, anyo, director, enlacetrailer,
				0, premios,null, seccion, strActores.toString());

		System.out.println("Enviando pelicula: " + peliculaDTO.getTitulo());
		Response response = invocationBuilder.post(Entity.entity(peliculaDTO, MediaType.APPLICATION_JSON));
		if (response.getStatus() != Status.OK.getStatusCode()) {
			System.out.println("Error connecting with the server. Code: " + response.getStatus());
		} else {
			System.out.println("Pelicula correctly registered");
		}
	}

	public PeliculaList getPeliculaList() {
		WebTarget sayHelloWebTarget = webTargetService.path("obtainPeliculas");
		Invocation.Builder invocationBuilder = sayHelloWebTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.get();
		if (response.getStatus() != Status.OK.getStatusCode()) {
			System.out.println("Error connecting with the server. Code: " + response.getStatus());
			return new PeliculaList();
		} else {
			PeliculaList peliculas = response.readEntity(PeliculaList.class);
			return peliculas;
		}
	}

	public void valorarPelicula(String titulo, float valoracion) throws NullPointerException {
		//TODO: PARTE 1, INSERTAR VALORACION.
		WebTarget registerValoracionWebTarget = webTargetService.path("registerValoracion");
		Invocation.Builder invocationBuilder = registerValoracionWebTarget.request(MediaType.APPLICATION_JSON);
		//TODO: Hay que autogenerar un ID aquí en base a la cantidad de valoraciones que haya. Puede ser un timestamp si no, pero eso es
		//TODO: Un coñazo de buscar. Sería mejor leer las valoraciones que hay y hacer un append rapido con eso al titulo de película.
		String id = "a";
		ValoracionDTO valoracionDTO = new ValoracionDTO(id, titulo, valoracion);

		Response response = invocationBuilder.post(Entity.entity(valoracionDTO, MediaType.APPLICATION_JSON));
		if (response.getStatus() != Status.OK.getStatusCode()) {
			System.out.println("Error connecting with the server. Code: " + response.getStatus());
		} else {
			System.out.println("Valoracion correctly registered");
		}
	}

	public ArrayList<String> getFiltroList() throws NullPointerException {
		List<PeliculaDTO> peliculasFestival = new ArrayList<PeliculaDTO>();
		peliculasFestival = getPeliculaList().getPeliculasDTO();
		ArrayList<String> filtrosPelis = new ArrayList<String>();
		if (peliculasFestival.size() == 0) {
			throw new NullPointerException();
		}
		else { //TODO: MODIFICAR PARA QUE SE PUEDA FILTRAR POR DIVERSOS CRITERIOS, NO SOLO POR GENERO.
			Map<String, String> filtersMap = new TreeMap<String, String>();
			for (PeliculaDTO aux : peliculasFestival) {
				if (!(filtersMap.containsKey(aux.getGenero()))) {
					filtersMap.put(aux.getGenero(), aux.getGenero());
				}
			}
			filtrosPelis.addAll(filtersMap.values());
			return filtrosPelis;
		}
	}

	public PeliculaList getFilteredPeliculaList(String filtro) {
		List<PeliculaDTO> peliculasFestival = new ArrayList<PeliculaDTO>();
		peliculasFestival = getPeliculaList().getPeliculasDTO();
		PeliculaList peliculasFiltradas = new PeliculaList();
		for (PeliculaDTO aux : peliculasFestival) {
			if (aux.getGenero().compareTo(filtro) == 0) {
				peliculasFiltradas.addPeliculaDTO(aux);
			}
		}
		return peliculasFiltradas;
	}
}
