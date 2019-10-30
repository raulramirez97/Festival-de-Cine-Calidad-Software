package es.deusto.server.dto;

import java.io.Serializable;

public class UsuarioDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String Email;
	private String Contrasena;
	
	public UsuarioDTO (String email, String contrasena) {
		super();
		Email = email;
		Contrasena = contrasena;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getContrasena() {
		return Contrasena;
	}
	public void setContrasena(String contrasena) {
		Contrasena = contrasena;
	}
}