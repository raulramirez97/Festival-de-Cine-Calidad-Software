package es.deusto.server;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import es.deusto.server.dao.IDAO;
import es.deusto.server.dao.DBManager;
import es.deusto.server.data.*;

@Path("/server")
@Produces(MediaType.APPLICATION_JSON)
public class FestivalCineManager {

	private int cont = 0;
	IDAO dao;

	public FestivalCineManager() {
		super();
		dao = new DBManager();
	}

	public FestivalCineManager(IDAO udao) {
		super();
		dao = udao;
	}

	@POST
	@Path("/registerUser")
	public Response registerUser(UsuarioDTO usuarioDTOData) {
		System.out.println("Checking whether the user already exists or not: '" + usuarioDTOData.getLogin() + "'");
		UsuarioDTO usuarioDTO = null;
		try {
			usuarioDTO = dao.retrieveUsuario(usuarioDTOData.getLogin());
		} catch (Exception e) {
			System.out.println("Exception launched: " + e.getMessage());
		}

		if (usuarioDTO != null) {
			System.out.println("The user exists. So, setting new password for User: " + usuarioDTOData.getLogin());
			usuarioDTO.setPassword(usuarioDTOData.getPassword());
			System.out.println("Password set for User: " + usuarioDTOData.getLogin());
			dao.updateUsuario(usuarioDTO);
		} else {
			System.out.println("Creating user: " + usuarioDTOData.getLogin());
			usuarioDTO = new UsuarioDTO(usuarioDTOData.getLogin(), usuarioDTOData.getPassword());
			dao.storeUsuario(usuarioDTO);
			System.out.println("User created: " + usuarioDTOData.getLogin());
		}

		return Response.ok().build();
	}

