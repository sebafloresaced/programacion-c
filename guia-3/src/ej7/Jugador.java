package ej7;

public abstract class Jugador {
    private String nombre;
    private double indVelocidad,indPotencia; // ambos entre 0 y 1
    public Jugador(String nombre, double indVelocidad, double indPotencia) {
        this.nombre = nombre;
        this.indVelocidad = indVelocidad;
        this.indPotencia = indPotencia;
    }
    public String getNombre() {
        return nombre;
    }
    protected double getIndVelocidad() {
        return indVelocidad;
    }
    protected double getIndPotencia() {
        return indPotencia;
    }
    public abstract double indiceDefensa();
    public abstract double indiceAtaque();
}
