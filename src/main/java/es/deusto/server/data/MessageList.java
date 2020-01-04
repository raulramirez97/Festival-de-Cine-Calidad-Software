package es.deusto.server.data;

import java.util.ArrayList;
import java.util.List;

/**
 * Este bloque de código recoge una de las estructuras de datos intermedias
 * que se utilizan para hacer Mocking de los mensajes.
 * @author Grupo RMBJ
 * @version 3.0
 * @since 1.0
 */
public class MessageList {

    private List<Message> messages = new ArrayList<Message>();

    public MessageList() {}

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
