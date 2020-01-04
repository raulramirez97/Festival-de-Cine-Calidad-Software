package es.deusto.server.data;

import java.util.ArrayList;
import java.util.List;

/**
 * Este bloque de código recoge la estructura de datos con la que se agrupan
 * las PeliculasDTO del sistema, para posibilitar su transferencia mediante
 * la API RESTful.
 * @author Grupo RMBJ
 * @version 3.0
 * @since 1.0
 */
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
