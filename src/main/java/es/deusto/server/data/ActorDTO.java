package es.deusto.server.data;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;
import java.io.Serializable;

@PersistenceCapable(detachable = "true")
public class ActorDTO implements Serializable{

	@PrimaryKey
	private String identificador;
	
	private String nombre;
	private String apellido;
	private int edad;

	public ActorDTO (String identificador2, String nombre2, String apellido2, int edad2) {
		super();
		identificador = identificador2;
		nombre = nombre2;
		apellido = apellido2;
		edad = edad2;
	}
	
	public String getIdentificador() {
		return identificador;
	}
	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String toString() {
		return "Actor: Identificador --> " + this.getIdentificador() + ", Nombre -->  " + this.getNombre() +
				", Apellido --> " + this.getApellido() + ", Edad --> " + this.getEdad() + "";
		}
}

