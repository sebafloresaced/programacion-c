package ej3;

// Administrar el tablero, los jugadores, los turnos y los aciertos.

public class Memotest {
    private Tablero tablero;
    private String[] jugadores;
    private int[] aciertos;
    private int turnoActual;
    private boolean[][] descubiertas;
    private int parejasRestantes;

    public Memotest(Tablero tablero, String[] jugadores) {
        if (tablero == null || jugadores == null || jugadores.length == 0) {
            throw new IllegalArgumentException("Los parametros son invalidos");
        }
        for (String jugador : jugadores) {
            if (jugador == null) {
                throw new IllegalArgumentException( "Los jugadores no pueden ser null");
            }
        }

        this.tablero = tablero;
        this.jugadores = jugadores.clone();
        aciertos = new int[jugadores.length];
        turnoActual = 0;

        descubiertas = new boolean[tablero.getAlto()][tablero.getAncho()];
        parejasRestantes = tablero.getAlto() * tablero.getAncho() / 2;
    }

    public boolean verificarPareja(int fila1, int columna1, int fila2, int columna2) {
        validarPosicion(fila1, columna1);
        validarPosicion(fila2, columna2);
        if (juegoTerminado()) {
            throw new IllegalStateException("La partida ya termino");
        }
        if (fila1 == fila2 && columna1 == columna2) {
            return false;
        }
        if (descubiertas[fila1][columna1] || descubiertas[fila2][columna2]) {
            return false;
        }

        int ficha1 = tablero.getFicha(fila1, columna1);
        int ficha2 = tablero.getFicha(fila2, columna2);
        if (ficha1 == ficha2) {
            descubiertas[fila1][columna1] = true;
            descubiertas[fila2][columna2] = true;
            aciertos[turnoActual]++;
            parejasRestantes--;
            return true;
        }

        cambiarTurno();
        return false;
    }

    private void cambiarTurno() {
        turnoActual = (turnoActual + 1) % jugadores.length;
    }

    private void validarPosicion(int fila, int columna) {
        if (fila < 0 || fila >= tablero.getAlto() || columna < 0 || columna >= tablero.getAncho()) {
            throw new IndexOutOfBoundsException("Posicion fuera del tablero");
        }
    }

    public boolean estaDescubierta(int fila, int columna) {
        validarPosicion(fila, columna);
        return descubiertas[fila][columna];
    }

    public boolean juegoTerminado() {
        return parejasRestantes == 0;
    }

    public String getJugadorActual() {
        return jugadores[turnoActual];
    }

    public int getTurnoActual() {
        return turnoActual;
    }

    public int getCantidadJugadores() {
        return jugadores.length;
    }

    public String getJugador(int indice) {
        return jugadores[indice];
    }

    public int getAciertos(int indice) {
        return aciertos[indice];
    }

    public int getParejasRestantes() {
        return parejasRestantes;
    }

    public Tablero getTablero() {
        return tablero;
    }

    public String[] getGanadores() {
        if (!juegoTerminado()) {
            throw new IllegalStateException("La partida todavia no termino");
        }
        int maxAciertos = 0;
        for (int acierto : aciertos) {
            if (acierto > maxAciertos) {
                maxAciertos = acierto;
            }
        }
        int cantidadGanadores = 0;
        for (int acierto : aciertos) {
            if (acierto == maxAciertos) {
                cantidadGanadores++;
            }
        }
        String[] ganadores = new String[cantidadGanadores];
        int indice = 0;
        for (int i = 0; i < jugadores.length; i++) {
            if (aciertos[i] == maxAciertos) {
                ganadores[indice++] = jugadores[i];
            }
        }
        return ganadores;
    }
}