package es.deusto.server.dao;

import javax.jdo.*;

import es.deusto.server.data.ActorDTO;
import es.deusto.server.data.PeliculaDTO;
import es.deusto.server.data.UsuarioDTO;

import java.util.ArrayList;

public class DBManager implements IDAO {

	private PersistenceManagerFactory pmf;

	public DBManager() {
		pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
	}

	/*
	USUARIO METHODS BELOW:
	 */

	@Override
	public void storeUsuario(UsuarioDTO u) {

		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			System.out.println("   * Storing a user: " + u.getLogin());
			pm.makePersistent(u);
			tx.commit();
		} catch (Exception ex) {
			System.out.println("   $ Error storing an object: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}
	}

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
		} catch (javax.jdo.JDOObjectNotFoundException jonfe) {
			System.out.println("User does not exist: " + jonfe.getMessage());
		}

		finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}

		return usuarioDTO;
	}

	@Override
	public void updateUsuario(UsuarioDTO u) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		try {
			tx.begin();
			pm.makePersistent(u);
			tx.commit();
		} catch (Exception ex) {
			System.out.println("Error updating a user: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}

	}

	/*
	ACTOR METHODS BELOW:
	 */

	@Override
	public void storeActor(ActorDTO a) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			System.out.println("   * Storing an actor: " + a.getNombre() + " " + a.getApellido());
			pm.makePersistent(a);
			tx.commit();
		} catch (Exception ex) {
			System.out.println("   $ Error storing an object: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}
	}

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
		} catch (javax.jdo.JDOObjectNotFoundException jonfe) {
			System.out.println("Actor does not exist: " + jonfe.getMessage());
		}

		finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}

		return actorDTO;
	}

	@Override
	public void updateActor(ActorDTO a) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		try {
			tx.begin();
			pm.makePersistent(a);
			tx.commit();
		} catch (Exception ex) {
			System.out.println("Error updating an actor: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}
	}

	@Override
	public ArrayList<ActorDTO> getActors() {
		ArrayList<ActorDTO> actors = new ArrayList<ActorDTO>();
		PersistenceManager pm = null;
		Transaction tx = null;
		try
		{
			pm = pmf.getPersistenceManager();
			tx = pm.currentTransaction();
			tx.begin();
			Extent<ActorDTO> extent = pm.getExtent(ActorDTO.class, true);

			for (ActorDTO actor : extent)
			{
				actors.add(actor);
			}
		}
		catch (Exception ex)
		{
			System.err.println(" $ Error retrieving actors using an 'Extent': " + ex.getMessage());
		}
		finally
		{
			if (pm != null && !pm.isClosed()) {
				pm.close();
			}
		}
		return actors;
	}


	/*
	PELICULA METHODS BELOW:
	 */

	@Override
	public void storePelicula(PeliculaDTO p) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			System.out.println("   * Storing a pelicula: " + p.getTitulo());
			pm.makePersistent(p);
			tx.commit();
		} catch (Exception ex) {
			System.out.println("   $ Error storing an object: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}
	}

	@Override
	public PeliculaDTO retrievePelicula(String titulo) {
		PeliculaDTO peliculaDTO = null;
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(3);
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			peliculaDTO = pm.getObjectById(PeliculaDTO.class, titulo);
			tx.commit();
		} catch (javax.jdo.JDOObjectNotFoundException jonfe) {
			System.out.println("Pelicula does not exist: " + jonfe.getMessage());
		}

		finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}

		return peliculaDTO;
	}

	@Override
	public void updatePelicula(PeliculaDTO p) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		try {
			tx.begin();
			pm.makePersistent(p);
			tx.commit();
		} catch (Exception ex) {
			System.out.println("Error updating a pelicula: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}
	}

	@Override
	public ArrayList<PeliculaDTO> getPeliculas() {
		ArrayList<PeliculaDTO> peliculas = new ArrayList<PeliculaDTO>();
		PersistenceManager pm = null;
		Transaction tx = null;
		try
		{
			pm = pmf.getPersistenceManager();
			tx = pm.currentTransaction();
			tx.begin();
			Extent<PeliculaDTO> extent = pm.getExtent(PeliculaDTO.class, true);

			for (PeliculaDTO pelicula : extent)
			{
				peliculas.add(pelicula);
			}
		}
		catch (Exception ex)
		{
			System.err.println(" $ Error retrieving peliculas using an 'Extent': " + ex.getMessage());
		}
		finally
		{
			if (pm != null && !pm.isClosed()) {
				pm.close();
			}
		}
		return peliculas;
	}
}
