package ej3;

public class OperacionConjuntosException extends Exception {
    private Object elemento;
    
    public OperacionConjuntosException(String string, Object elemento) {
        super(string);
        this.elemento = elemento;
    }
    
    public Object getElemento() {
        return elemento;
    }
}
