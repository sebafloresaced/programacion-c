package ej3;

// validar las dimensiones del tablero

public class ParametrosInvalidosException extends Exception {
    public ParametrosInvalidosException(String mensaje) {
        super(mensaje);
    }
}