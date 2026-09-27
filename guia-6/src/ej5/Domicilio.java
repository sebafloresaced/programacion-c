package ej5;

public class Domicilio implements Cloneable {
    private String calle;
    private int numero;
    
    public Domicilio(String calle, int numero) {
        this.calle = calle;
        this.numero = numero;
    }
    @Override
    public Object clone() {
        try {
            return (Domicilio)super.clone();
        }
        catch(CloneNotSupportedException e) {
            throw new InternalError(e.toString());
        }
    }
    public String getCalle() {
        return calle;
    }
    public int getNumero() {
        return numero;
    }
    public void setCalle(String calle) {
        this.calle = calle;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }
    @Override
    public String toString() {
        return " - Calle: " + calle + " - Numero: " + numero;
    }
}
