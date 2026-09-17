package ej8;

public abstract class Vehiculo {
    private int nroInterno;
    private String modelo;

    public Vehiculo(String modelo, int nroInterno) {
        this.modelo = modelo;
        this.nroInterno = nroInterno;
    }
    public int getNroInterno() {
        return nroInterno;
    }
    public String getModelo() {
        return modelo;
    }
    public abstract boolean aceptoChofer(Chofer chofer);
    @Override
    public String toString() {
        return "Modelo: " + modelo +
               " - Interno: " + nroInterno;
    }
}
