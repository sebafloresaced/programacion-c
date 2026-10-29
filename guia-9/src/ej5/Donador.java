package ej5;

import java.util.Random;

public class Donador implements Runnable {
    private final Biblioteca biblioteca;
    private final int cantidadDonaciones;
    private final Random random;

    public Donador(Biblioteca biblioteca, int cantidadDonaciones) {
        this.biblioteca = biblioteca;
        this.cantidadDonaciones = cantidadDonaciones;
        random = new Random();
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < cantidadDonaciones; i++) {
                int id = 6 + i;
                Libro libro = new Libro(id, "Libro donado " + id);
                biblioteca.donarLibro(libro, "Donador");
                Thread.sleep(1000 + random.nextInt(2001));
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}