package es.deusto.server.data;

import javax.jdo.annotations.Join;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import java.util.ArrayList;

@PersistenceCapable (detachable="true")
public class Usuario //extends Persona
{
	@PrimaryKey
	private String email;
	private String contrasena;

	/*
	@Persistent(mappedBy="email", dependentElement="true")
	@Join
	private ArrayList<Reserva> reservas = new ArrayList<Reserva>();

	 */
	
	public Usuario (String email) 
	{
		this.email = email;
		contrasena = "PP";
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	/*public ArrayList<Reserva> getReservas() {
		return reservas;
	}
	public void setReserva(Reserva reserva) {
		reservas.add(reserva);
	}*/
}
