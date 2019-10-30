package es.deusto.client.remote;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import es.deusto.server.remote.IUsuarioAdmin;
import es.deusto.server.dto.UsuarioDTO;

import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

public class RMIServiceLocator{
	// The Cache
	//private IReservaAdmin reservaService;
	//private IUsuarioAdmin usuarioService;
	//private IRMIAirline airlineService;
	private Client client;
	private WebTarget webTargetService;

    public RMIServiceLocator() {}

    public void setService(String[] args) {

		client = ClientBuilder.newClient();
		webTargetService = client.target(String.format("http://%s:%s/rest/server/", args[0], args[1]));
		System.out.println(String.format("http://%s:%s/rest/server/", args[0], args[1]));
	}
    	// TODO: AQUI TENGO QUE METER EL CONTENIDO DE "EXAMPLECLIENT" (REGISTERUSER,SAYMESSAGE,GETUSERMESSAGES)
		// TODO: LAS LLAMADAS DEL MAIN DEL "EXAMPLECLIENT" VENDRIAN DE ALTA/INICIO/LOGIN Y LUEGO DE CONTROLLER.


		public void registerUser(String login, String password) {
			WebTarget registerUserWebTarget = this.webTargetService.path("register");
            //Invocation.Builder invocationBuilder = sayHelloWebTarget.queryParam("login", "dipina").request(MediaType.APPLICATION_JSON);
			Invocation.Builder invocationBuilder = registerUserWebTarget.request(MediaType.APPLICATION_JSON);

			UsuarioDTO user = new UsuarioDTO(login, password);
			Response response = invocationBuilder.post(Entity.entity(user, MediaType.APPLICATION_JSON));
            //Response response = invocationBuilder.get();

			if (response.getStatus() != Status.OK.getStatusCode()) {
				System.out.println("Error connecting with the server. Code: " + response.getStatus());
			} else {
				System.out.println("User correctly registered");
			}
		}
/*


	public ExampleClient(String hostname, String port) {
			client = ClientBuilder.newClient();
			webTarget = client.target(String.format("http://%s:%s/rest/server", hostname, port));
		}

		public void registerUser(String login, String password) {
			WebTarget registerUserWebTarget = webTarget.path("register");
			Invocation.Builder invocationBuilder = registerUserWebTarget.request(MediaType.APPLICATION_JSON);

			User user = new User(login, password);
			Response response = invocationBuilder.post(Entity.entity(user, MediaType.APPLICATION_JSON));
			if (response.getStatus() != Status.OK.getStatusCode()) {
				System.out.println("Error connecting with the server. Code: " + response.getStatus());
			} else {
				System.out.println("User correctly registered");
			}
		}

		public String sayMessage(String login, String password, String message) {
			WebTarget sayHelloWebTarget = webTarget.path("sayMessage");
			Invocation.Builder invocationBuilder = sayHelloWebTarget.request(MediaType.APPLICATION_JSON);

			DirectedMessage directedMessage = new DirectedMessage();
			User user = new User(login, password);

			directedMessage.setUser(user);
			directedMessage.setMessage(message);

			Response response = invocationBuilder.post(Entity.entity(directedMessage, MediaType.APPLICATION_JSON));
			if (response.getStatus() != Status.OK.getStatusCode()) {
				System.out.println("Error connecting with the server. Code: " + response.getStatus());
				return "";
			} else {
				String responseMessage = response.readEntity(String.class);
				return responseMessage;
			}
		}

		public MessageList getUserMessages(String login) {
			WebTarget sayHelloWebTarget = webTarget.path("messages");
			Invocation.Builder invocationBuilder = sayHelloWebTarget.queryParam("login", "dipina").request(MediaType.APPLICATION_JSON);

			Response response = invocationBuilder.get();
			if (response.getStatus() != Status.OK.getStatusCode()) {
				System.out.println("Error connecting with the server. Code: " + response.getStatus());
				return new MessageList();
			} else {
				MessageList messageList = response.readEntity(MessageList.class);
				return messageList;
			}
		}


 */
    	// Add your code to get the TARGET reference HERE
      	/*try
      	{
      		reservaService = (IReservaAdmin) Naming.lookup("//" + args[0] + ":" + args[1] + "/" + args[2]);
    	} catch (MalformedURLException | RemoteException | NotBoundException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    	}*/
      	/*try
      	{
      		usuarioService = (IUsuarioAdmin) Naming.lookup("//" + args[0] + ":" + args[1] + "/" + args[2]);
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
      	/*try
      	{
      		airlineService = (IRMIAirline) Naming.lookup("//" + args[0] + ":" + args[1] + "/" + args[4]);
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
    
    //}



    /*public IReservaAdmin getReservaService() {
    	return reservaService;
    }*/
    
    /*public IUsuarioAdmin getUsuarioService() {
    	return usuarioService;
    }*/
    /*public IRMIAirline getRMIAirlineService() {
    	return airlineService;
    }*/
}