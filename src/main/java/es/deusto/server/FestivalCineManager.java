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
import es.deusto.server.data.DirectedMessage;
import es.deusto.server.data.Message;
import es.deusto.server.data.MessageList;
import es.deusto.server.data.UsuarioDTO;
import es.deusto.server.data.ActorDTO;
import es.deusto.server.data.ActorList;
import es.deusto.server.data.PeliculaDTO;
import es.deusto.server.data.PeliculaList;
import es.deusto.server.data.ValoracionDTO;
import es.deusto.server.data.ValoracionList;
import es.deusto.server.data.ComentarioDTO;
import es.deusto.server.data.ComentarioList;

import java.util.ArrayList;
import java.util.List;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Este bloque de código provee una API RESTful para establecer una conexión
 * entre la parte cliente y servidora de la aplicación. A su vez, tiene
 * acceso a los diferentes tipos de dato utilizados en la aplicación
 * representados con el patrón de diseño DTO para poder serializarse y
 * transmitirse, además de al DAO para gestionar la base de datos MySQL con
 * DataNucleus.
 * @author Grupo RMBJ
 * @version 3.0
 * @since 1.0
 */
@Path("/server")
@Produces(MediaType.APPLICATION_JSON)
public class FestivalCineManager {

	private int cont = 0;
	IDAO dao;
	static Logger logger = Logger.getLogger(FestivalCineManager
			.class.getName());

	public FestivalCineManager() {
		super();
		dao = new DBManager();
	}

	public FestivalCineManager(IDAO udao) {
		super();
		dao = udao;
	}

	/**
	 * Método que permite tomar la información del Cliente para hacer un
	 * registro de un nuevo UsuarioDTO.
	 * @param usuarioDTOData UsuarioDTO que contiene la información
	 *                          relevante a ser insertada.
	 * @return Respuesta indicando que la operación se ha hecho correcta
	 * o incorrectamente.
	 */
	@POST
	@Path("/registerUser")
	public Response registerUser(UsuarioDTO usuarioDTOData) {
		logger.info("Checking whether the UsuarioDTO already exists or "
				+ "not: '" + usuarioDTOData.getLogin() + "'");
		UsuarioDTO usuarioDTO = null;
		try {
			usuarioDTO = dao.retrieveUsuario(
					usuarioDTOData.getLogin());
		} catch (Exception e) {
			logger.log(Level.WARNING, "Exception launched: "
					+ e.getMessage());
		}
		if (usuarioDTO != null) {
			logger.info("The user exists. So, setting new password "
					+ "for UsuarioDTO: "
					+ usuarioDTOData.getLogin());
			usuarioDTO.setPassword(usuarioDTOData.getPassword());
			logger.info("Password set for UsuarioDTO: "
					+ usuarioDTOData.getLogin());
			dao.updateUsuario(usuarioDTO);
		} else {
			logger.info("Creating UsuarioDTO: "
					+ usuarioDTOData.getLogin());
			usuarioDTO = new UsuarioDTO(usuarioDTOData.getLogin(),
					usuarioDTOData.getPassword());
			dao.storeUsuario(usuarioDTO);
			logger.info("UsuarioDTO created: "
					+ usuarioDTOData.getLogin());
		}
		return Response.ok().build();
	}

	/**
	 * Método que permite tomar la información del Cliente para hacer un
	 * registro de un nuevo mensaje dirigido (una de las clases a ser
	 * Mockeadas).
	 * @param directedMessage DirectedMessage que contiene la información
	 *                           relevante a ser insertada.
	 * @return Respuesta indicando que la operación se ha hecho correcta
	 * o incorrectamente.
	 */
	@POST
	@Path("/sayMessage")
	public Response sayMessage(DirectedMessage directedMessage) {
		logger.info("Retrieving the user: '"
				+ directedMessage.getUsuarioDTO()
				.getLogin() + "'");
		UsuarioDTO usuarioDTO = null;
		try {
			usuarioDTO = dao.retrieveUsuario(directedMessage
					.getUsuarioDTO().getLogin());
		} catch (Exception e) {
			logger.log(Level.WARNING, "Exception launched: "
					+ e.getMessage());
		}

		logger.info("User retrieved: " + usuarioDTO);
		if (usuarioDTO != null) {
			Message message = new Message(
					directedMessage.getMessage());
			message.setUsuarioDTO(usuarioDTO);
			usuarioDTO.getMessages().add(message);
			dao.updateUsuario(usuarioDTO);
			cont++;
			logger.info(" * Client number: " + cont);
			return Response.ok(directedMessage.getMessage())
					.build();
		} else {
			String m = "Login details supplied for message delivery"
					+ " are not correct";
			logger.info(m);
			return Response.status(Status.BAD_REQUEST)
					.entity(m).build();
		}
	}

