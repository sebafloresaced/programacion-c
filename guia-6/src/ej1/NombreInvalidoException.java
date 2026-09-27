package ej1;

public class NombreInvalidoException extends Exception {
    private String mensaje;
    
    public NombreInvalidoException(String mensaje) {
        this.mensaje = mensaje;
    }
    public String getMensaje() {
        return mensaje;
    }
}
