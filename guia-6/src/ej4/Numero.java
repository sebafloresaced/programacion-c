package ej4;

public class Numero implements Cloneable {
    private int dato;
    
    public Numero(int dato) {
        this.dato = dato;
    }
    public int getDato() {
        return dato;
    }
    public void setDato(int dato) {
        this.dato = dato;
    }
    @Override
    public String toString() {
        return String.valueOf(dato);
    }
    @Override
    public Object clone() {
        try {
            return (Numero)super.clone();
        }
        catch(CloneNotSupportedException e) {
            throw new InternalError(e.toString());
        }
    }
}
