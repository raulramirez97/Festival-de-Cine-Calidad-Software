package es.deusto.server.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.jdo.annotations.Join;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(detachable = "true")
public class PeliculaDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@PrimaryKey
	private String titulo;

	private String sinopsis;
	private String genero;
	private int duracion;
	private int anyo;
	private String director;
	private String enlaceTrailer;
	private float valoracionMedia;
	private int numvaloraciones;
	//TODO: CAMBIAR A PREMIODTO.
	private String premios;

	@Persistent(defaultFetchGroup = "true", mappedBy = "pelicula", dependentElement = "true")
	@Join
	private List<ComentarioDTO> comentarios = new ArrayList<ComentarioDTO>();
//	@Persistent(defaultFetchGroup = "true", mappedBy = "peliculas", dependentElement = "true")
//	@Join
//	private List<ActorDTO> elenco = new ArrayList<ActorDTO>();
	private String elenco = "";

	
//	public PeliculaDTO(String titulo2, String sinopsis2, String genero2, int duracion2, int anyo,
//			String directores2, String enlaceTrailer2, int valoracionMedia2, String premios2,
//			List<ComentarioDTO> comentarios2, List<ActorDTO> actores2) {
//
//		this.titulo= titulo2;
//		this.sinopsis = sinopsis2;
//		this.genero = genero2;
//		this.duracion = duracion2;
//		//TODO: ANADIR POSTERIORMENTE FECHA COMO UN DATE. PRIMERO SE OBVIARA EL ATRIBUTO, PORQUE ES UN TIPO DATE. O NO - CONSIDERAR ANO Y A TOMAR POR SACO.
//		this.anyo = anyo;
//		this.director = directores2;
//		this.enlaceTrailer = enlaceTrailer2;
//		this.valoracionMedia = valoracionMedia2;
//		this.premios = premios2;
//		//TODO: PUEDE SER UTIL PENSAR EL COMENTARIO COMO UNA NUEVA CLASE, QUE TENGA SU FECHA, AUTOR Y CONTENIDO.
//		this.comentarios = comentarios2;
//		this.elenco = actores2;
//	}
//
//	public String getTitulo() {
//		return titulo;
//	}
//	public void setTitulo(String titulo) {
//		this.titulo = titulo;
//	}
//	public String getSinopsis() {
//		return sinopsis;
//	}
//	public void setSinopsis(String sinopsis) {
//		this.sinopsis = sinopsis;
//	}
//	public String getGenero() {
//		return genero;
//	}
//	public void setGenero(String genero) {
//		this.genero = genero;
//	}
//	public int getDuracion() {
//		return duracion;
//	}
//	public void setDuracion(int duracion) {
//		this.duracion = duracion;
//	}
//	public int getAnyo() {
//		return anyo;
//	}
//	public void setAnyo(int anyo) {
//		this.anyo = anyo;
//	}
//	public String getDirector() {
//		return director;
//	}
//	public void setDirector(String director) {
//		this.director = director;
//	}
//	public String getEnlaceTrailer() {
//		return enlaceTrailer;
//	}
//	public void setEnlaceTrailer(String enlaceTrailer) {
//		this.enlaceTrailer = enlaceTrailer;
//	}
//	public int getValoracionMedia() {
//		return valoracionMedia;
//	}
//	public void setValoracionMedia(int valoracionMedia) {
//		this.valoracionMedia = valoracionMedia;
//	}
//	public String getPremios() {
//		return premios;
//	}
//	public void setPremios(String premios) {
//		this.premios = premios;
//	}
//	public List<ComentarioDTO> getComentarios() {
//		return comentarios;
//	}
//	public void setComentarios(List<ComentarioDTO> comentarios) {
//		this.comentarios = comentarios;
//	}
//	public List<ActorDTO> getActores() {
//		return elenco;
//	}
//	public void setActores(List<ActorDTO> actores) {
//		this.elenco = actores;
//	}

	public PeliculaDTO(String titulo2, String sinopsis2, String genero2, int duracion2, int anyo,
					   String directores2, String enlaceTrailer2, float valoracionMedia2, String premios2,
					   List<ComentarioDTO> comentarios2, String actores2) {

		this.titulo= titulo2;
		this.sinopsis = sinopsis2;
		this.genero = genero2;
		this.duracion = duracion2;
		//TODO: ANADIR POSTERIORMENTE FECHA COMO UN DATE. PRIMERO SE OBVIARA EL ATRIBUTO, PORQUE ES UN TIPO DATE. O NO - CONSIDERAR ANO Y A TOMAR POR SACO.
		this.anyo = anyo;
		this.director = directores2;
		this.enlaceTrailer = enlaceTrailer2;
		this.valoracionMedia = valoracionMedia2;
		this.numvaloraciones = 0;
		this.premios = premios2;
		//TODO: PUEDE SER UTIL PENSAR EL COMENTARIO COMO UNA NUEVA CLASE, QUE TENGA SU FECHA, AUTOR Y CONTENIDO.
		this.comentarios = comentarios2;
		this.elenco = actores2;
	}

	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getSinopsis() {
		return sinopsis;
	}
	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public int getDuracion() {
		return duracion;
	}
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
	public int getAnyo() {
		return anyo;
	}
	public void setAnyo(int anyo) {
		this.anyo = anyo;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getEnlaceTrailer() {
		return enlaceTrailer;
	}
	public void setEnlaceTrailer(String enlaceTrailer) {
		this.enlaceTrailer = enlaceTrailer;
	}
	public float getValoracionMedia() {
		return valoracionMedia;
	}
	public void setValoracionMedia(float valoracionMedia) {
		this.valoracionMedia = valoracionMedia;
	}
	public int getNumvaloraciones() {
		return numvaloraciones;
	}
	public void setNumvaloraciones(int valoraciones) {
		this.numvaloraciones = valoraciones;
	}
	public String getPremios() {
		return premios;
	}
	public void setPremios(String premios) {
		this.premios = premios;
	}
	public List<ComentarioDTO> getComentarios() {
		return comentarios;
	}
	public void setComentarios(List<ComentarioDTO> comentarios) {
		this.comentarios = comentarios;
	}
	public String getActores() {
		return elenco;
	}
	public void setActores(String actores) {
		this.elenco = actores;
	}

	public String toString() {

		if (this.getComentarios() == null) {
			if (this.getActores() == null) {
			return "___________________________________________\n" +
					"Pelicula: Titulo --> " + this.getTitulo() + ", " +
					"Sinopsis -->  " + this.getSinopsis() + ", Genero --> " + this.getGenero() +
					", Duracion --> " + this.getDuracion() + ", Director --> " + this.getDirector() +
					", Enlace a trailer --> " + this.getEnlaceTrailer() + ", Valoracion media --> " + this.getValoracionMedia() +
					", Premios --> " + this.getPremios() + ", Comentarios --> No hay registrados, Actores --> No hay registrados" +
					"\n__________________________________________\n";

				}
			else {
				//TODO: REVISAR ESTO
//				StringBuffer actoresStr = new StringBuffer();
//				for (ActorDTO actor : this.getActores()) {
//					actoresStr.append(actor.toString() + " - ");
//				}

					return "___________________________________________\n" +
							"Pelicula: Titulo --> " + this.getTitulo() + ", " +
							"Sinopsis -->  " + this.getSinopsis() + ", Genero --> " + this.getGenero() +
							", Duracion --> " + this.getDuracion() + ", Director --> " + this.getDirector() +
							", Enlace a trailer --> " + this.getEnlaceTrailer() + ", Valoracion media --> " + this.getValoracionMedia() +
							", Premios --> " + this.getPremios() + ", Comentarios --> No hay registrados" +
							", Actores --> [" + this.getActores() + "]"+
							"\n__________________________________________\n";
				}
			}
		else {
			//TODO: REVISAR ESTO
			StringBuffer comentariosStr = new StringBuffer();
			for (ComentarioDTO comentario : this.getComentarios()) {
				comentariosStr.append(comentario.toString() + " - ");
			}

			if (this.getActores() == null) {
				return "___________________________________________\n" +
						"Pelicula: Titulo --> " + this.getTitulo() + ", " +
						"Sinopsis -->  " + this.getSinopsis() + ", Genero --> " + this.getGenero() +
						", Duracion --> " + this.getDuracion() + ", Director --> " + this.getDirector() +
						", Enlace a trailer --> " + this.getEnlaceTrailer() + ", Valoracion media --> " + this.getValoracionMedia() +
						", Premios --> " + this.getPremios() + ", Comentarios --> [" + comentariosStr + "]" +
						", Actores --> No hay registrados"+
						"\n__________________________________________\n";
			}
			else {
				//TODO: REVISAR ESTO
//				StringBuffer actoresStr = new StringBuffer();
//				for (ActorDTO actor : this.getActores()) {
//					actoresStr.append(actor.toString() + " - ");
//				}

					return "___________________________________________\n" +
							"Pelicula: Titulo --> " + this.getTitulo() + ", " +
							"Sinopsis -->  " + this.getSinopsis() + ", Genero --> " + this.getGenero() +
							", Duracion --> " + this.getDuracion() + ", Director --> " + this.getDirector() +
							", Enlace a trailer --> " + this.getEnlaceTrailer() + ", Valoracion media --> " + this.getValoracionMedia() +
							", Premios --> " + this.getPremios() + ", Comentarios --> [" + comentariosStr + "]" +
							", Actores --> [" + this.getActores() + "]"+
							"\n__________________________________________\n";
				}
			}

	}
}
