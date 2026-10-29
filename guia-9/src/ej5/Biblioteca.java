package ej5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Biblioteca {
    private static final int CAPACIDAD = 10;
    private final HashMap<Integer, Libro> disponibles;
    private final ArrayList<Integer> catalogo;

    public Biblioteca() {
        disponibles = new HashMap<Integer, Libro>();
        catalogo = new ArrayList<Integer>();
        for (int id = 1; id <= 5; id++) {
            Libro libro = new Libro(id, "Libro " + id);
            disponibles.put(id, libro);
            catalogo.add(id);
        }
    }

    public synchronized int elegirLibro(Random random) {
        int posicion = random.nextInt(catalogo.size());
        return catalogo.get(posicion);
    }

    public synchronized Libro retirarLibro(int idLibro, String socio) throws InterruptedException {
        if (!catalogo.contains(idLibro)) {
            throw new IllegalArgumentException("El libro no existe");
        }
        while (!disponibles.containsKey(idLibro)) {
            System.out.println(socio + " espera el libro " + idLibro);
            Thread.sleep(1000);
            wait();
        }

        Libro libro = disponibles.remove(idLibro);
        System.out.println(socio + " retira: " + libro);
        // Se libero un lugar para una donacion o devolucion.
        Thread.sleep(1000);
        notifyAll();
        return libro;
    }

    public synchronized void devolverLibro(Libro libro, String socio) throws InterruptedException {
        while (disponibles.size() >= CAPACIDAD) {
            System.out.println(socio + " espera espacio para devolver");
            Thread.sleep(1000);
            wait();
        }
        disponibles.put(libro.getIdLibro(), libro);
        System.out.println(socio + " devuelve: " + libro);
        // El libro vuelve a estar disponible.
        Thread.sleep(1000);
        notifyAll();
    }

    public synchronized void donarLibro(Libro libro, String donador) throws InterruptedException {
        while (disponibles.size() >= CAPACIDAD) {
            System.out.println(donador + " espera: estantes llenos");
            Thread.sleep(1000);
            wait();
        }
        if (catalogo.contains(libro.getIdLibro())) {
            throw new IllegalArgumentException("Ya existe un libro con ese identificador");
        }
        disponibles.put(libro.getIdLibro(), libro);
        catalogo.add(libro.getIdLibro());
        System.out.println(donador + " dona: " + libro);
        Thread.sleep(1000);
        notifyAll();
    }
}