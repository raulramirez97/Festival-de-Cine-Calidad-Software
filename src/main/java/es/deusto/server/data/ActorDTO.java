package es.deusto.server.data;

import javax.jdo.annotations.Join;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@PersistenceCapable(detachable = "true")
public class ActorDTO implements Serializable{

	@PrimaryKey
	private String identificador;
	
	private String nombre;
	private String apellido;
	private int edad;

	//@Join
	//private List<PeliculaDTO> peliculas = new ArrayList<PeliculaDTO>();

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
//	public List<PeliculaDTO> getPeliculas() {
//		return peliculas;
//	}
//	public PeliculaDTO getPelicula(int i) {
//		return this.peliculas.get(i);
//	}
//	public void setPeliculas(List<PeliculaDTO> peliculas) {
//		this.peliculas = peliculas;
//	}
//	public void setPelicula(PeliculaDTO pelicula) {
//		System.out.println("Pelicula a meter en el actor: " + pelicula.getTitulo() );
//		//TODO: ERROR MUY GUAPO: INFINITE RECURSION.
////		if (this.peliculas == null) {
////			this.peliculas = new ArrayList<PeliculaDTO>();
////		}
//		this.peliculas.add(pelicula);
//	}

//TODO: ANADIR METODO ADDPELICULA, PARA QUE EL ACTOR SE LE ANADA UNA PELICULA CUANDO ESTA SE REGISTRA AL SISTEMA.
	//TODO: PRIMERO SE INICIALIZAN ACTORES. DESPUES PELICULAS.

	public String toString() {
		return "Actor: Identificador --> " + this.getIdentificador() + ", Nombre -->  " + this.getNombre() +
				", Apellido --> " + this.getApellido() + ", Edad --> " + this.getEdad() + "";
		}
}

