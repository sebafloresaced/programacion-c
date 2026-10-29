package ej6;

import java.util.HashMap;

public class Biblioteca {
    private final HashMap<Integer, Libro> libros;
    private final HashMap<Integer, Revista> revistas;
    private final Object monitorLibros = new Object();
    private final Object monitorRevistas = new Object();

    public Biblioteca() {
        libros = new HashMap<Integer, Libro>();
        revistas = new HashMap<Integer, Revista>();
        for (int id = 1; id <= 5; id++) {
            libros.put(id, new Libro(id, "Libro " + id));
            revistas.put(id, new Revista(id, "Revista " + id));
        }
    }

    public Libro retirarLibro(int id, String socio) throws InterruptedException {
        synchronized (monitorLibros) {
            while (!libros.containsKey(id)) {
                System.out.println(socio + " espera el libro " + id);
                Thread.sleep(1000);
                monitorLibros.wait();
            }
            Libro libro = libros.remove(id);
            System.out.println(socio + " retira: " + libro);
            Thread.sleep(1000);
            return libro;
        }
    }

    public void devolverLibro(Libro libro, String socio) throws InterruptedException {
        synchronized (monitorLibros) {
            libros.put(libro.getIdLibro(), libro);
            System.out.println(socio + " devuelve: " + libro);
            Thread.sleep(1000);
            monitorLibros.notifyAll();
        }
    }

    public Revista retirarRevista(int id, String socio) throws InterruptedException {
        synchronized (monitorRevistas) {
            while (!revistas.containsKey(id)) {
                System.out.println(socio + " espera la revista " + id);
                Thread.sleep(1000);
                monitorRevistas.wait();
            }
            Revista revista = revistas.remove(id);
            System.out.println(socio + " retira: " + revista);
            Thread.sleep(1000);
            return revista;
        }
    }

    public void devolverRevista(Revista revista, String socio) throws InterruptedException {
        synchronized (monitorRevistas) {
            revistas.put(revista.getIdRevista(), revista);
            System.out.println(socio + " devuelve: " + revista);
            Thread.sleep(1000);
            monitorRevistas.notifyAll();
        }
    }
}