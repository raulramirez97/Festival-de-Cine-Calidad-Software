package es.deusto.server.gateway;

/**
 * Variacion de Strategy hecha con Interfaz para login en vez de clase abstracta.
 * @author Benat
 */
public interface IGatewayAuth {
	public int darAltaUsuario(String correo);
}
