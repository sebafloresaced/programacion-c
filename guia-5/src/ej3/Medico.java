package ej3;

public class Medico extends Personaje {
    public Medico(String equipo, int x, int y) {
        super(equipo, 40, 100, x, y);
    }

    @Override
    public void recibeDano(int cantidad) {
        setEnergia(getEnergia() - cantidad * 3 / 2);
    }
}