	/**
	 * Método que permite enviar los Mensajes de un UsuarioDTO, en base a
	 * un nombre de usuario recibido.
	 * @param login Nombre de usuario para el cual se buscan los mensajes.
	 * @return Respuesta indicando que la operación se ha hecho correcta o
	 * incorrectamente, con el listado de Mensajes.
	 */
	@GET
	@Path("/messages")
	public Response getUserMessages(@QueryParam("login") String login) {
		logger.info("Checking whether the user already exits or not: '"
				+ login + "'");
		UsuarioDTO usuarioDTO = null;
		try {
			usuarioDTO = dao.retrieveUsuario(login);
		} catch (Exception e) {
			logger.log(Level.WARNING, "Exception launched: "
					+ e.getMessage());
		}

		if (usuarioDTO != null) {
			logger.info("Returning the messages to the client: "
					+ login);

			MessageList messageList = new MessageList();
			for (Message m : usuarioDTO.getMessages()) {
				messageList.addMessage(m);
			}
			return Response.ok(messageList).build();
		} else {
			logger.info("The user does not exist, no possibility "
					+ "of retrieving messages ...: " + login);
			return Response.status(Status.BAD_REQUEST)
					.entity("Login details "
					+ "supplied for message delivery "
					+ "are not correct").build();
		}
	}

	/**
	 * Método que valida una autenticación de un UsuarioDTO, en base a las
	 * credenciales recibidas (nombre de usuario y contraseña).
	 * @param login Nombre de usuario que se quiere validar.
	 * @param pwd Contraseña del usuario que se quiere validar.
	 * @return Respuesta indicando que la operación se ha hecho correcta
	 * o incorrectamente, con el UsuarioDTO.
	 */
	@GET
	@Path("obtainUser")
	public Response getUser(@QueryParam("login") String login,
							@QueryParam("pwd") String pwd) {
		logger.info("Checking whether the user already exists or not: '"
				+ login + "'");
		UsuarioDTO usuarioDTO = null;
		try {
			usuarioDTO = dao.retrieveUsuario(login);
		} catch (Exception e) {
			logger.log(Level.WARNING, "Exception launched: "
					+ e.getMessage());
		}
		if (usuarioDTO != null) {
			logger.info("Returning the user to the client: "
					+ login);
			return Response.ok(usuarioDTO).build();
		} else {
			logger.info("The user does not exist, no possibility "
					+ "of retrieving user ...: " + login);
			return Response.status(Status.BAD_REQUEST)
					.entity("Login details"
					+ " supplied for user delivery is "
					+ "not correct").build();
		}
	}

	/**
	 * Método que facilita el registro de un ActorDTO al sistema mediante la
	 * información tomada del Cliente.
	 * @param actorDTOData ActorDTO que se quiere insertar en la base
	 *                        de datos.
	 * @return Respuesta indicando que la operación se ha hecho correcta o
	 * incorrectamente.
	 */
	@POST
	@Path("/registerActor")
	public Response registerActor(ActorDTO actorDTOData) {
		logger.info("Checking whether the actor already "
				+ "exists or not: '"
				+ actorDTOData.getNombre() + " "
				+ actorDTOData.getApellido() + "'");
		ActorDTO actorDTO = null;
		try {
			actorDTO = dao.retrieveActor(
					actorDTOData.getIdentificador());
		} catch (Exception e) {
			logger.log(Level.WARNING, "Exception launched: "
					+ e.getMessage());
		}

		if (actorDTO != null) {
			logger.info("The actor already exists.");
		} else {
			logger.info("Creating actor: "
					+ actorDTOData.getNombre()
					+ " " + actorDTOData.getApellido());
			actorDTO = new ActorDTO(actorDTOData.getIdentificador(),
					actorDTOData.getNombre(),
					actorDTOData.getApellido(),
					actorDTOData.getEdad());
			dao.storeActor(actorDTO);
			logger.info("Actor created: " + actorDTOData.getNombre()
					+ " " + actorDTOData.getApellido()
					+ " , with ID: "
					+ actorDTOData.getIdentificador());
		}
		return Response.ok().build();
	}

