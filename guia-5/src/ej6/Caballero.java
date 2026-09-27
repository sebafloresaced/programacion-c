package ej6;

public class Caballero extends Personaje {
    private int armadura;

    public Caballero(double vitalidad, int armadura, double x, double y) {
        super(vitalidad, x, y);
        this.armadura = armadura;
    }
    public int getArmadura() {
        return armadura;
    }
    public void setArmadura(int armadura) {
        this.armadura = armadura;
    }
    @Override
    public void recibirHechizo(Hechizo hechizo) {
        hechizo.aplicar(this);
    }
}