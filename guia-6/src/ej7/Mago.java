package ej7;

public class Mago extends Personaje {
    public Mago(String nombre, double vitalidad, double x, double y) {
        super(nombre, vitalidad, x, y, 10, 3); // valores similares al Caballero
    }
    @Override
    public void incrementaPos(double x, double y) {
        moverSinValidar(x, y);
    }
}
