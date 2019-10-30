package es.deusto.server.dto;

import es.deusto.server.data.Usuario;

import java.util.ArrayList;
import java.util.List;

public class UsuarioAssembler {
	
private static UsuarioAssembler instance = new UsuarioAssembler();
	
	private UsuarioAssembler() {}

	public static UsuarioAssembler getInstance() {
		return instance;
	}
	
	public List<UsuarioDTO> assemble(List<Usuario> usuarios) 
	{
		List<UsuarioDTO> usuariosDTO = new ArrayList<>();
		for (Usuario r : usuarios) {
			usuariosDTO.add(new UsuarioDTO(r.getEmail(),r.getContrasena()));
		}
		System.out.println("* Assembling Usuarios ...");		
		return usuariosDTO;
	}
}
