package es.deusto.server.dto;

//import es.deusto.ingenieria.sd.eb.server.data.Reserva;

import java.io.Serializable;
import java.util.ArrayList;

public class PersonaDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String Pasaporte;
	private String Nombre;
	private String Apellido1;
	private String Apellido2;

	public PersonaDTO(String pasaporte, String nombre, String apellido1, String apellido2)
	{
		Pasaporte=pasaporte;
		Nombre=nombre;
		Apellido1=apellido1;
		Apellido2=apellido2;
	}
	
	public String getPasaporte() {
		return Pasaporte;
	}
	public void setPasaporte(String pasaporte) {
		Pasaporte = pasaporte;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getApellido1() {
		return Apellido1;
	}
	public void setApellido1(String apellido1) {
		Apellido1 = apellido1;
	}
	public String getApellido2() {
		return Apellido2;
	}
	public void setApellido2(String apellido2) {
		Apellido2 = apellido2;
	}


}
