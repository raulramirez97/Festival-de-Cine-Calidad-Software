package es.deusto.server.data;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;
import java.io.Serializable;

/**
 * Este bloque de código recoge la estructura de datos con la que se
 * representan los Actores en el sistema.
 * @author Grupo RMBJ
 * @version 3.0
 * @since 1.0
 */
@PersistenceCapable(detachable = "true")
public class ActorDTO implements Serializable {

	@PrimaryKey
	private String identificador;
	
	private String nombre;
	private String apellido;
	private int edad;

	public ActorDTO(String identificador, String nombre,
					 String apellido, int edad) {
		super();
		this.identificador = identificador;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
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

	/**
	 * Método toString generado para obtener la representación a modo de
	 * informe por pantalla. Sin embargo, este método debería dejar de
	 * usarse cuando el informe se genere con una ventana nueva.
	 * @return Informe de un actor en formato texto mediante terminal.
	 */
	public String toString() {
		return "Actor: Identificador --> " + this.getIdentificador()
				+ ", Nombre -->  " + this.getNombre()
				+ ", Apellido --> " + this.getApellido()
				+ ", Edad --> " + this.getEdad() + "";
		}
}
