package ej3;

// Administrar las fichas y sus posiciones dentro del tablero.

import java.util.Random;

public class Tablero {
    private int ancho;
    private int alto;
    private int[][] casilleros;

    public Tablero(int ancho, int alto) throws ParametrosInvalidosException {
        if (ancho <= 0 || alto <= 0 || (long) ancho * alto % 2 != 0) {
            throw new ParametrosInvalidosException("Dimensiones invalidas");
        }
        if ((long) ancho * alto > 240) {
            throw new ParametrosInvalidosException("El tablero supera la cantidad de fichas disponibles");
        }

        this.ancho = ancho;
        this.alto = alto;
        casilleros = new int[alto][ancho];
        generarParejas();
    }

    private void generarParejas() {
        int cantidad = ancho * alto;
        int[] fichas = new int[cantidad];

        for (int i = 0; i < cantidad; i++) {
            fichas[i] = i / 2;
        }

        Random random = new Random();

        for (int i = cantidad - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            int aux = fichas[i];
            fichas[i] = fichas[j];
            fichas[j] = aux;
        }

        for (int i = 0; i < alto; i++) {
            for (int j = 0; j < ancho; j++) {
                casilleros[i][j] = fichas[i * ancho + j];
            }
        }
    }

    public int getFicha(int fila, int columna) {
        return casilleros[fila][columna];
    }

    public int getAncho() {
        return ancho;
    }

    public int getAlto() {
        return alto;
    }
}