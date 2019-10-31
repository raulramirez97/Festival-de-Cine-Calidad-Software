package es.deusto.server.remote;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import es.deusto.server.dto.UsuarioDTO;

public interface IUsuarioAdmin extends Remote {
	public List<UsuarioDTO> getUsuariosDTO() throws RemoteException;
	public void generarNuevoUsuario (String email, String contra) throws NullPointerException;
	//public void generarNuevoUsuarioFacebook (String email) throws RemoteException, NullPointerException;
	public void eliminarUsuario (String email) throws RemoteException;
}