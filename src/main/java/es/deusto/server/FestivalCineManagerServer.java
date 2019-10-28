package es.deusto.server;

import java.rmi.Naming;
import java.rmi.RMISecurityManager;

import es.deusto.server.gateway.GoogleAuth;
import es.deusto.server.gateway.IGatewayAuth;
import es.deusto.server.remote.IUsuarioAdmin;
import es.deusto.server.remote.UsuarioAdmin;

public class FestivalCineManagerServer {
	
	public static void main(String[] args) {
		// TODO: VALIDAR LA CANTIDAD DE ARGUMENTOS QUE TIENE EL SERVIDOR
		if (args.length != 5) {
			System.exit(0);
		}

		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new RMISecurityManager());
		}

		//String nameReserva = "//" + args[0] + ":" + args[1] + "/" + args[2];
		String nameUsuario = "//" + args[0] + ":" + args[1] + "/" + args[2];
		System.out.println(nameUsuario);
		
		try {
			
			/*IGatewayPago resTarjetaService = new PagoTarjeta(args[4], Integer.parseInt(args[5]));
			IGatewayPago resPayPalService = new PagoPayPal(args[6], Integer.parseInt(args[7]));
			
			IGatewayAir airSocketService = new AirToScreen(args[8], Integer.parseInt(args[9]));*/

			IGatewayAuth googleService = new GoogleAuth(args[3], Integer.parseInt(args[4]));
			/*IGatewayAuth facebookService = new FacebookAuth(args[12], Integer.parseInt(args[13]));

			IReservaAdmin reservaAdminService = new ReservaAdmin(resTarjetaService, resPayPalService, airSocketService);			
			Naming.rebind(nameReserva, reservaAdminService);
			System.out.println("* Reserva Admin Service '" + nameReserva + "' active and waiting...");*/
			
			//IUsuarioAdmin usuarioAdminService = new UsuarioAdmin(googleService, facebookService);
			IUsuarioAdmin usuarioAdminService = new UsuarioAdmin(googleService);
			Naming.rebind(nameUsuario, usuarioAdminService);
			System.out.println("* Usuario Admin Service '" + nameUsuario + "' active and waiting...");
		} 
		catch (Exception e) 
		{
			System.err.println("$ UsuarioManager exception: " + e.getMessage());
		}
	}

}
