package ej7;

public class Caballero extends Personaje {
    private int armadura;

    public Caballero(String nombre, double vitalidad, int armadura, double x, double y) {
        super(nombre, vitalidad, x, y, 10, 1);
        this.armadura = armadura;
    }
    public int getArmadura() {
        return armadura;
    }
    public void setArmadura(int armadura) {
        this.armadura = armadura;
    }
}