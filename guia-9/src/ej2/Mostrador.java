package ej2;

public class Mostrador {
    private final int cantidadPersonas;
    private int turnoActual;

    public Mostrador(int cantidadPersonas) {
        if (cantidadPersonas <= 0) {
            throw new IllegalArgumentException("La cantidad de personas debe ser positiva");
        }
        this.cantidadPersonas = cantidadPersonas;
        this.turnoActual = 1;
    }

    public synchronized void atender(int numero) throws InterruptedException {
        while (numero != turnoActual) {
            wait();
        }
        System.out.println("Atendiendo a la persona " + numero);
        turnoActual = turnoActual % cantidadPersonas + 1;
        Thread.sleep(1000);
        notifyAll();
    }
}