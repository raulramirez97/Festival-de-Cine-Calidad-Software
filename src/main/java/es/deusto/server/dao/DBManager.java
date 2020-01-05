package es.deusto.server.dao;

import es.deusto.server.data.*;

import javax.jdo.*;
import java.util.ArrayList;
import java.util.logging.Logger;

/**
 * Este bloque de código implementa la interfaz IDAO, y representa la
 * implementación del patrón de diseño DAO. Por lo tanto, es la clase
 * encargada de hacer procesos CRU (Create, Read, Update) con los datos de la
 * base de datos MySQL, gestionada a su vez mediante DataNucleus.
 *
 * El borrado de datos se ha creado para ser utilizado por la clase de test
 * DAOTest.java, por ello no se ha puesto como operación disponible por la
 * interfaz IDAO.
 *
 * @author Grupo RMBJ
 * @version 3.0
 * @since 1.0
 */
public class DBManager implements IDAO {

	private PersistenceManagerFactory pmf;

	static Logger logger = Logger.getLogger(DBManager.class.getName());

	public DBManager() {
		pmf = JDOHelper
				.getPersistenceManagerFactory(
						"datanucleus.properties");
	}

	/**
	 * Método que permite insertar un UsuarioDTO en la base de datos.
	 * @param u UsuarioDTO a insertar.
	 */
	@Override
	public void storeUsuario(UsuarioDTO u) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			logger.info("* Storing a user: " + u.getLogin());
			pm.makePersistent(u);
			tx.commit();
		} catch (Exception ex) {
			logger.severe("$ Error storing an object: "
					+ ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
	}

	/**
	 * Método que permite buscar un UsuarioDTO por su nombre de usuario.
	 * @param login Nombre de usuario por el que realizar la búsqueda.
	 * @return UsuarioDTO encontrado bajo ese nombre de usuario.
	 */
	@Override
	public UsuarioDTO retrieveUsuario(String login) {
		UsuarioDTO usuarioDTO = null;
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(2);
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			usuarioDTO = pm.getObjectById(UsuarioDTO.class, login);
			tx.commit();
		} catch (JDOObjectNotFoundException jonfe) {
			logger.severe("User does not exist: "
					+ jonfe.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		return usuarioDTO;
	}

	/**
	 * Método que permite hacer una actualización de un UsuarioDTO con sus
	 * nuevos datos.
	 * @param u UsuarioDTO con los datos modificados para modificar en la
	 *            base de datos.
	 */
	@Override
	public void updateUsuario(UsuarioDTO u) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			pm.makePersistent(u);
			tx.commit();
		} catch (Exception ex) {
			logger.severe("Error updating a user: "
					+ ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
	}

	/**
	 * Método que permite hacer un borrado de un UsuarioDTO. Solamente
	 * se utiliza en las clases de test.
	 * @param u UsuarioDTO del cual se va a hacer el borrado.
	 */
	public void deleteUsuario(UsuarioDTO u) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			pm.deletePersistent(u);
			tx.commit();
		} catch (Exception ex) {
			logger.severe("Error deleting a user: "
					+ ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
	}

	/**
	 * Método que permite insertar un ActorDTO en la base de datos.
	 * @param a ActorDTO a insertar.
	 */
	@Override
	public void storeActor(ActorDTO a) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			logger.info("   * Storing an actor: "
					+ a.getNombre() + " "
					+ a.getApellido());
			pm.makePersistent(a);
			tx.commit();
		} catch (Exception ex) {
			logger.severe("   $ Error storing an object: "
					+ ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
	}

	/**
	 * Método que permite buscar un ActorDTO por su identificativo.
	 * @param id Código identificativo por el que realizar la búsqueda.
	 * @return ActorDTO encontrado bajo ese código identificativo.
	 */
	@Override
	public ActorDTO retrieveActor(String id) {
		ActorDTO actorDTO = null;
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(3);
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			actorDTO = pm.getObjectById(ActorDTO.class, id);
			tx.commit();
		} catch (JDOObjectNotFoundException jonfe) {
			logger.severe("Actor does not exist: "
					+ jonfe.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		return actorDTO;
	}

	/**
	 * Método que permite hacer una actualización de un ActorDTO con sus
	 * nuevos datos.
	 * @param a ActorDTO con los datos modificados para modificar en la
	 *             base de datos.
	 */
	@Override
	public void updateActor(ActorDTO a) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			pm.makePersistent(a);
			tx.commit();
		} catch (Exception ex) {
			logger.severe("Error updating an actor: "
					+ ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
	}

	/**
	 * Método que permite hacer un borrado de un ActorDTO. Solamente
	 * se utiliza en las clases de test.
	 * @param a ActorDTO del cual se va a hacer el borrado.
	 */
	public void deleteActor(ActorDTO a) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			pm.deletePersistent(a);
			tx.commit();
		} catch (Exception ex) {
			logger.severe("Error deleting an actor: "
					+ ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
	}

	/**
	 * Método que permite recuperar un listado de ActoresDTO de la base
	 * de datos.
	 * @return Listado de ActoresDTO existentes en la base de datos.
	 */
	@Override
	public ArrayList<ActorDTO> getActors() {
		ArrayList<ActorDTO> actors = new ArrayList<ActorDTO>();
		PersistenceManager pm = null;
		Transaction tx = null;
		try {
			pm = pmf.getPersistenceManager();
			tx = pm.currentTransaction();
			tx.begin();
			Extent<ActorDTO> extent = pm.getExtent(
					ActorDTO.class, true);

			for (ActorDTO actor : extent) {
				actors.add(actor);
			}
		} catch (Exception ex) {
			logger.severe(
					" $ Error retrieving actors using "
							+ "an 'Extent': " + ex.getMessage());
		} finally {
			if (pm != null && !pm.isClosed()) {
				pm.close();
			}
		}
		return actors;
	}

	/**
	 * Método que permite insertar una PeliculaDTO en la base de datos.
	 * @param p PeliculaDTO a insertar.
	 */
	@Override
	public void storePelicula(PeliculaDTO p) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			logger.info("   * Storing a pelicula: "
					+ p.getTitulo());
			pm.makePersistent(p);
			tx.commit();
		} catch (Exception ex) {
			logger.severe("   $ Error storing an object: "
					+ ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
	}

	/**
	 * Método que permite buscar una PeliculaDTO por su título.
	 * @param titulo Título de la película por el que realizar la búsqueda.
	 * @return PeliculaDTO encontrada bajo ese título.
	 */
	@Override
	public PeliculaDTO retrievePelicula(String titulo) {
		PeliculaDTO peliculaDTO = null;
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(3);
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			peliculaDTO = pm.getObjectById(PeliculaDTO.class,
					titulo);
			tx.commit();
		} catch (JDOObjectNotFoundException jonfe) {
			logger.severe("Pelicula does not exist: "
					+ jonfe.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		return peliculaDTO;
	}

	/**
	 * Método que permite hacer una actualización de una PeliculaDTO con sus
	 * nuevos datos.
	 * @param p PeliculaDTO con los datos modificados para modificar en
	 *            la base de datos.
	 */
	@Override
	public void updatePelicula(PeliculaDTO p) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			pm.makePersistent(p);
			tx.commit();
		} catch (Exception ex) {
			logger.severe("Error updating a pelicula: "
					+ ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
	}

	/**
	 * Método que permite hacer un borrado de una PeliculaDTO. Solamente se
	 * utiliza en las clases de test.
	 * @param p PeliculaDTO de la cual se va a hacer el borrado.
	 */
	public void deletePelicula(PeliculaDTO p) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			pm.deletePersistent(p);
			tx.commit();
		} catch (Exception ex) {
			logger.severe("Error deleting a pelicula: "
					+ ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
	}

	/**
	 * Método que permite recuperar un listado de PeliculasDTO de la
	 * base de datos.
	 * @return Listado de PeliculasDTO existentes en la base de datos.
	 */
	@Override
	public ArrayList<PeliculaDTO> getPeliculas() {
		ArrayList<PeliculaDTO> peliculas = new ArrayList<PeliculaDTO>();
		PersistenceManager pm = null;
		Transaction tx = null;
		try {
			pm = pmf.getPersistenceManager();
			tx = pm.currentTransaction();
			tx.begin();
			Extent<PeliculaDTO> extent = pm.getExtent(
					PeliculaDTO.class, true);

			for (PeliculaDTO pelicula : extent) {
				peliculas.add(pelicula);
			}
		} catch (Exception ex) {
			logger.severe(
					" $ Error retrieving peliculas using "
							+ "an 'Extent': " + ex.getMessage());
		} finally {
			if (pm != null && !pm.isClosed()) {
				pm.close();
			}
		}
		return peliculas;
	}

	/**
	 * Método que permite almacenar la ValoracionDTO hecha de una
	 * PeliculaDTO.
	 * @param v ValoracionDTO a almacenar en la base de datos.
	 */
	@Override
	public void storeValoracion(ValoracionDTO v) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			logger.info("   * Storing a valoracion: "
					+ v.getId());
			pm.makePersistent(v);
			tx.commit();
		} catch (Exception ex) {
			logger.severe("   $ Error storing an object: "
					+ ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
	}

	/**
	 * Método que permite recuperar las ValoracionesDTO realizadas de
	 * todas las PelículasDTO.
	 * @return Listado de ValoracionesDTO realizadas.
	 */
	@Override
	public ArrayList<ValoracionDTO> getValoraciones() {
		ArrayList<ValoracionDTO> valoraciones = new ArrayList<>();
		PersistenceManager pm = null;
		Transaction tx = null;
		try {
			pm = pmf.getPersistenceManager();
			tx = pm.currentTransaction();
			tx.begin();
			Extent<ValoracionDTO> extent = pm.getExtent(
					ValoracionDTO.class, true);

			for (ValoracionDTO valoracion : extent) {
				valoraciones.add(valoracion);
			}
		} catch (Exception ex) {
			logger.severe(
					" $ Error retrieving valoraciones using "
							+ "an 'Extent': "
							+ ex.getMessage());
		} finally {
			if (pm != null && !pm.isClosed()) {
				pm.close();
			}
		}
		return valoraciones;
	}

	/**
	 * Método que permite recuperar los ComentariosDTO que se han hecho
	 * de cada PelículaDTO.
	 * @return Listado de ComentariosDTO realizados.
	 */
	@Override
	public ArrayList<ComentarioDTO> getComentarios() {
		ArrayList<ComentarioDTO> comentarios = new ArrayList<>();
		PersistenceManager pm = null;
		Transaction tx = null;
		try {
			pm = pmf.getPersistenceManager();
			tx = pm.currentTransaction();
			tx.begin();
			Extent<ComentarioDTO> extent = pm.getExtent(
					ComentarioDTO.class, true);

			for (ComentarioDTO comentario : extent) {
				comentarios.add(comentario);
			}
		} catch (Exception ex) {
			logger.severe(" $ Error retrieving comentarios using an"
					+ " 'Extent': " + ex.getMessage());
		} finally {
			if (pm != null && !pm.isClosed()) {
				pm.close();
			}
		}
		return comentarios;
	}
}
