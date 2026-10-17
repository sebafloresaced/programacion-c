package ej2;

// Excepcion para parametros incorrectos

public class ParametrosInvalidosException extends Exception {
    public ParametrosInvalidosException(String mensaje) {
        super(mensaje);
    }
}
