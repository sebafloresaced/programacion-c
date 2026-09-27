package ej3;

public abstract class Edificio extends Unidad implements IPosicionable, IConstruible {
    private int tiempoConstruccion;

    public Edificio(String equipo, int costo, int energia, int x, int y, int tiempoConstruccion) {
        super(equipo, costo, energia, x, y);
        this.tiempoConstruccion = tiempoConstruccion;
    }
    @Override
    public int getTiempoConstruccion() {
        return tiempoConstruccion;
    }
}