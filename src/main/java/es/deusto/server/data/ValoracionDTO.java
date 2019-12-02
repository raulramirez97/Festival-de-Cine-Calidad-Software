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
	int id = 0; //TODO: Se considerará que primer ID=1.
	String titulo = null;
	float valoracion = 0;

	public ValoracionDTO() {}

	public ValoracionDTO(String titulo, float valoracion) {
		this.titulo = titulo;
		this.valoracion = valoracion;
	}

	public ValoracionDTO(int id, String titulo, float valoracion) {
		this.id = id;
		this.titulo = titulo;
		this.valoracion = valoracion;
	}
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
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
