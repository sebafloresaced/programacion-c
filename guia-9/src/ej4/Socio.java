package ej4;

import java.util.Random;

public class Socio implements Runnable {
    private final String nombre;
    private final Biblioteca biblioteca;
    private final int cantidadPrestamos;
    private final Random random;

    public Socio(String nombre, Biblioteca biblioteca,int cantidadPrestamos) {
        this.nombre = nombre;
        this.biblioteca = biblioteca;
        this.cantidadPrestamos = cantidadPrestamos;
        this.random = new Random();
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < cantidadPrestamos; i++) {
                int idLibro = random.nextInt(5) + 1;
                Libro libro = biblioteca.retirarLibro(idLibro, nombre);
                try {
                    // Simula el tiempo de lectura: 1 a 3 segundos.
                    Thread.sleep(1000 + random.nextInt(2001));
                } finally {
                    // Lo devuelve incluso si se interrumpe la lectura.
                    biblioteca.devolverLibro(libro, nombre);
                }
                if (i < cantidadPrestamos - 1) {
                    // Espera entre 0,5 y 2 segundos antes de otro retiro.
                    Thread.sleep(500 + random.nextInt(1501));
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}