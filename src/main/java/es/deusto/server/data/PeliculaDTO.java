package es.deusto.server.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import es.deusto.server.data.ActorDTO;

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
	//private int fecha;
	private String director;
	private String enlaceTrailer;
	private int valoracionMedia;
	private String premios;

	@Persistent(defaultFetchGroup = "true")
	@Join
	private List<String> comentarios = new ArrayList<>();

//	@Persistent(defaultFetchGroup = "true", mappedBy = "usuariodto", dependentElement = "true")
//	@Join
//	private ArrayList<ActorDTO> actores;
	//TODO: MODIFICAR ESTO A ACTORDTO CUANDO SE TENGA SEGURO. EL TEMA ES QUE ES UNA RELACION N:M, HAY QUE RECORDAR
	//TODO: COMO GESTIONA ESAS RELACIONES DATANUCLEUS.

	@Persistent(defaultFetchGroup = "true")
	@Join
	private List<String> actores = new ArrayList<>();
	
	public PeliculaDTO(String titulo2, String sinopsis2, String genero2, int duracion2,
			String directores2, String enlaceTrailer2, int valoracionMedia2, String premios2,
			List<String> comentarios2, List<String> actores2) {
		
		titulo= titulo2;
		sinopsis = sinopsis2;
		genero = genero2;
		duracion = duracion2;
		//TODO: ANADIR POSTERIORMENTE FECHA COMO UN DATE. PRIMERO SE OBVIARA EL ATRIBUTO, PORQUE ES UN TIPO DATE.
		//fecha = fecha2;
		director = directores2;
		enlaceTrailer = enlaceTrailer2;
		valoracionMedia = valoracionMedia2 ;
		premios = premios2;
		//TODO: PUEDE SER UTIL PENSAR EL COMENTARIO COMO UNA NUEVA CLASE, QUE TENGA SU FECHA, AUTOR Y CONTENIDO.
		comentarios = comentarios2 ;
		actores = actores2;
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
	public void setDuracion(Integer duracion) {
		this.duracion = duracion;
	}
//	public int getFecha() {
//		return fecha;
//	}
//	public void setFecha(Integer fecha) {
//		this.fecha = fecha;
//	}
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
	public int getValoracionMedia() {
		return valoracionMedia;
	}
	public void setValoracionMedia(Integer valoracionMedia) {
		this.valoracionMedia = valoracionMedia;
	}
	public String getPremios() {
		return premios;
	}
	public void setPremios(String premios) {
		this.premios = premios;
	}
	public List<String> getComentarios() {
		return comentarios;
	}
	public void setComentarios(List<String> comentarios) {
		this.comentarios = comentarios;
	}
	public List<String> getActores() {
		return actores;
	}
	public void setActores(List<String> actores) {
		this.actores = actores;
	}

	public String toString() {

		if (this.getComentarios() == null) {
			if (this.getActores() == null) {
			return "Pelicula: Titulo --> " + this.getTitulo() + ", " +
					"Sinopsis -->  " + this.getSinopsis() + ", Genero --> " + this.getGenero() +
					", Duracion --> " + this.getDuracion() + ", Director --> " + this.getDirector() +
					", Enlace a trailer --> " + this.getEnlaceTrailer() + ", Valoracion media --> " + this.getValoracionMedia() +
					", Premios --> " + this.getPremios() + ", Comentarios --> No hay registrados, Actores --> No hay registrados";

				}
			else {
				StringBuffer actoresStr = new StringBuffer();
				for (String actor : this.getActores()) {
					actoresStr.append(actor.toString() + " - ");
				}

					return "Pelicula: Titulo --> " + this.getTitulo() + ", " +
							"Sinopsis -->  " + this.getSinopsis() + ", Genero --> " + this.getGenero() +
							", Duracion --> " + this.getDuracion() + ", Director --> " + this.getDirector() +
							", Enlace a trailer --> " + this.getEnlaceTrailer() + ", Valoracion media --> " + this.getValoracionMedia() +
							", Premios --> " + this.getPremios() + ", Comentarios --> No hay registrados" +
							", Actores --> [" + actoresStr + "]";
				}
			}
		else {
			StringBuffer comentariosStr = new StringBuffer();
			for (String comentario : this.getComentarios()) {
				comentariosStr.append(comentario.toString() + " - ");
			}

			if (this.getActores() == null) {
				return "Pelicula: Titulo --> " + this.getTitulo() + ", " +
						"Sinopsis -->  " + this.getSinopsis() + ", Genero --> " + this.getGenero() +
						", Duracion --> " + this.getDuracion() + ", Director --> " + this.getDirector() +
						", Enlace a trailer --> " + this.getEnlaceTrailer() + ", Valoracion media --> " + this.getValoracionMedia() +
						", Premios --> " + this.getPremios() + ", Comentarios --> [" + comentariosStr + "]" +
						", Actores --> No hay registrados";
			}
			else {
				StringBuffer actoresStr = new StringBuffer();
				for (String actor : this.getActores()) {
					actoresStr.append(actor.toString() + " - ");
				}

					return "Pelicula: Titulo --> " + this.getTitulo() + ", " +
							"Sinopsis -->  " + this.getSinopsis() + ", Genero --> " + this.getGenero() +
							", Duracion --> " + this.getDuracion() + ", Director --> " + this.getDirector() +
							", Enlace a trailer --> " + this.getEnlaceTrailer() + ", Valoracion media --> " + this.getValoracionMedia() +
							", Premios --> " + this.getPremios() + ", Comentarios --> [" + comentariosStr + "]" +
							", Actores --> [" + actoresStr + "]";
				}
			}

	}
}
