package es.deusto.server.data;

import java.util.ArrayList;
import java.util.List;

/**
 * Este bloque de código recoge la estructura de datos con la que se agrupan los ComentariosDTO del sistema, para
 * posibilitar su transferencia mediante la API RESTful.
 * @author Grupo RMBJ
 * @version 3.0
 * @since 1.0
 */
public class ComentarioList {

    private List<ComentarioDTO> comentarios = new ArrayList<ComentarioDTO>();

    public ComentarioList() {}

    public List<ComentarioDTO> getComentariosDTO() {
        return this.comentarios;
    }

    public void setComentariosDTO(List<ComentarioDTO> comentarios) {
        this.comentarios.clear();
        this.comentarios.addAll(comentarios);
    }

	public void addComentarioDTO(ComentarioDTO c) {
		this.comentarios.add(c);
	}
}