package ej6;

import java.util.Random;

public class SocioLibro implements Runnable {
    private final String nombre;
    private final Biblioteca biblioteca;
    private final Random random = new Random();

    public SocioLibro(String nombre, Biblioteca biblioteca) {
        this.nombre = nombre;
        this.biblioteca = biblioteca;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 3; i++) {
                int id = random.nextInt(5) + 1;
                Libro libro = biblioteca.retirarLibro(id, nombre);
                try {
                    Thread.sleep(1000 + random.nextInt(2001));
                } 
                finally {
                    biblioteca.devolverLibro(libro, nombre);
                }
                if (i < 2) {
                    Thread.sleep(500 + random.nextInt(1501));
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}