package ej7;

public class Bote implements Runnable {
    private final int capacidad;
    private final boolean permiteIncompletos;
    private final int[] esperando;
    private int orillaActual = 0;
    private int pasajeros = 0;
    private int pendientes;
    private boolean viajando = false;
    private boolean desembarcando = false;

    public Bote(int capacidad, int personasOrilla0, int personasOrilla1, boolean permiteIncompletos) {
        if (capacidad <= 0 || personasOrilla0 < 0 || personasOrilla1 < 0) {
            throw new IllegalArgumentException("Datos invalidos");
        }
        this.capacidad = capacidad;
        this.permiteIncompletos = permiteIncompletos;
        esperando = new int[] { personasOrilla0, personasOrilla1 };
        pendientes = personasOrilla0 + personasOrilla1;
    }

    public synchronized void cruzar(String nombre, int origen) throws InterruptedException {
        // Espera para subir.
        while (orillaActual != origen || viajando || desembarcando || pasajeros == capacidad) {
            wait();
        }
        pasajeros++;
        esperando[origen]--;
        System.out.println(nombre + " sube en la orilla " + origen + ". Pasajeros: " + pasajeros);
        Thread.sleep(1000);
        // Puede que el bote ya este en condiciones de salir.
        notifyAll();
        // Espera hasta llegar a la otra orilla.
        while (!desembarcando || orillaActual == origen) {
            wait();
        }
        System.out.println(nombre + " baja en la orilla " + orillaActual);
        Thread.sleep(1000);
        pasajeros--;
        pendientes--;
        notifyAll();
    }

    private boolean puedeZarpar() {
        return pasajeros == capacidad || (permiteIncompletos && esperando[orillaActual] == 0);
    }

    @Override
    public void run() {
        try {
            while (true) {
                synchronized (this) {
                    while (pendientes > 0 && !puedeZarpar()) {
                        wait();
                    }
                    if (pendientes == 0) {
                        System.out.println("Todos cruzaron.");
                        return;
                    }
                    viajando = true;
                    System.out.println(
                        "\nEl bote sale de la orilla "
                        + orillaActual + " con "
                        + pasajeros + " pasajeros."
                    );
                }
                // Simula el viaje sin retener el monitor.
                Thread.sleep(1000);
                synchronized (this) {
                    orillaActual = 1 - orillaActual;
                    viajando = false;
                    desembarcando = true;
                    System.out.println("El bote llega a la orilla " + orillaActual);
                    // Despierta a los pasajeros para que bajen.
                    notifyAll();
                    while (pasajeros > 0) {
                        wait();
                    }
                    desembarcando = false;
                    // Ahora pueden subir personas de esta orilla.
                    notifyAll();
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}