	/**
	 * Método que permite recuperar un listado de ActoresDTO que se
	 * encuentran en la base de datos.
	 * @return Respuesta indicando que la operación se ha hecho correcta o
	 * incorrectamente, con el listado de ActoresDTO.
	 */
	@GET
	@Path("/obtainActors")
	public Response getActors() {
		logger.info("Returning the actors to the client.");
		ActorList actorList = new ActorList();
		actorList.setActorsDTO(dao.getActors());
		if (actorList.getActorsDTO().size() > 0) {
			return Response.ok(actorList).build();
		} else {
			String m = "There is no actor to retrieve ...";
			logger.info(m);
			return Response.status(Status.BAD_REQUEST)
					.entity(m).build();
		}
	}

	/**
	 * Método que permite actualizar los datos de un ActorDTO, en base a la
	 * información recibida por el Cliente.
	 * @param actorDTOData Información a actualizar de un ActorDTO.
	 * @return Respuesta indicando que la operación se ha hecho correcta
	 * o incorrectamente.
	 */
	@POST
	@Path("/updateActor")
	public Response updateActor(ActorDTO actorDTOData) {
		ActorDTO actorDTO = null;
		try {
			actorDTO = dao.retrieveActor(
					actorDTOData.getIdentificador());
		} catch (Exception e) {
			logger.log(Level.WARNING, "Exception launched: "
					+ e.getMessage());
		}
		if (actorDTO != null) {
			logger.info("Actor found. Updating the actor: "
					+ actorDTOData.getNombre() + " "
					+ actorDTOData.getApellido());
			dao.updateActor(actorDTO);
			logger.info("(FestivalCineManager) Actor updated : "
					+ actorDTOData.getNombre() + " "
					+ actorDTOData.getApellido());
		} else {
			logger.info("The actor wasn't found in the database.");
		}

		return Response.ok().build();
	}

	/**
	 * Método que permite insertar los datos de una nueva PeliculaDTO,
	 * en base a la información del Cliente.
	 * @param peliculaDTOData Información a insertar de una PeliculaDTO.
	 * @return Respuesta indicando que la operación se ha hecho correcta
	 * o incorrectamente.
	 */
	@POST
	@Path("/registerPelicula")
	public Response registerPelicula(PeliculaDTO peliculaDTOData) {
		logger.info("Checking whether the pelicula already exists "
				+ "or not: '" + peliculaDTOData.getTitulo());
		PeliculaDTO peliculaDTO = null;
		try {
			peliculaDTO = dao.retrievePelicula(
					peliculaDTOData.getTitulo());
		} catch (Exception e) {
			logger.log(Level.WARNING, "Exception launched: "
					+ e.getMessage());
		}

		if (peliculaDTO != null) {
			logger.info("The pelicula already exists.");
		} else {
			logger.info("Creating pelicula: "
					+ peliculaDTOData.getTitulo());
			peliculaDTO = new PeliculaDTO(
					peliculaDTOData.getTitulo(),
					peliculaDTOData.getSinopsis(),
					peliculaDTOData.getGenero(),
					peliculaDTOData.getDuracion(),
					peliculaDTOData.getAnyo(),
					peliculaDTOData.getDirector(),
					peliculaDTOData.getEnlaceTrailer(),
					peliculaDTOData.getValoracionMedia(),
					peliculaDTOData.getPremios(),
					peliculaDTOData.getComentarios(),
					peliculaDTOData.getSeccionFestival(),
					peliculaDTOData.getActores(),
					peliculaDTOData.getURIimagen());
			dao.storePelicula(peliculaDTO);
			logger.info("Pelicula created: "
					+ peliculaDTOData.getTitulo());
		}
		return Response.ok().build();
	}

