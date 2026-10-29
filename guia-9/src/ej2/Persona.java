package ej2;

public class Persona implements Runnable {
    private final int numero;
    private final int cantidadVueltas;
    private final Mostrador mostrador;

    public Persona(int numero, int cantidadVueltas, Mostrador mostrador) {
        this.numero = numero;
        this.cantidadVueltas = cantidadVueltas;
        this.mostrador = mostrador;
    }

    @Override
    public void run() {
        try {
            for (int vuelta = 1; vuelta <= cantidadVueltas; vuelta++) {
                mostrador.atender(numero);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}