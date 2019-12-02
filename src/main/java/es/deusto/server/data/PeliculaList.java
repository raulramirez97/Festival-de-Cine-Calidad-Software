package es.deusto.server.data;

import java.util.ArrayList;
import java.util.List;

public class PeliculaList {

    private List<PeliculaDTO> peliculas = new ArrayList<PeliculaDTO>();

    public PeliculaList() {}

    public List<PeliculaDTO> getPeliculasDTO() {
        return this.peliculas;
    }

    public void setPeliculasDTO(List<PeliculaDTO> peliculas) {
        this.peliculas.clear();
        this.peliculas.addAll(peliculas);
    }

	public void addPeliculaDTO(PeliculaDTO p) {
		this.peliculas.add(p);
	}
}