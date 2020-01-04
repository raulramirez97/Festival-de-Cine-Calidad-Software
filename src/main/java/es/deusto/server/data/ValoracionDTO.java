package es.deusto.server.data;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;
import java.io.Serializable;

/**
 * Este bloque de código recoge la estructura de datos con la que se representan las Valoraciones en el sistema.
 * @author Grupo RMBJ
 * @version 3.0
 * @since 1.0
 */
@PersistenceCapable(detachable = "true")
public class ValoracionDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * El id inicial es 1, y se va autoincrementando en la ejecución del programa.
	 */
	@PrimaryKey
	int id = 1;
	String titulo = null;
	double valoracion = 0;

	public ValoracionDTO() {}

	public ValoracionDTO(String titulo, double valoracion) {
		this.titulo = titulo;
		this.valoracion = valoracion;
	}

	public ValoracionDTO(int id, String titulo, double valoracion) {
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

	public double getValoracion() {
		return this.valoracion;
	}

	public void setValoracion(double valoracion) {
		this.valoracion = valoracion;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
}
