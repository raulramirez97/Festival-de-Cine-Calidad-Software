package es.deusto.server.data;

import java.util.ArrayList;
import java.util.List;

public class UserList {

    private List<UsuarioDTO> usuarios = new ArrayList<UsuarioDTO>();

    public UserList() {

    }

    public List<UsuarioDTO> getUsuarios() {
        return this.usuarios;
    }

    public void setUsuarios(List<UsuarioDTO> usuarios) {
        this.usuarios.clear();
        this.usuarios.addAll(usuarios);
    }

	public void addUsuario(UsuarioDTO u) {
		this.usuarios.add(u);
	}
}