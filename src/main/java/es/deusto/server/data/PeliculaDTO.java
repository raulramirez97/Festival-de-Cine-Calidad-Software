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
	private int anyo; //Se ha mantenido anyo como atributo "int" por simplicidad; no nos interesa utilizar un formato Date en este contexto.
	private String director; //Se ha entendido que habrá un único director por película por simplicidad, dado que no es lo más habitual ver múltiples directores.
	private String enlaceTrailer;
	private double valoracionMedia;
	private int numvaloraciones;
	//TODO: CAMBIAR A PREMIODTO.
	private String premios;
	private String seccionFestival;

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


	public PeliculaDTO(String titulo, String sinopsis, String genero, int duracion, int anyo,
					   String director, String enlaceTrailer, double valoracionMedia, String premios,
					   List<ComentarioDTO> comentarios, String seccion, String actores) {

		this.titulo = titulo;
		this.sinopsis = sinopsis;
		this.genero = genero;
		this.duracion = duracion;
		this.anyo = anyo;
		this.director = director;
		this.enlaceTrailer = enlaceTrailer;
		this.valoracionMedia = valoracionMedia;
		this.numvaloraciones = 0;
		this.premios = premios;
		this.seccionFestival = seccion;
		//TODO: PUEDE SER UTIL PENSAR EL COMENTARIO COMO UNA NUEVA CLASE, QUE TENGA SU FECHA, AUTOR Y CONTENIDO.
		this.comentarios = comentarios;
		this.elenco = actores;
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
	public double getValoracionMedia() {
		return valoracionMedia;
	}
	public void setValoracionMedia(double valoracionMedia) {
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
	public void setSeccionFestival(String seccionFestival) {
		this.seccionFestival = seccionFestival;
	}
	public String getSeccionFestival() {
		return seccionFestival;
	}
	public List<ComentarioDTO> getComentarios() {
		return comentarios;
	}
	public void setComentarios(List<ComentarioDTO> comentarios) {
		this.comentarios = comentarios;
	}
	public void setComentario(ComentarioDTO comentario) {
		this.comentarios.add(comentario);
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
					"Sinopsis -->  " + this.getSinopsis() + ", Genero --> " + this.getGenero() + ", Seccion --> " + this.getSeccionFestival() +
					", Duracion --> " + this.getDuracion() + ", Director --> " + this.getDirector() + ", Año --> " + this.getAnyo() +
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
							"Sinopsis -->  " + this.getSinopsis() + ", Genero --> " + this.getGenero() + ", Seccion --> " + this.getSeccionFestival() +
							", Duracion --> " + this.getDuracion() + ", Director --> " + this.getDirector() + ", Año --> " + this.getAnyo() +
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
						"Sinopsis -->  " + this.getSinopsis() + ", Genero --> " + this.getGenero() + ", Seccion --> " + this.getSeccionFestival() +
						", Duracion --> " + this.getDuracion() + ", Director --> " + this.getDirector() + ", Año --> " + this.getAnyo() +
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
							"Sinopsis -->  " + this.getSinopsis() + ", Genero --> " + this.getGenero() + ", Seccion --> " + this.getSeccionFestival() +
							", Duracion --> " + this.getDuracion() + ", Director --> " + this.getDirector() + ", Año --> " + this.getAnyo() +
							", Enlace a trailer --> " + this.getEnlaceTrailer() + ", Valoracion media --> " + this.getValoracionMedia() +
							", Premios --> " + this.getPremios() + ", Comentarios --> [" + comentariosStr + "]" +
							", Actores --> [" + this.getActores() + "]"+
							"\n__________________________________________\n";
				}
			}

	}
}
