package es.deusto.server.db;

import es.deusto.server.data.User;

//TODO: Clase a borrar; no hace falta para el Festival de Cine.
//TODO: Aún no se ha borrado para que no peten las dependencias con clases base que se pueden tomar como
//TODO: inspiración para modificar.


public interface IUserDAO {
	void storeUser(User u);

	User retrieveUser(String login);

	void updateUser(User u);

}
