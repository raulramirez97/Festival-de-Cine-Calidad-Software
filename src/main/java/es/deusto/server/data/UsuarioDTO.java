package es.deusto.server.data;

import java.io.Serializable;
import java.util.List;

import es.deusto.server.data.Message;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;
import javax.jdo.annotations.Join;
import javax.jdo.annotations.Persistent;

import java.util.ArrayList;

@PersistenceCapable(detachable = "true")
public class UsuarioDTO implements Serializable {
	/**
	 * User implements Serializable to be transferred to the RMI client
	 */
	private static final long serialVersionUID = 1L;
	@PrimaryKey
	String login = null;
	String password = null;

	@Persistent(defaultFetchGroup = "true", mappedBy = "usuariodto", dependentElement = "true")
	@Join
	List<Message> messages = new ArrayList<Message>();
	
	public UsuarioDTO() {
		
	}

	public UsuarioDTO(String login, String password) {
		this.login = login;
		this.password = password;
	}

	public void addMessage(Message message) {
		messages.add(message);
	}

	public void removeMessage(Message message) {
		messages.remove(message);
	}

	public String getLogin() {
		return this.login;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Message> getMessages() {
		return this.messages;
	}

	public String toString() {
		if (messages.isEmpty()) {
			return "User: login --> " + this.login + ", password -->  " + this.password;

		} else {
			StringBuffer messagesStr = new StringBuffer();
			for (Message message : this.messages) {
				messagesStr.append(message.toString() + " - ");
			}
			return "User: login --> " + this.login + ", password -->  " + this.password + ", messages --> ["
					+ messagesStr + "]";

		}
	}
}
