package ej1;

public class Animal {
    private String nombre;
    private int esperanzaDeVida;

    public Animal(String nombre, int esperanzaDeVida) {
        this.nombre = nombre;
        this.esperanzaDeVida = esperanzaDeVida;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getEsperanzaDeVida() {
        return esperanzaDeVida;
    }
    public void setEsperanzaDeVida(int esperanzaDeVida) {
        this.esperanzaDeVida = esperanzaDeVida;
    }
}
