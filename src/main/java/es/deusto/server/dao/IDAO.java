package es.deusto.server.dao;

import es.deusto.server.data.PeliculaDTO;
import es.deusto.server.data.UsuarioDTO;
import es.deusto.server.data.ValoracionDTO;
import es.deusto.server.data.ActorDTO;

import java.util.ArrayList;

public interface IDAO {
	void storeUsuario(UsuarioDTO u);

	UsuarioDTO retrieveUsuario(String login);

	void updateUsuario(UsuarioDTO u);

	void storeActor(ActorDTO a);

	ActorDTO retrieveActor(String id);

	void updateActor(ActorDTO a);

	ArrayList<ActorDTO> getActors ();

	void storePelicula(PeliculaDTO p);

	PeliculaDTO retrievePelicula(String id);

	void updatePelicula(PeliculaDTO p);

	ArrayList<PeliculaDTO> getPeliculas ();

	void storeValoracion (ValoracionDTO v);
}
