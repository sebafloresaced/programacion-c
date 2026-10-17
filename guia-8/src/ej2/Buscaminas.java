package ej2;

import java.util.Random;

// Modelo: genera las minas y calcula las minas cercanas

public class Buscaminas {
    private int ancho;
    private int alto;
    private boolean[][] minas; // true -> contiene mina ; false -> no contiene mina

    public Buscaminas(int ancho, int alto, int cantMinas) throws ParametrosInvalidosException {
        if (ancho <= 0 || alto <= 0 || cantMinas <= 0 || cantMinas > ancho * alto) {
            throw new ParametrosInvalidosException("Los parametros ingresados son invalidos");
        }
        this.ancho = ancho;
        this.alto = alto;
        minas = new boolean[alto][ancho];
        Random random = new Random();
        int colocadas = 0;
        while (colocadas < cantMinas) {
            int i = random.nextInt(alto);
            int j = random.nextInt(ancho);
            if (!minas[i][j]) {
                minas[i][j] = true;
                colocadas++;
            }
        }
    }

    public boolean isMina(int i, int j) throws FueraTableroException {
        validarPosicion(i, j);
        return minas[i][j];
    }

    public int getMinasCercanas(int i, int j) throws FueraTableroException {
        validarPosicion(i, j);
        int cantidad = 0;
        for (int fila = i - 1; fila <= i + 1; fila++) {
            for (int columna = j - 1; columna <= j + 1; columna++) {
                if ((fila != i || columna != j) && fila >= 0 && fila < alto && columna >= 0 && columna < ancho) {
                    if (minas[fila][columna]) {
                        cantidad++;
                    }
                }
            }
        }
        return cantidad;
    }

    private void validarPosicion(int i, int j) throws FueraTableroException {
        if (i < 0 || i >= alto || j < 0 || j >= ancho) {
            throw new FueraTableroException("La posicion esta fuera del tablero");
        }
    }
}
