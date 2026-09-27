package ej7;

public class Arquero extends Personaje {
    private int flechas;

    public Arquero(String nombre, double vitalidad, int flechas, double x, double y) {
        super(nombre, vitalidad, x, y, 8, 4);
        this.flechas = flechas;
    }
    public int getFlechas() {
        return flechas;
    }
    public void setFlechas(int flechas) {
        this.flechas = flechas;
    }
}