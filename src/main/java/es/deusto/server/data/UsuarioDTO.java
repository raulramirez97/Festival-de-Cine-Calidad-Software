package es.deusto.server.data;

import javax.jdo.annotations.Join;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Este bloque de código recoge la estructura de datos con la que se
 * representan los Usuarios en el sistema.
 * @author Grupo RMBJ
 * @version 3.0
 * @since 1.0
 */
@PersistenceCapable(detachable = "true")
public class UsuarioDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	@PrimaryKey
	private String login = null;
	private String password = null;

	@Persistent(defaultFetchGroup = "true", mappedBy = "usuariodto",
			dependentElement = "true")
	@Join
	List<Message> messages = new ArrayList<Message>();

	public UsuarioDTO() { }

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

	/**
	 * Método toString generado para obtener la representación a modo de
	 * informe por pantalla.
	 * @return Información de un usuario.
	 */
	public String toString() {
		if (messages.isEmpty()) {
			return "User: login --> " + this.login + ", password "
					+ "-->  " + this.password;
		} else {
			StringBuffer messagesStr = new StringBuffer();
			for (Message message : this.messages) {
				messagesStr.append(message.toString() + " - ");
			}
			return "User: login --> " + this.login + ", password"
					+ " -->  " + this.password
					+ ", messages "
					+ "--> [" + messagesStr + "]";
		}
	}
}
