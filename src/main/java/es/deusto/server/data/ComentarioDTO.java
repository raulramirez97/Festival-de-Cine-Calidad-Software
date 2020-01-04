package es.deusto.server.data;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;
import java.io.Serializable;
import java.util.Date;

/**
 * Este bloque de código recoge la estructura de datos con la que se
 * representan los Comentarios en el sistema.
 * @author Grupo RMBJ
 * @version 3.0
 * @since 1.0
 */
@PersistenceCapable(detachable = "true")
public class ComentarioDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@PrimaryKey
	private int id;

	private PeliculaDTO pelicula;
	private String usuario;
	private String contenido;
	private long timestamp;

	public ComentarioDTO(PeliculaDTO peli, String usuario, String contenido)
	{
		this.id = 1;
		this.pelicula = peli;
		this.usuario = usuario;
		this.contenido = contenido;
		this.timestamp = System.currentTimeMillis();
	}

	public ComentarioDTO(int id, PeliculaDTO peli, String usuario,
						 String contenido) {
		this.id = id;
		this.pelicula = peli;
		this.usuario = usuario;
		this.contenido = contenido;
		this.timestamp = System.currentTimeMillis();
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public PeliculaDTO getPelicula() {
		return pelicula;
	}
	public void setPelicula(PeliculaDTO pelicula) {
		this.pelicula = pelicula;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getContenido() {
		return contenido;
	}
	public void setContenido(String contenido) {
		this.contenido = contenido;
	}
	public long getTimestamp() {
		return timestamp;
	}

	public String toString() {
		Date fecha = new Date(this.getTimestamp());
		return "ID Comentario: "+this.getId()+", Usuario: "
				+ this.getUsuario()
				+ ", Fecha: "+ fecha
				+ ", Contenido: "+ contenido;
	}
}
