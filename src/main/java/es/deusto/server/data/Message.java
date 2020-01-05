package es.deusto.server.data;

import javax.jdo.annotations.PersistenceCapable;
import java.io.Serializable;
import java.util.Date;

/**
 * Este bloque de código recoge una de las estructuras de datos intermedias
 * que se utilizan para hacer Mocking de los mensajes.
 * @author Grupo RMBJ
 * @version 3.0
 * @since 1.0
 */
@PersistenceCapable
public class Message implements Serializable {

	private static final long serialVersionUID = 1L;
	private UsuarioDTO usuariodto = null;
	private String text = null;
	private long timestamp;

	public Message(String text) {

		this.text = text;
		this.timestamp = System.currentTimeMillis();
	}

	public UsuarioDTO getUsuarioDTO() {
		return usuariodto;
	}

	public void setUsuarioDTO(UsuarioDTO usuarioDTO) {
		this.usuariodto = usuarioDTO;
	}

	public String getText() {
		return text;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public String toString() {
		return "Message: message --> "
				+ this.text
				+ ", timestamp -->  "
				+ new Date(this.timestamp);
	}
}
