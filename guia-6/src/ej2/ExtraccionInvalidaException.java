package ej2;

public class ExtraccionInvalidaException extends Exception {
    private Dato_Extraccion_Invalido dato;
    
    public ExtraccionInvalidaException(double saldo, double cantidad) {
        dato = new Dato_Extraccion_Invalido(saldo, cantidad);
    }
    public Dato_Extraccion_Invalido getDato() {
        return dato;
    }
}
