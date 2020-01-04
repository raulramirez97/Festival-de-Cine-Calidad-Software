package es.deusto.server.data;

import javax.jdo.annotations.Join;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Este bloque de código recoge la estructura de datos con la que se representan las Películas en el sistema.
 * @author Grupo RMBJ
 * @version 3.0
 * @since 1.0
 */
@PersistenceCapable(detachable = "true")
public class PeliculaDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@PrimaryKey
	private String titulo;

	private String sinopsis;
	private String genero;
	private int duracion;
	/**
	 * Representa el año de estreno de una película. Se ha mantenido como atributo "int" por simplicidad.
	 */
	private int anyo;
	/**
	 * Representa un String con el nombre y apellido o pseudónimo del director de la película. Se ha entendido que
	 * habrá un único director por película por simplicidad, dado que no es lo más habitual ver múltiples directores.
	 */
	private String director;
	private String enlaceTrailer;
	private double valoracionMedia;
	private int numvaloraciones;
	/**
	 * Representa un String con los premios que ha ganado una película concreta.
	 */
	private String premios;
	private String seccionFestival;

	@Persistent(defaultFetchGroup = "true", mappedBy = "pelicula", dependentElement = "true")
	@Join
	private List<ComentarioDTO> comentarios = new ArrayList<ComentarioDTO>();

	/**
	 * Representa los nombres y apellidos de los actores más destacados que han participado en esta película.
	 * Se ha evitado generar esto como una Lista de Actores DTO, porque generaba una recursividad infinita al
	 * insertar actores y películas actualizados, tal y como está estructurada la aplicación.
	 */
	private String elenco = "";

	/**
	 * Representa la ruta en la que se encuentra la imagen de la pelicula a la que se quiere hacer referencia. Por
	 * ello, es importante tener la carpeta java/resources/img con los carteles de las películas preparados.
	 */
	private String URIimagen = "";

	public PeliculaDTO(String titulo, String sinopsis, String genero, int duracion, int anyo,
                       String director, String enlaceTrailer, double valoracionMedia, String premios,
                       List<ComentarioDTO> comentarios, String seccion, String actores, String URIimagen) {

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
		this.comentarios = comentarios;
		this.elenco = actores;
		this.URIimagen = URIimagen;
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
	public String getURIimagen() {
		return URIimagen;
	}
	public void setURIimagen(String URIimagen) {
		this.URIimagen = URIimagen;
	}

	/**
	 * Método toString generado para obtener la representación a modo de informe por pantalla. Sin embargo, este
	 * método debería dejar de usarse cuando el informe se genere con una ventana nueva.
	 * @return Informe de una película en formato texto mediante terminal.
	 */
	public String toString() {

		if (this.getComentarios() == null) {
			if (this.getActores() == null) {
			return "___________________________________________\n" +
					"Pelicula: Titulo --> " + this.getTitulo() + ", " +
					"Sinopsis -->  " + this.getSinopsis() + ", Genero --> " + this.getGenero() + ", Seccion --> "
					+ this.getSeccionFestival() +  ", Duracion --> " + this.getDuracion() + ", Director --> "
					+ this.getDirector() + ", Año --> " + this.getAnyo() + ", Enlace a trailer --> "
					+ this.getEnlaceTrailer() + ", Valoracion media --> " + this.getValoracionMedia() +
					", Premios --> " + this.getPremios()
					+ ", Comentarios --> No hay registrados, Actores --> No hay registrados" +
					"\n__________________________________________\n";

				}
			else {
					return "___________________________________________\n" +
							"Pelicula: Titulo --> " + this.getTitulo() + ", " +
							"Sinopsis -->  " + this.getSinopsis() + ", Genero --> " + this.getGenero()
							+ ", Seccion --> " + this.getSeccionFestival() + ", Duracion --> " + this.getDuracion()
							+ ", Director --> " + this.getDirector() + ", Año --> " + this.getAnyo()
							+ ", Enlace a trailer --> " + this.getEnlaceTrailer()
							+ ", Valoracion media --> " + this.getValoracionMedia() +
							", Premios --> " + this.getPremios() + ", Comentarios --> No hay registrados" +
							", Actores --> [" + this.getActores() + "]"+
							"\n__________________________________________\n";
				}
			}
		else {
			StringBuffer comentariosStr = new StringBuffer();
			for (ComentarioDTO comentario : this.getComentarios()) {
				comentariosStr.append(comentario.toString() + " - ");
			}

			if (this.getActores() == null) {
				return "___________________________________________\n" +
						"Pelicula: Titulo --> " + this.getTitulo() + ", " +
						"Sinopsis -->  " + this.getSinopsis() + ", Genero --> " + this.getGenero()
						+ ", Seccion --> " + this.getSeccionFestival() + ", Duracion --> " + this.getDuracion()
						+ ", Director --> " + this.getDirector() + ", Año --> " + this.getAnyo() +
						", Enlace a trailer --> " + this.getEnlaceTrailer()
						+ ", Valoracion media --> " + this.getValoracionMedia() + ", Premios --> " + this.getPremios()
						+ ", Comentarios --> [" + comentariosStr + "]" +
						", Actores --> No hay registrados"+
						"\n__________________________________________\n";
			}
			else {
					return "___________________________________________\n" +
							"Pelicula: Titulo --> " + this.getTitulo() + ", " +
							"Sinopsis -->  " + this.getSinopsis() + ", Genero --> " + this.getGenero()
							+ ", Seccion --> " + this.getSeccionFestival() + ", Duracion --> " + this.getDuracion()
							+ ", Director --> " + this.getDirector() + ", Año --> " + this.getAnyo() +
							", Enlace a trailer --> " + this.getEnlaceTrailer()
							+ ", Valoracion media --> " + this.getValoracionMedia() +
							", Premios --> " + this.getPremios() + ", Comentarios --> [" + comentariosStr + "]" +
							", Actores --> [" + this.getActores() + "]"+
							"\n__________________________________________\n";
				}
			}

	}
}
