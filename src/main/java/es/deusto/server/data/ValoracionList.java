package es.deusto.server.data;

import java.util.ArrayList;
import java.util.List;

/**
 * Este bloque de código recoge la estructura de datos con la que se agrupan
 * las ValoracionesDTO del sistema, para posibilitar su transferencia mediante
 * la API RESTful.
 * @author Grupo RMBJ
 * @version 3.0
 * @since 1.0
 */
public class ValoracionList {

    private List<ValoracionDTO> valoraciones = new ArrayList<ValoracionDTO>();

    public ValoracionList() { }

    public List<ValoracionDTO> getValoracionesDTO() {
        return this.valoraciones;
    }

    public void setValoracionesDTO(List<ValoracionDTO> valoraciones) {
        this.valoraciones.clear();
        this.valoraciones.addAll(valoraciones);
    }
}
