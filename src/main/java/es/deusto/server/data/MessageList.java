package es.deusto.server.data;

import java.util.List;
import java.util.ArrayList;

//TODO: Clase a borrar; no hace falta para el Festival de Cine.
//TODO: Aún no se ha borrado para que no peten las dependencias con clases base que se pueden tomar como
//TODO: inspiración para modificar.


public class MessageList {

    private List<Message> messages = new ArrayList<Message>();

    public MessageList() {

    }

    public List<Message> getMessages() {
        return this.messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages.clear();
        this.messages.addAll(messages);
    }

	public void addMessage(Message m) {
		this.messages.add(m);		
	}
}