package ej7;

public class Delantero extends Jugador{
    public Delantero(String nombre, double indVelocidad, double indPotencia) {
        super(nombre,indVelocidad,indPotencia);
    }
    @Override
    public double indiceDefensa() {
        return getIndVelocidad() * 0.5;
    }
    public double indiceAtaque() {
        return getIndVelocidad() * getIndPotencia();
    }
    public String toString() {
        return "Posicion = Delantero" +
                ", Nombre = " + getNombre() +
                ", indVelocidad = " + getIndVelocidad() +
                ", indPotencia = " + getIndPotencia();
    }
}
