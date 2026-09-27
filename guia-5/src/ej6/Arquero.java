package ej6;

public class Arquero extends Personaje {
    private int flechas;

    public Arquero(double vitalidad, int flechas, double x, double y) {
        super(vitalidad, x, y);
        this.flechas = flechas;
    }
    public int getFlechas() {
        return flechas;
    }
    public void setFlechas(int flechas) {
        this.flechas = flechas;
    }
    @Override
    public void recibirHechizo(Hechizo hechizo) {
        hechizo.aplicar(this);
    }
}