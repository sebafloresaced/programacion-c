package ej6;

public class Guerrero extends Personaje {
    public Guerrero(double vitalidad, double x, double y) {
        super(vitalidad, x, y);
    }
    @Override
    public void recibirHechizo(Hechizo hechizo) {
        hechizo.aplicar(this);
    }
}