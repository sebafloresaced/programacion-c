package ej1;

import java.util.Random;

public class Tren implements Runnable {
    private final String nombre;
    private final int sentido;
    private final ViaCompartida via;
    private final Random random = new Random();

    public Tren(String nombre, int sentido, ViaCompartida via) {
        this.nombre = nombre;
        this.sentido = sentido;
        this.via = via;
    }

    @Override
    public void run() {
        try {
            // Simula distintos momentos de llegada.
            Thread.sleep(random.nextInt(1001));
            via.entrar(nombre, sentido);
            try {
                // Simula el recorrido por el tramo compartido.
                Thread.sleep(1000 + random.nextInt(2001));
            } finally {
                via.salir(nombre, sentido);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}