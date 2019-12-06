package es.deusto.server.data;

import java.util.ArrayList;
import java.util.List;

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