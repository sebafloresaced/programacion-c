package ej8;

public abstract class Colectivo extends Vehiculo {
    private static int sigNroInterno = 1;
    private int cantidadPasajeros;

    public Colectivo(String modelo, int cantidadPasajeros) {
        super(modelo, sigNroInterno);
        sigNroInterno++;
        this.cantidadPasajeros = cantidadPasajeros;
    }
    public int getCantidadPasajeros() {
        return cantidadPasajeros;
    }
    @Override
    public String toString() {
        return super.toString() +
               " - Cantidad pasajeros: " + cantidadPasajeros;
    }
}