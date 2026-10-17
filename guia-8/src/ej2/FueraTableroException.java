package ej2;

// Excepcion para coordenadas invalidas

public class FueraTableroException extends Exception {
    public FueraTableroException(String mensaje) {
        super(mensaje);
    }
}
