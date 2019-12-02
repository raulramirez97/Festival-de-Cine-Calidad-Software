package es.deusto.server.data;

import javax.jdo.annotations.Join;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@PersistenceCapable(detachable = "true")
public class ComentarioDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@PrimaryKey
	private int id;

	//TODO: CONSIDERAR SI ANADIRLO ASI (RELACION 1:N - 1 PELICULA TIENE MUCHOS COMENTARIOS, 1 COMENTARIO ESTA EN 1 PELICULA)
	private PeliculaDTO pelicula;

	//TODO: CONSIDERAR SI ANADIRLO ASI (RELACION 1:N - 1 USUARIO HACE MUCHOS COMENTARIOS; 1 COMENTARIO ES HECHO POR 1 USUARIO)
	//TODO: SI SE TRATA DE USUARIOS NO REGISTRADOS, SE GENERARA UN NUEVO "USUARIODTO" CUYO NOMBRE SEA "ANONIMO".
	//TODO: SI NO, SE PUEDE PONER UN STRING (NOMBRE DE USUARIO REGISTRADO // NOMBRE DE PERSONA AL COMENTAR) Y A TOMAR VIENTOS.
	//TODO: ESTA DISQUISICION ES UN "EXTRA".
	//private UsuarioDTO usuario;
	private String usuario;
	private String contenido;
	//TODO: MIRAR COMO SE HA HECHO LA GESTION DE TIMESTAMPS EN MESSAGE.JAVA
	private long timestamp;

	public ComentarioDTO(PeliculaDTO peli, String usuario, String contenido) {
		this.id = 1; //TODO: CAMBIAR A AUTOINDEXADO. PARA ELLO, HAY QUE RECOGER DE BD LOS COMENTARIOS, SUMAR+1 AL ID.
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
	//	public String toString() {
//
//		if (this.getComentarios() == null) {
//			if (this.getActores() == null) {
//			return "Pelicula: Titulo --> " + this.getTitulo() + ", " +
//					"Sinopsis -->  " + this.getSinopsis() + ", Genero --> " + this.getGenero() +
//					", Duracion --> " + this.getDuracion() + ", Director --> " + this.getDirector() +
//					", Enlace a trailer --> " + this.getEnlaceTrailer() + ", Valoracion media --> " + this.getValoracionMedia() +
//					", Premios --> " + this.getPremios() + ", Comentarios --> No hay registrados, Actores --> No hay registrados";
//
//				}
//			else {
//				StringBuffer actoresStr = new StringBuffer();
//				for (String actor : this.getActores()) {
//					actoresStr.append(actor.toString() + " - ");
//				}
//
//					return "Pelicula: Titulo --> " + this.getTitulo() + ", " +
//							"Sinopsis -->  " + this.getSinopsis() + ", Genero --> " + this.getGenero() +
//							", Duracion --> " + this.getDuracion() + ", Director --> " + this.getDirector() +
//							", Enlace a trailer --> " + this.getEnlaceTrailer() + ", Valoracion media --> " + this.getValoracionMedia() +
//							", Premios --> " + this.getPremios() + ", Comentarios --> No hay registrados" +
//							", Actores --> [" + actoresStr + "]";
//				}
//			}
//		else {
//			StringBuffer comentariosStr = new StringBuffer();
//			for (String comentario : this.getComentarios()) {
//				comentariosStr.append(comentario.toString() + " - ");
//			}
//
//			if (this.getActores() == null) {
//				return "Pelicula: Titulo --> " + this.getTitulo() + ", " +
//						"Sinopsis -->  " + this.getSinopsis() + ", Genero --> " + this.getGenero() +
//						", Duracion --> " + this.getDuracion() + ", Director --> " + this.getDirector() +
//						", Enlace a trailer --> " + this.getEnlaceTrailer() + ", Valoracion media --> " + this.getValoracionMedia() +
//						", Premios --> " + this.getPremios() + ", Comentarios --> [" + comentariosStr + "]" +
//						", Actores --> No hay registrados";
//			}
//			else {
//				StringBuffer actoresStr = new StringBuffer();
//				for (String actor : this.getActores()) {
//					actoresStr.append(actor.toString() + " - ");
//				}
//
//					return "Pelicula: Titulo --> " + this.getTitulo() + ", " +
//							"Sinopsis -->  " + this.getSinopsis() + ", Genero --> " + this.getGenero() +
//							", Duracion --> " + this.getDuracion() + ", Director --> " + this.getDirector() +
//							", Enlace a trailer --> " + this.getEnlaceTrailer() + ", Valoracion media --> " + this.getValoracionMedia() +
//							", Premios --> " + this.getPremios() + ", Comentarios --> [" + comentariosStr + "]" +
//							", Actores --> [" + actoresStr + "]";
//				}
//			}
//
//	}
}
