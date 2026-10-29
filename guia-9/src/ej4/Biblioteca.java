package ej4;

import java.util.HashMap;

public class Biblioteca {
    private final HashMap<Integer, Libro> disponibles;

    public Biblioteca() {
        disponibles = new HashMap<Integer, Libro>();
        disponibles.put(1, new Libro(1, "El principito"));
        disponibles.put(2, new Libro(2, "Don Quijote"));
        disponibles.put(3, new Libro(3, "Martin Fierro"));
        disponibles.put(4, new Libro(4, "Rayuela"));
        disponibles.put(5, new Libro(5, "El Hobbit"));
    }

    public synchronized Libro retirarLibro(int idLibro, String socio) throws InterruptedException {
        if (idLibro < 1 || idLibro > 5) {
            throw new IllegalArgumentException("El libro no existe");
        }
        while (!disponibles.containsKey(idLibro)) {
            System.out.println(socio + " espera el libro " + idLibro);
            Thread.sleep(1000);
            wait();
        }
        Libro libro = disponibles.remove(idLibro);
        System.out.println(socio + " retira: " + libro);
        Thread.sleep(1000);
        return libro;
    }

    public synchronized void devolverLibro(Libro libro, String socio) throws InterruptedException {
        disponibles.put(libro.getIdLibro(), libro);
        System.out.println(socio + " devuelve: " + libro);
        Thread.sleep(1000);
        notifyAll();
    }
}