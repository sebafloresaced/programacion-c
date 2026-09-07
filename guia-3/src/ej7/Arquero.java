package ej7;

public class Arquero extends Jugador {
    private double efectividad;
    public Arquero(String nombre, double indVelocidad, double indPotencia, double efectividad) {
        super(nombre,indVelocidad,indPotencia);
        this.efectividad = efectividad;
    }
    public Arquero(String nombre, double indVelocidad, double indPotencia) {
        this(nombre,indVelocidad,indPotencia,0.5);
    }
    @Override
    public double indiceDefensa() {
        return efectividad;
    }
    public double indiceAtaque() {
        return 0.1 * getIndVelocidad() * getIndPotencia();
    }
    public String toString() {
        return "Posicion = Arquero" +
                ", Nombre = " + getNombre() +
                ", indVelocidad = " + getIndVelocidad() +
                ", indPotencia = " + getIndPotencia() +
                ", efectividad = " + efectividad;
    }
}
