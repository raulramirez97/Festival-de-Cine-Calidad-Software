package es.deusto.server.dao;

import es.deusto.server.data.ActorDTO;
import es.deusto.server.data.PeliculaDTO;
import es.deusto.server.data.UsuarioDTO;
import es.deusto.server.data.ValoracionDTO;
import es.deusto.server.data.ComentarioDTO;

import java.util.ArrayList;

/**
 * Esta interfaz aporta las cabeceras de los métodos que se han de usar para
 * acceder a la base de datos, delimitando las funcionalidades de la
 * implementación del patrón DAO.
 * @author Grupo RMBJ
 * @version 3.0
 * @since 1.0
 */
public interface IDAO {

	/**
	 * Método que permite insertar un UsuarioDTO en la base de datos.
	 * @param u UsuarioDTO a insertar.
	 */
	void storeUsuario(UsuarioDTO u);

	/**
	 * Método que permite buscar un UsuarioDTO por su nombre de usuario.
	 * @param login Nombre de usuario por el que realizar la búsqueda.
	 * @return UsuarioDTO encontrado bajo ese nombre de usuario.
	 */
	UsuarioDTO retrieveUsuario(String login);

	/**
	 * Método que permite hacer una actualización de un UsuarioDTO con sus
	 * nuevos datos.
	 * @param u UsuarioDTO con los datos modificados para modificar en la
	 *            base de datos.
	 */
	void updateUsuario(UsuarioDTO u);

	/**
	 * Método que permite insertar un ActorDTO en la base de datos.
	 * @param a ActorDTO a insertar.
	 */
	void storeActor(ActorDTO a);

	/**
	 * Método que permite buscar un ActorDTO por su identificativo.
	 * @param id Código identificativo por el que realizar la búsqueda.
	 * @return ActorDTO encontrado bajo ese código identificativo.
	 */
	ActorDTO retrieveActor(String id);

	/**
	 * Método que permite hacer una actualización de un ActorDTO con sus
	 * nuevos datos.
	 * @param a ActorDTO con los datos modificados para modificar en la
	 *             base de datos.
	 */
	void updateActor(ActorDTO a);

	/**
	 * Método que permite recuperar un listado de ActoresDTO de la base
	 * de datos.
	 * @return Listado de ActoresDTO existentes en la base de datos.
	 */
	ArrayList<ActorDTO> getActors();

	/**
	 * Método que permite insertar una PeliculaDTO en la base de datos.
	 * @param p PeliculaDTO a insertar.
	 */
	void storePelicula(PeliculaDTO p);

	/**
	 * Método que permite buscar una PeliculaDTO por su título.
	 * @param titulo Título de la película por el que realizar la búsqueda.
	 * @return PeliculaDTO encontrada bajo ese título.
	 */
	PeliculaDTO retrievePelicula(String titulo);

	/**
	 * Método que permite hacer una actualización de una PeliculaDTO con sus
	 * nuevos datos.
	 * @param p PeliculaDTO con los datos modificados para modificar en
	 *            la base de datos.
	 */
	void updatePelicula(PeliculaDTO p);

	/**
	 * Método que permite recuperar un listado de PeliculasDTO de la
	 * base de datos.
	 * @return Listado de PeliculasDTO existentes en la base de datos.
	 */
	ArrayList<PeliculaDTO> getPeliculas();

	/**
	 * Método que permite almacenar la ValoracionDTO hecha de una
	 * PeliculaDTO.
	 * @param v ValoracionDTO a almacenar en la base de datos.
	 */
	void storeValoracion(ValoracionDTO v);

	/**
	 * Método que permite recuperar las ValoracionesDTO realizadas de
	 * todas las PelículasDTO.
	 * @return Listado de ValoracionesDTO realizadas.
	 */
	ArrayList<ValoracionDTO> getValoraciones();

	/**
	 * Método que permite recuperar los ComentariosDTO que se han hecho
	 * de cada PelículaDTO.
	 * @return Listado de ComentariosDTO realizados.
	 */
	ArrayList<ComentarioDTO> getComentarios();
}
