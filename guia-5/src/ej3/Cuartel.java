package ej3;

public class Cuartel extends Edificio {

    public Cuartel(String equipo, int x, int y) {
        super(equipo, 500, 3000, x, y, 60);
    }

    @Override
    public void recibeDano(int cantidad) {
        setEnergia(getEnergia() - cantidad / 2);
    }
}