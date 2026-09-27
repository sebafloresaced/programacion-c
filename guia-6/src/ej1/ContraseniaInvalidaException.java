package ej1;

public class ContraseniaInvalidaException extends Exception {
    private String mensaje;
    
    public ContraseniaInvalidaException(String mensaje) {
        this.mensaje = mensaje;
    }
    public String getMensaje() {
        return mensaje;
    }
}
