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

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

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
	@Path("/updateActor")
	public Response updateActor(ActorDTO actorDTOData) {
		//System.out.println("Checking whether the pelicula already exists or not: '" + peliculaDTOData.getTitulo());
		ActorDTO actorDTO = null;
		try {
			actorDTO = dao.retrieveActor(actorDTOData.getIdentificador());
		} catch (Exception e) {
			System.out.println("Exception launched: " + e.getMessage());
		}

		if (actorDTO != null) {
			System.out.println("Actor found. Updating the actor: " + actorDTOData.getNombre() + " " + actorDTOData.getApellido());
			//TODO: CUIDADO CON EL SETTEO.
			//actorDTO.setPelicula(actorDTOData.getPelicula(actorDTOData.getPeliculas().size()-1));
			dao.updateActor(actorDTO);
			System.out.println("(FestivalCineManager) Actor updated : " + actorDTOData.getNombre() + " " + actorDTOData.getApellido());
		} else {
			//TODO: SI ESTA BIEN HECHO, ESTO NO DEBERIA SUCEDER NUNCA POR LA PROPIA LOGICA DEL PROGRAMA (PRIMERO
			//TODO: GENERAR ACTORES, DESPUES PELICULAS).
			System.out.println("The actor wasn't found in the database.");
		}

		return Response.ok().build();
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
		}
		else {
			System.out.println("Creating pelicula: " + peliculaDTOData.getTitulo());
			peliculaDTO = new PeliculaDTO(peliculaDTOData.getTitulo(), peliculaDTOData.getSinopsis(),
					peliculaDTOData.getGenero(), peliculaDTOData.getDuracion(), peliculaDTOData.getAnyo(),
					peliculaDTOData.getDirector(), peliculaDTOData.getEnlaceTrailer(), peliculaDTOData.getValoracionMedia(),
					peliculaDTOData.getPremios(), peliculaDTOData.getComentarios(),
					peliculaDTOData.getSeccionFestival(), peliculaDTOData.getActores());
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

	@POST
	@Path("/registerValoracion")
	public Response registerValoracion(ValoracionDTO valoracionDTOData) throws NullPointerException {
		System.out.println("Checking whether the pelicula to valorate already exists or not: '" + valoracionDTOData.getTitulo());
		PeliculaDTO peliculaDTO = null;
		ValoracionDTO valoracionDTO = null;
		float promedio = 0;
		int numValoracionesTitulo = 0;
		try {
			peliculaDTO = dao.retrievePelicula(valoracionDTOData.getTitulo());
		} catch (Exception e) {
			System.out.println("Exception launched: " + e.getMessage());
			throw new NullPointerException();
		}

		if (peliculaDTO != null) {
			System.out.println("The pelicula exists. The valoracion will be done.");
			System.out.println("Valorating pelicula: " + valoracionDTOData.getTitulo());

			//TODO: Paso 1: Recuperar la lista de valoraciones.
			ValoracionList myValoracionList = getLocalValoraciones();
			if (myValoracionList != null) {
				//TODO: Paso 2: Filtrar los elementos de la lista de valoraciones que sean del título a valorar.
				List<ValoracionDTO> valoracionCheck = myValoracionList.getValoracionesDTO();
				List<ValoracionDTO> valoracionTitulo = new ArrayList<ValoracionDTO>();
				float totalValoracionesTitulo = 0;
				for (ValoracionDTO aux: valoracionCheck){
					if (aux.getTitulo().compareTo(valoracionDTOData.getTitulo())==0){
						valoracionTitulo.add(aux);
						totalValoracionesTitulo += aux.getValoracion();
					}
				}
				//TODO: Paso 3: Añadir valoración a la BD.
				int numTotalValoraciones = valoracionCheck.size();
				numValoracionesTitulo = valoracionTitulo.size()+1; //Valoraciones que se hicieron + la nueva.
				System.out.println("Saving valoracion: " + (numTotalValoraciones+1));
				valoracionDTO = new ValoracionDTO(numTotalValoraciones+1, valoracionDTOData.getTitulo(), valoracionDTOData.getValoracion());
				dao.storeValoracion(valoracionDTO);
				System.out.println("Valoracion created: " + valoracionDTO.getId());
				//TODO: Paso 4: Establecer valoración de la película haciendo el promedio de todas las valoraciones previas + la nueva.

				promedio = (totalValoracionesTitulo+valoracionDTOData.getValoracion())/numValoracionesTitulo;
			}
			else{
				//TODO: Con esto se ha almacenado la valoración cuando se inserta. Esto se usará posteriormente para hacer una media con todas las valoraciones
				//TODO: existentes para una película determinada.
				System.out.println("Saving valoracion: " + 1);
				valoracionDTO = new ValoracionDTO(1, valoracionDTOData.getTitulo(), valoracionDTOData.getValoracion());
				dao.storeValoracion(valoracionDTO);
				System.out.println("Valoracion created: " + 1);
				promedio = valoracionDTOData.getValoracion();
			}
			peliculaDTO.setNumvaloraciones(numValoracionesTitulo);
			peliculaDTO.setValoracionMedia(promedio);
			dao.updatePelicula(peliculaDTO);
		}

		return Response.ok().build();
	}

	public ValoracionList getLocalValoraciones() {
		System.out.println("Returning the valoraciones");

		ValoracionList valoracionList = new ValoracionList();
		valoracionList.setValoracionesDTO((dao.getValoraciones()));
		if (valoracionList.getValoracionesDTO().size()>0){
			return valoracionList;
		} else {
			System.out.println("There is no valoracion to retrieve ...");
			return null;
			//return Response.status(Status.BAD_REQUEST).entity("There is no valoracion to retrieve ...").build();
		}
	}

	//TODO: MANTENER ESTA PETICIÓN SI AL FINAL SE USA LA LISTA DE VALORACIONES DE CARA AL CLIENTE; SI NO, BORRAR.

//	@GET
//	@Path("/obtainValoraciones")
//	public Response getValoraciones() {
//		System.out.println("Returning the valoraciones");
//
//		ValoracionList valoracionList = new ValoracionList();
//		valoracionList.setValoracionesDTO((dao.getValoraciones());
//		if (valoracionList.getValoracionesDTO().size()>0){
//
//			return Response.ok(valoracionList).build();
//		} else {
//			System.out.println("There is no valoracion to retrieve ...");
//			return Response.status(Status.BAD_REQUEST).entity("There is no valoracion to retrieve ...").build();
//		}
//	}

//	@POST
//	@Path("/registerComment")
//	public Response registerComment(ComentarioDTO comentarioDTOData) throws NullPointerException {
//		System.out.println("Checking whether the pelicula to comment already exists or not: '" + comentarioDTOData.getTitulo());
//		PeliculaDTO peliculaDTO = null;
//		try {
//			peliculaDTO = dao.retrievePelicula(valoracionDTOData.getTitulo());
//		} catch (Exception e) {
//			System.out.println("Exception launched: " + e.getMessage());
//			throw new NullPointerException();
//		}
//
//		if (peliculaDTO != null) {
//			System.out.println("The pelicula exists. The valoracion will be done.");
//			System.out.println("Valorating pelicula: " + valoracionDTOData.getTitulo());
//			//TODO: ARREGLAR EL CALCULO. ESTO ES UNA MEDIA INCCORECTA; SE HA HECHO COMO PRIMERA ITERACION PARA COMPROBAR QUE
//			//TODO: LA EXTRACCION DE DATOS FUNCIONA.
//			peliculaDTO.setNumvaloraciones(peliculaDTO.getNumvaloraciones()+1);
//			peliculaDTO.setValoracionMedia((peliculaDTO.getValoracionMedia()+valoracionDTOData.getValoracion())/peliculaDTO.getNumvaloraciones());
//			dao.updatePelicula(peliculaDTO);
//		}
//
//		return Response.ok().build();
//	}
}