	/**
	 * Método que permite recuperar un listado de PeliculasDTO que se
	 * encuentran en la base de datos.
	 * @return Respuesta indicando que la operación se ha hecho correcta
	 * o incorrectamente, con el listado de PeliculasDTO.
	 */
	@GET
	@Path("/obtainPeliculas")
	public Response getPeliculas() {
		logger.info("Returning the peliculas to the client");
		PeliculaList peliculaList = new PeliculaList();
		peliculaList.setPeliculasDTO(dao.getPeliculas());
		if (peliculaList.getPeliculasDTO().size() > 0) {
			return Response.ok(peliculaList).build();
		} else {
			String m = "There is no pelicula to retrieve ...";
			logger.info(m);
			return Response.status(Status.BAD_REQUEST)
					.entity(m).build();
		}
	}

	/**
	 * Método que permite insertar una ValoracionDTO de una PeliculaDTO
	 * en el sistema.
	 * @param valoracionDTOData Información relativa a la ValoracionDTO
	 *                             a insertar.
	 * @return Respuesta indicando que la operación se ha hecho correcta
	 * o incorrectamente.
	 * @throws NullPointerException Excepción lanzada al no encontrar
	 * películas a valorar.
	 */
	@POST
	@Path("/registerValoracion")
	public Response registerValoracion(ValoracionDTO valoracionDTOData)
			throws NullPointerException {
		logger.info("Checking whether the pelicula to value"
				+ " already exists or not: '"
				+ valoracionDTOData.getTitulo());
		PeliculaDTO peliculaDTO = null;
		ValoracionDTO valoracionDTO = null;
		double promedio = 0;
		int numValoracionesTitulo = 0;
		try {
			peliculaDTO = dao.retrievePelicula(valoracionDTOData
					.getTitulo());
		} catch (Exception e) {
			logger.log(Level.WARNING, "Exception launched: "
					+ e.getMessage());
			throw new NullPointerException();
		}

		if (peliculaDTO != null) {
			logger.info("The pelicula exists. The valoracion "
					+ "will be done.");
			logger.info("Valorating pelicula: "
					+ valoracionDTOData.getTitulo());

			ValoracionList myValoracionList =
					getLocalValoraciones();
			if (myValoracionList != null) {
				List<ValoracionDTO> valoracionCheck =
						myValoracionList.getValoracionesDTO();
				List<ValoracionDTO> valoracionTitulo =
						new ArrayList<>();
				double totalValoracionesTitulo = 0;
				for (ValoracionDTO aux: valoracionCheck) {
					if (aux.getTitulo().compareTo(
							valoracionDTOData
							.getTitulo()) == 0) {
						valoracionTitulo.add(aux);
						totalValoracionesTitulo +=
								aux.getValoracion();
					}
				}
				int numTotalValoraciones =
						valoracionCheck.size();
				numValoracionesTitulo =
						valoracionTitulo.size() + 1;
				logger.info("Saving valoracion: "
						+ (numTotalValoraciones + 1));
				valoracionDTO = new ValoracionDTO(
						numTotalValoraciones + 1,
						valoracionDTOData.getTitulo(),
						valoracionDTOData
								.getValoracion());
				dao.storeValoracion(valoracionDTO);
				logger.info("Valoracion created: "
						+ valoracionDTO.getId());

				promedio = (totalValoracionesTitulo
						+ valoracionDTOData
						.getValoracion())
						/ numValoracionesTitulo;
			} 	else {
				logger.info("Saving valoracion: " + 1);
				valoracionDTO = new ValoracionDTO(1,
						valoracionDTOData.getTitulo(),
						valoracionDTOData
								.getValoracion());
				dao.storeValoracion(valoracionDTO);
				logger.info("Valoracion created: " + 1);

				promedio = valoracionDTOData.getValoracion();
			}
			peliculaDTO.setNumvaloraciones(numValoracionesTitulo);
			peliculaDTO.setValoracionMedia(promedio);
			dao.updatePelicula(peliculaDTO);
		}

		return Response.ok().build();
	}

