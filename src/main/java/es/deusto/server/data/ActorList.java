package es.deusto.server.data;

import java.util.ArrayList;
import java.util.List;

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

	public void addActorDTO(ActorDTO a) {
		this.actors.add(a);
	}
}