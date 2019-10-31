package es.deusto.server.data;

public class DirectedMessage {

    private UsuarioDTO usuarioDTO;
    private String message;

    public DirectedMessage() {

    }
    
    public DirectedMessage(String login, String password, String message) {
    	this.usuarioDTO = new UsuarioDTO(login, password);
    	this.message = message;
    }

    public void setUsuarioDTO(UsuarioDTO usuarioDTO) {
        this.usuarioDTO = usuarioDTO;
    }

    public UsuarioDTO getUsuarioDTO() {
        return this.usuarioDTO;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}