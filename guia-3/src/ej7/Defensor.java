package ej7;

public class Defensor extends Jugador {
    public Defensor(String nombre, double indVelocidad, double indPotencia) {
        super(nombre,indVelocidad,indPotencia);
    }
    @Override
    public double indiceDefensa() {
        return Math.pow(getIndVelocidad(), 2);
    }
    public double indiceAtaque() {
        return Math.pow(getIndPotencia(), 2);
    }
    public String toString() {
        return "Posicion = Defensor" +
                ", Nombre = " + getNombre() +
                ", indVelocidad = " + getIndVelocidad() +
                ", indPotencia = " + getIndPotencia();
    }
}