	@POST
	@Path("/sayMessage")
	public Response sayMessage(DirectedMessage directedMessage) {
		System.out.println("Retrieving the user: '" + directedMessage.getUsuarioDTO().getLogin() + "'");
		UsuarioDTO usuarioDTO = null;
		try {
			usuarioDTO = dao.retrieveUsuario(directedMessage.getUsuarioDTO().getLogin());
		} catch (Exception e) {
			System.out.println("Exception launched: " + e.getMessage());
		}

		System.out.println("User retrieved: " + usuarioDTO);
		if (usuarioDTO != null) {
			Message message = new Message(directedMessage.getMessage());
			message.setUsuarioDTO(usuarioDTO);
			usuarioDTO.getMessages().add(message);
			dao.updateUsuario(usuarioDTO);
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
		UsuarioDTO usuarioDTO = null;
		try {
			usuarioDTO = dao.retrieveUsuario(login);
		} catch (Exception e) {
			System.out.println("Exception launched: " + e.getMessage());
		}

		if (usuarioDTO != null) {
			System.out.println("Returning the messages to the client: " + login);

			MessageList messageList = new MessageList();
			for (Message m : usuarioDTO.getMessages()) {
				messageList.addMessage(m);
			}
			return Response.ok(messageList).build();
		} else {
			System.out.println("The user does not exist, no possibility of retrieving messages ...: " + login);
			return Response.status(Status.BAD_REQUEST).entity("Login details supplied for message delivery are not correct").build();
		}
	}

//	@GET
//	@Path("/user")
//	public Response getUser(@QueryParam("credentials") ArrayList<String> credentials) {
//		System.out.println("Checking whether the user already exits or not: '" + credentials.get(0) + "'");
//		UsuarioDTO usuarioDTO = null;
//		try {
//			usuarioDTO = dao.retrieveUser(credentials.get(0));
//		} catch (Exception e) {
//			System.out.println("Exception launched: " + e.getMessage());
//		}
//
//		if (usuarioDTO != null) {
//			System.out.println("Returning the user to the client: " + credentials.get(0));
//
//			return Response.ok(usuarioDTO).build();
//		} else {
//			System.out.println("The user does not exist, no possibility of retrieving user ...: " + credentials.get(0));
//			return Response.status(Status.BAD_REQUEST).entity("Login details supplied for user delivery is not correct").build();
//		}
//	}
	@GET
	@Path("obtainUser")
	public Response getUser(@QueryParam("login") String login, @QueryParam("pwd") String pwd) {
		System.out.println("Checking whether the user already exists or not: '" + login + "'");
		UsuarioDTO usuarioDTO = null;
		try {
			usuarioDTO = dao.retrieveUsuario(login);
		} catch (Exception e) {
			System.out.println("Exception launched: " + e.getMessage());
		}

		if (usuarioDTO != null) {
			System.out.println("Returning the user to the client: " + login);

			return Response.ok(usuarioDTO).build();
		} else {
			System.out.println("The user does not exist, no possibility of retrieving user ...: " + login);
			return Response.status(Status.BAD_REQUEST).entity("Login details supplied for user delivery is not correct").build();
		}
	}
	@POST
	@Path("/registerActor")
	public Response registerActor(ActorDTO actorDTOData) {
		System.out.println("Checking whether the actor already exists or not: '" + actorDTOData.getNombre() + " "
						+actorDTOData.getApellido() + "'");
		ActorDTO actorDTO = null;
		try {
			actorDTO = dao.retrieveActor(actorDTOData.getIdentificador());
		} catch (Exception e) {
			System.out.println("Exception launched: " + e.getMessage());
		}

		if (actorDTO != null) {
			System.out.println("The actor already exists.");
		} else {
			System.out.println("Creating actor: " + actorDTOData.getNombre() + " " + actorDTOData.getApellido());
			actorDTO = new ActorDTO(actorDTOData.getIdentificador(), actorDTOData.getNombre(), actorDTOData.getApellido(),
					actorDTOData.getEdad());
			dao.storeActor(actorDTO);
			System.out.println("Actor created: " + actorDTOData.getNombre() + " " + actorDTOData.getApellido() + " ," +
					"with ID: " + actorDTOData.getIdentificador());
		}

		return Response.ok().build();
	}

	@GET
	@Path("/obtainActors")
	public Response getActors() {
		System.out.println("Returning the actors to the client");

		ActorList actorList = new ActorList();
		actorList.setActorsDTO(dao.getActors());
		if (actorList.getActorsDTO().size()>0){

		return Response.ok(actorList).build();
		} else {
			System.out.println("There is no actor to retrieve ...");
			return Response.status(Status.BAD_REQUEST).entity("There is no actor to retrieve ...").build();
		}
	}

	@POST
	@Path("/registerPelicula")
	public Response registerPelicula(PeliculaDTO peliculaDTOData) {
		System.out.println("Checking whether the pelicula already exists or not: '" + peliculaDTOData.getTitulo());
		PeliculaDTO peliculaDTO = null;
		try {
			peliculaDTO = dao.retrievePelicula(peliculaDTOData.getTitulo());
		} catch (Exception e) {
			System.out.println("Exception launched: " + e.getMessage());
		}

		if (peliculaDTO != null) {
			System.out.println("The pelicula already exists.");
		} else {
			System.out.println("Creating pelicula: " + peliculaDTOData.getTitulo());
			peliculaDTO = new PeliculaDTO(peliculaDTOData.getTitulo(), peliculaDTOData.getSinopsis(),
					peliculaDTOData.getGenero(), peliculaDTOData.getDuracion(), peliculaDTOData.getDirector(),
					peliculaDTOData.getEnlaceTrailer(), peliculaDTOData.getValoracionMedia(),
					peliculaDTOData.getPremios(), peliculaDTOData.getComentarios(), peliculaDTOData.getActores());
			dao.storePelicula(peliculaDTO);
			System.out.println("Pelicula created: " + peliculaDTOData.getTitulo());
		}

		return Response.ok().build();
	}

	@GET
	@Path("/obtainPeliculas")
	public Response getPeliculas() {
		System.out.println("Returning the peliculas to the client");

		PeliculaList peliculaList = new PeliculaList();
		peliculaList.setPeliculasDTO(dao.getPeliculas());
		if (peliculaList.getPeliculasDTO().size()>0){

			return Response.ok(peliculaList).build();
		} else {
			System.out.println("There is no pelicula to retrieve ...");
			return Response.status(Status.BAD_REQUEST).entity("There is no pelicula to retrieve ...").build();
		}
	}
}
