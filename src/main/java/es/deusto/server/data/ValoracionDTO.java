package es.deusto.server.data;

import javax.jdo.annotations.Join;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@PersistenceCapable(detachable = "true")
public class ValoracionDTO implements Serializable {
	/**
	 * User implements Serializable to be transferred to the RMI client
	 */
	private static final long serialVersionUID = 1L;
	@PrimaryKey
	String id = null; //TODO: Para empezar, se considerará que id=titulo de pelicula+<num_valoraciones>. Después se verá si cambiar esto a simplemente un id autoincrementado.
	String titulo = null;
	float valoracion = 0;

	public ValoracionDTO() {

	}

	public ValoracionDTO(String id, String titulo, float valoracion) {
		this.id = id;
		this.titulo = titulo;
		this.valoracion = valoracion;
	}
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public float getValoracion() {
		return this.valoracion;
	}

	public void setValoracion(float valoracion) {
		this.valoracion = valoracion;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
}
