package ej3;

public class Principal {
    public static void main(String[] args) {
        int cantidadJugadores = 3;
        Mesa mesa = new Mesa(cantidadJugadores);
        for (int i = 0; i < cantidadJugadores; i++) {
            Jugador jugador = new Jugador(i, mesa);
            Thread hilo = new Thread(jugador, "Jugador " + (i + 1)); 
            hilo.start();
        }
    }
}