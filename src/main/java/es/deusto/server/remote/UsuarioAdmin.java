package es.deusto.server.remote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

import es.deusto.server.data.Usuario;
import es.deusto.server.dto.UsuarioAssembler;
import es.deusto.server.dto.UsuarioDTO;
import es.deusto.server.db.DBManager;
import es.deusto.server.gateway.IGatewayAuth;

public class UsuarioAdmin extends UnicastRemoteObject implements IUsuarioAdmin
{
	private static final long serialVersionUID = 1L;
	private Map<String, Usuario> usuarios = new TreeMap<String, Usuario>();
	private IGatewayAuth gatewayGoogle;
	private IGatewayAuth gatewayFacebook;

	/*public UsuarioAdmin(IGatewayAuth gservice, IGatewayAuth fservice) throws RemoteException, NullPointerException {
		super();
		gatewayGoogle = gservice;
		gatewayFacebook = fservice;
	}*/
	public UsuarioAdmin(IGatewayAuth gservice) throws RemoteException, NullPointerException {
		super();
		gatewayGoogle = gservice;
	}
	public synchronized void generarNuevoUsuarioGoogle (String email) throws RemoteException, NullPointerException {
		if (gatewayGoogle.darAltaUsuario(email)==0)
		{
			System.out.println("Este usuario existe en Google+. Se proceder� a crear el usuario con el correo "+ email);
		}
		else
		{
			System.out.println("Este usuario no existe en Google+. - El usuario no se crear�");
			throw new NullPointerException();
		}
		if (!(usuarios.containsKey(email)))
		{
			System.out.println("* Creando un nuevo usuario: " + email);
			Usuario user = new Usuario(email);
			usuarios.put(email, user);
			DBManager.getInstance().guardarUsuario(user);
		}
		else
		{
			System.out.println("The user has not been created");
			throw new RemoteException();
		}
	}
	/*public synchronized void generarNuevoUsuarioFacebook (String email) throws RemoteException, NullPointerException {
		if (gatewayFacebook.darAltaUsuario(email)==0)
		{
			System.out.println("Este usuario existe en Facebook. Se proceder� a crear el usuario con el correo "+ email);
		}
		else
		{
			System.out.println("Este usuario no existe en Facebook. - El usuario no se crear�");
			throw new NullPointerException();
		}
		if (!(usuarios.containsKey(email)))
		{
			System.out.println("* Creando un nuevo usuario: " + email);
			Usuario user = new Usuario(email);
			usuarios.put(email, user);
			DBManager.getInstance().guardarUsuario(user);
		}
		else
		{
			System.out.println("The user has not been created");
			throw new RemoteException();
		}
	}*/

	public synchronized List<UsuarioDTO> getUsuariosDTO() {
		return UsuarioAssembler.getInstance().assemble(getUsuarios());
	}
	
	public synchronized List<Usuario> getUsuarios() {
		List<Usuario> usuarios = new ArrayList<Usuario>();
		System.out.println("* Retrieving Usuarios ...");
		for(Entry<String, Usuario> entry : this.usuarios.entrySet()) {
			  usuarios.add(entry.getValue());
			}
		return usuarios;
	}
	
	//TODO: Finalmente no se ha utilizado en esta implementaci�n. Se podr�a tratar de asignar esta funci�n en un futuro.
	public synchronized void eliminarUsuario(String email) {
		usuarios.remove(email);
		System.out.println("* Removing users: " + email);
	}
}
