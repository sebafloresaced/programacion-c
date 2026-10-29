package ej3;

public class Jugador implements Runnable {
    private final int numero;
    private final Mesa mesa;

    public Jugador(int numero, Mesa mesa) {
        this.numero = numero;
        this.mesa = mesa;
    }
    
    @Override
    public void run() {
        try {
            while (mesa.jugarTurno(numero)) {
                // Intenta jugar nuevamente.
                // La mesa lo hace esperar hasta su proximo turno.
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}