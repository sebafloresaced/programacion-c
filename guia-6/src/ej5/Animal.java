package ej5;

public class Animal {
    private int esperanzaDeVida;
    private String nombre;
    
    public Animal(String nombre, int esperanzaDeVida) {
        this.esperanzaDeVida = esperanzaDeVida;
        this.nombre = nombre;
    }
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    public int getEsperanzaDeVida() {
        return esperanzaDeVida;
    }
    public String getNombre() {
        return nombre;
    }
    public void setEsperanzaDeVida(int esperanzaDeVida) {
        this.esperanzaDeVida = esperanzaDeVida;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    @Override
    public String toString() {
        return " - Nombre: " + nombre +
            " - Esperanza de vida: " + esperanzaDeVida;
    }
}
