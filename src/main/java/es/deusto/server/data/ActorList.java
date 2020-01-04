package es.deusto.server.data;

import java.util.ArrayList;
import java.util.List;

/**
 * Este bloque de código recoge la estructura de datos con la que se agrupan
 * los ActoresDTO del sistema, para posibilitar su transferencia mediante
 * la API RESTful.
 * @author Grupo RMBJ
 * @version 3.0
 * @since 1.0
 */
public class ActorList {

    private List<ActorDTO> actors = new ArrayList<ActorDTO>();

    public ActorList() {}

    public List<ActorDTO> getActorsDTO() {
        return this.actors;
    }

    public void setActorsDTO(List<ActorDTO> actors) {
        this.actors.clear();
        this.actors.addAll(actors);
    }
}
