package ej3;

public abstract class Personaje extends Unidad implements IPosicionable, IMovible {
    public Personaje(String equipo, int costo, int energia, int x, int y) {
        super(equipo, costo, energia, x, y);
    }
    public void mover(int x, int y) {
        setX(x);
        setY(y);
    }
}