package ej3;

import java.util.ArrayList;
import java.util.Collections;

public class Mesa {
    private final ArrayList<Integer> baraja;
    private final int[] puntos;
    private final int[] manosGanadas;

    private int turnoActual;
    private int ronda;
    private boolean terminado;

    public Mesa(int cantidadJugadores) {
        if (cantidadJugadores <= 0) {
            throw new IllegalArgumentException("Debe haber al menos un jugador");
        }

        baraja = new ArrayList<Integer>();
        puntos = new int[cantidadJugadores];
        manosGanadas = new int[cantidadJugadores];
        turnoActual = 0;
        ronda = 1;
        terminado = false;

        // Cuatro cartas de cada valor, del 1 al 9.
        for (int valor = 1; valor <= 9; valor++) {
            for (int cantidad = 0; cantidad < 4; cantidad++) {
                baraja.add(valor);
            }
        }
        // Dieciseis cartas que valen 10.
        for (int cantidad = 0; cantidad < 16; cantidad++) {
            baraja.add(10);
        }
        Collections.shuffle(baraja);
    }

    public synchronized boolean jugarTurno(int jugador) throws InterruptedException {
        while (!terminado && jugador != turnoActual) {
            wait();
        }
        if (terminado) {
            return false;
        }
        int suma = 0;
        // Suponemos que con 15 tambien debe tomar otra carta.
        while (suma < 16) {
            if (baraja.isEmpty()) {
                System.out.println("Ronda " + ronda + " anulada: faltan cartas.");
                finalizarJuego();
                return false;
            }
            int carta = baraja.remove(baraja.size() - 1);
            suma += carta;
        }
        puntos[jugador] = suma;
        // Los puntos se muestran al terminar la ronda.
        System.out.println("El jugador " + (jugador + 1) + " termino su turno.");
        turnoActual++;
        if (turnoActual == puntos.length) {
            resolverRonda();
            turnoActual = 0;
            ronda++;
            if (baraja.isEmpty()) {
                finalizarJuego();
                return false;
            }
        }
        Thread.sleep(1000);
        notifyAll();
        return true;
    }

    private void resolverRonda() {
        System.out.println("\nResultados de la ronda " + ronda);
        int mejorPuntaje = -1;
        int ganador = -1;
        boolean empate = false;
        for (int i = 0; i < puntos.length; i++) {
            System.out.println("Jugador " + (i + 1) + ": " + puntos[i] + " puntos");
            if (puntos[i] <= 21) {
                if (puntos[i] > mejorPuntaje) {
                    mejorPuntaje = puntos[i];
                    ganador = i;
                    empate = false;
                } else if (puntos[i] == mejorPuntaje) {
                    empate = true;
                }
            }
        }
        if (ganador == -1) {
            System.out.println("Todos superaron los 21 puntos.");
        } else if (empate) {
            System.out.println("Empate: nadie gana la mano.");
        } else {
            manosGanadas[ganador]++;
            System.out.println("Gana la mano el jugador " + (ganador + 1));
        }
        System.out.println();
    }

    private void finalizarJuego() {
        terminado = true;
        System.out.println("\nFIN DEL JUEGO");
        int mayorCantidad = -1;
        for (int i = 0; i < manosGanadas.length; i++) {
            System.out.println("Jugador " + (i + 1) + ": " + manosGanadas[i] + " manos ganadas");
            if (manosGanadas[i] > mayorCantidad) {
                mayorCantidad = manosGanadas[i];
            }
        }
        int ganador = -1;
        int cantidadGanadores = 0;
        for (int i = 0; i < manosGanadas.length; i++) {
            if (manosGanadas[i] == mayorCantidad) {
                ganador = i;
                cantidadGanadores++;
            }
        }
        if (cantidadGanadores == 1) {
            System.out.println("Ganador del juego: jugador " + (ganador + 1));
        } else {
            System.out.println("El juego termina empatado con " + mayorCantidad + " manos ganadas.");
        }
        // Despierta a los jugadores para que puedan terminar.
        notifyAll();
    }
}