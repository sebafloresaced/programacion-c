package ej7;

public class Persona implements Runnable {
    private final String nombre;
    private final int orillaOrigen;
    private final Bote bote;

    public Persona(String nombre, int orillaOrigen, Bote bote) {
        this.nombre = nombre;
        this.orillaOrigen = orillaOrigen;
        this.bote = bote;
    }

    @Override
    public void run() {
        try {
            bote.cruzar(nombre, orillaOrigen);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}