package es.deusto.server.dao;

import es.deusto.server.data.Persona;
import es.deusto.server.data.Usuario;

import java.util.ArrayList;

public interface IDAO 
{
	public ArrayList<Persona> getPersonas();
	public ArrayList<Usuario> getUsuarios();
	public boolean guardarUsuario(Usuario usuario);
	public boolean guardarPersona(Persona persona);
	/*public boolean guardarReserva(Reserva reserva);
	public int getNumReservas();*/
}
