package es.deusto.server.data;

import java.util.ArrayList;
import java.util.List;

public class ValoracionList {

    private List<ValoracionDTO> valoraciones = new ArrayList<ValoracionDTO>();

    public ValoracionList() {}

    public List<ValoracionDTO> getValoracionesDTO() {
        return this.valoraciones;
    }

    public void setValoracionesDTO(List<ValoracionDTO> valoraciones) {
        this.valoraciones.clear();
        this.valoraciones.addAll(valoraciones);
    }

	public void addValoracionDTO(ValoracionDTO v) {
		this.valoraciones.add(v);
	}
}