	/**
	 * Método que permite recuperar un listado de ValoracionesDTO que se
	 * encuentran guardadas en la base de datos. Este método no tiene verbos
	 * HTTP dado que su uso se delimita al ámbito del Servidor.
	 * @return Listado de ValoracionesDTO para posteriormente ser usadas por
	 * otro método del Servidor.
	 */
	public ValoracionList getLocalValoraciones() {
		logger.info("Returning the valoraciones");

		ValoracionList valoracionList = new ValoracionList();
		valoracionList.setValoracionesDTO((dao.getValoraciones()));
		if (valoracionList.getValoracionesDTO().size() > 0) {
			return valoracionList;
		} else {
			logger.info("There is no valoracion to retrieve ...");
			return null;
		}
	}

	/**
	 * Método cuyo objetivo es el de registrar un nuevo ComentarioDTO en la
	 * base de datos, en base a la información recibida del Cliente.
	 * @param comentarioDTOData Información a insertar en la base de datos.
	 * @return Respuesta indicando que la operación se ha hecho correcta
	 * o incorrectamente.
	 * @throws NullPointerException Excepción lanzada al no encontrar
	 * películas a comentar.
	 */
	@POST
	@Path("/registerComment")
	public Response registerComment(ComentarioDTO comentarioDTOData)
			throws NullPointerException {
		logger.info("Checking whether the pelicula to comment "
				+ "already exists or not: '"
				+ comentarioDTOData.getPelicula().getTitulo());
		PeliculaDTO peliculaDTO = null;
		ComentarioDTO comentarioDTO = null;
		try {
			peliculaDTO = dao.retrievePelicula(comentarioDTOData
					.getPelicula().getTitulo());
		} catch (Exception e) {
			logger.log(Level.WARNING, "Exception launched: "
					+ e.getMessage());
			throw new NullPointerException();
		}

		if (peliculaDTO != null) {
			logger.info("The pelicula exists. The comentario "
					+ "will be done.");
			logger.info("Commenting pelicula: "
					+ comentarioDTOData.getPelicula()
					.getTitulo());

			ComentarioList myComentarioList = getLocalComentarios();
			if (myComentarioList != null) {
				List<ComentarioDTO> comentarioCheck =
						myComentarioList
								.getComentariosDTO();
				int numTotalComentarios = comentarioCheck
						.size();
				logger.info("Saving comentario "
						+ (numTotalComentarios + 1));
				comentarioDTO = new ComentarioDTO(
						numTotalComentarios + 1,
						peliculaDTO,
						comentarioDTOData.getUsuario(),
						comentarioDTOData
								.getContenido());

				peliculaDTO.getComentarios().add(comentarioDTO);
				comentarioDTO.setPelicula(peliculaDTO);
				dao.updatePelicula(peliculaDTO);
				return Response.ok().build();
			} else {
				comentarioDTO = new ComentarioDTO(1,
						peliculaDTO, comentarioDTOData
						.getUsuario(),
						comentarioDTOData
								.getContenido());
				peliculaDTO.getComentarios().add(comentarioDTO);
				comentarioDTO.setPelicula(peliculaDTO);
				dao.updatePelicula(peliculaDTO);
				return Response.ok().build();
			}
		} else {
			return Response.status(Status.BAD_REQUEST).entity(
					"There is no pelicula to comment ...")
					.build();
		}
	}

	/**
	 * Método que permite recuperar un listado de ComentariosDTO que se
	 * encuentran guardados en la base de datos. Este método no tiene verbos
	 * HTTP dado que su uso se delimita al ámbito del Servidor.
	 * @return Listado de ComentariosDTO para posteriormente ser usadas por
	 * otro método del Servidor.
	 */
	public ComentarioList getLocalComentarios() {
		logger.info("Returning the comentarios");

		ComentarioList comentarioList = new ComentarioList();
		comentarioList.setComentariosDTO((dao.getComentarios()));
		if (comentarioList.getComentariosDTO().size() > 0) {
			return comentarioList;
		} else {
			logger.info("There is no comentario to retrieve ...");
			return null;
		}
	}
}
