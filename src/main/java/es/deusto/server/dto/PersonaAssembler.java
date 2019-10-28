package es.deusto.server.dto;

import es.deusto.server.data.Persona;

import java.util.ArrayList;
import java.util.List;

public class PersonaAssembler 
{
	//TODO: No nos hace falta para gran cosa en las funciones que contemplamos. No obstante, puede ser de inter�s mantenerlo para
	//futuras ampliaciones.
	
private static PersonaAssembler instance = new PersonaAssembler();
	
	private PersonaAssembler() {}

	public static PersonaAssembler getInstance() {
		return instance;
	}
	
	public List<PersonaDTO> assemble(List<Persona> personas)
	{
		List<PersonaDTO> personasDTO = new ArrayList<>();
		for (Persona r : personas) {
			personasDTO.add(new PersonaDTO(r.getPasaporte(), r.getNombre(), r.getApellido1(), r.getApellido2()));
		}
		System.out.println("* Assembling personas ...");
		return personasDTO;
	}
}
