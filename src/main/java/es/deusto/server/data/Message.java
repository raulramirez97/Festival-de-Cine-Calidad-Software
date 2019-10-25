package es.deusto.server.data;

import javax.jdo.annotations.PersistenceCapable;

import java.io.Serializable;
import java.util.Date;

//TODO: Clase a borrar; no hace falta para el Festival de Cine.
//TODO: Aún no se ha borrado para que no peten las dependencias con clases base que se pueden tomar como
//TODO: inspiración para modificar.


@PersistenceCapable
public class Message implements Serializable {
	/**
	 * Messages will be transferred to the RMI client as part of a User
	 */
	private static final long serialVersionUID = 1L;
	User user = null;
	String text = null;
	long timestamp;

	public Message(String text) {

		this.text = text;
		this.timestamp = System.currentTimeMillis();
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getText() {
		return text;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public String toString() {
		return "Message: message --> " + this.text + ", timestamp -->  " + new Date(this.timestamp);
	}
}