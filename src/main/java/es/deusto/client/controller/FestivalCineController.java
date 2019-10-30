package es.deusto.client.controller;

import java.rmi.RemoteException;
import java.util.List;

import es.deusto.client.gui.Inicio;
import es.deusto.client.remote.RMIServiceLocator;
import es.deusto.server.dto.UsuarioDTO;

public class FestivalCineController {
	private static FestivalCineController instance;
	private RMIServiceLocator rsl;

	private FestivalCineController(String[] args) throws RemoteException {
		instance = this;
		rsl = new RMIServiceLocator();
		rsl.setService(args);
		Inicio frame = new Inicio();
		frame.setVisible(true);
	}
	
	public static FestivalCineController getInstance() {
		return instance;
	}

	/*public void nuevaReserva(int codigoReserva, String email, String codigoVuelo, Date fecha, ArrayList<PersonaDTO> personas, int pago) throws RemoteException {
			rsl.getReservaService().nuevaReserva(codigoReserva, email, codigoVuelo, fecha, personas, pago);
	}
	
	public int numeroReservas() throws RemoteException {
		try {
			return rsl.getReservaService().numeroReservas();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return 0;
	}*/
	
	public List<UsuarioDTO> getUsuarios() throws RemoteException {
		//return rsl.getUsuarioService().getUsuariosDTO();
		//TODO: EDITAR
		return null;
	}

	public void crearNuevoUsuario(String email, String contra) throws RemoteException, NullPointerException {
		//rsl.getUsuarioService().generarNuevoUsuarioGoogle(email);
		rsl.registerUser(email, contra);
	}
	
	/*public void crearNuevoUsuarioFacebook (String email) throws RemoteException, NullPointerException {
		rsl.getUsuarioService().generarNuevoUsuarioFacebook(email);
	}*/
	
	/*public List<RMIAeropuertoDTO> getRMIAeropuertos() {
		List<RMIAeropuertoDTO> aeropuertos = new ArrayList<>();
		try {
			aeropuertos = rsl.getRMIAirlineService().getAeropuertosDTO();
		} 
		catch (RemoteException e) 
		{
			e.printStackTrace();
		}
		return aeropuertos;
	}
	
	public List<AeropuertoDTO> getSocketAeropuertos() throws RemoteException {
		return rsl.getReservaService().getAeropuertosSocketDTO();
	}*/

	/*
	//TODO: Finalmente no se ha utilizado en esta implementacion. Se podria tratar de asignar esta funcion en un futuro.
	public List<ReservaDTO> getReservas() {
		List<ReservaDTO> reservas = new ArrayList<>();
		try {
			reservas = rsl.getReservaService().getReservasDTO();
		} 
		catch (RemoteException e) 
		{
			e.printStackTrace();
		}
		return reservas;
	}
	
	//TODO: Finalmente no se ha utilizado en esta implementacion. Se podria tratar de asignar esta funcion en un futuro.
	public void cancelarReserva(int codigoReserva) throws RemoteException{
		try {
			rsl.getReservaService().cancelarReserva(codigoReserva);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	//TODO: Finalmente no se ha utilizado en esta implementacion. Se podria tratar de asignar esta funcion en un futuro.
	public void eliminarUsuario (String email) {
		try {
			rsl.getUsuarioService().eliminarUsuario(email);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}*/

	public void exit() {
		System.exit(0);
	}

	public static void main(String[] args) throws RemoteException {
		new FestivalCineController(args);

		//TODO: ANADIR SI ESO VALIDACION DE NUMERO DE ARGUMENTOS

		/*if (args.length != 2) {
			System.out.println("Use: java Client.Client [host] [port]");
			System.exit(0);
		}

		String hostname = args[0];
		String port = args[1];*/

		/*ExampleClient exampleClient = new ExampleClient(hostname, port);

		System.out.println("Register a user for the first time: dipina");
		exampleClient.registerUser("dipina", "dipina");
		System.out.println("Change the password as the user is already registered: cortazar");
		exampleClient.registerUser("dipina", "cortazar");
		System.out.println("* Message coming from the server: '"
				+ exampleClient.sayMessage("dipina", "cortazar", "This is test 1!") + "'");
		System.out.println("* Message coming from the server: '"
				+ exampleClient.sayMessage("dipina", "cortazar", "This is test 2!") + "'");

		MessageList messages = exampleClient.getUserMessages("dipina");
		for (Message m : messages.getMessages()) {
			System.out.println(m);*/
	}
}