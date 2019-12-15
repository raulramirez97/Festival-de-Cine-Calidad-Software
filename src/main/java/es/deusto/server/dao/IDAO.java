package es.deusto.server.dao;

import es.deusto.server.data.*;

import java.util.ArrayList;

/**
 * Esta interfaz aporta las cabeceras de los métodos que se han de usar para acceder a la base de datos, delimitando
 * las funcionalidades de la implementación del patrón DAO.
 * @author Grupo RMBJ
 * @version 3.0
 * @since 1.0
 */
public interface IDAO {
	void storeUsuario(UsuarioDTO u);

	UsuarioDTO retrieveUsuario(String login);

	void updateUsuario(UsuarioDTO u);

	void storeActor(ActorDTO a);

	ActorDTO retrieveActor(String id);

	void updateActor(ActorDTO a);

	ArrayList<ActorDTO> getActors();

	void storePelicula(PeliculaDTO p);

	PeliculaDTO retrievePelicula(String id);

	void updatePelicula(PeliculaDTO p);

	ArrayList<PeliculaDTO> getPeliculas();

	void storeValoracion (ValoracionDTO v);

	ArrayList<ValoracionDTO> getValoraciones();

	ArrayList<ComentarioDTO> getComentarios();
}
