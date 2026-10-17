package ej2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Controla el inicio, las jugadas y el final del juego

public class ControladorBuscaminas implements ActionListener {
    private Buscaminas modelo;
    private VentanaBuscaminas vista;

    private boolean[][] descubiertas;
    private int casillasRestantes;
    private boolean terminado;

    public ControladorBuscaminas(VentanaBuscaminas vista) {
        this.vista = vista;
        this.modelo = null;
        this.terminado = false;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        if (comando.equals("INICIAR")) {
            iniciarPartida();
        } else if (comando.startsWith("CASILLA_")) { // CASILLA_2_3 -> i = 2 ; j = 3
            String[] datos = comando.split("_");
            int i = Integer.parseInt(datos[1]);
            int j = Integer.parseInt(datos[2]);
            descubrirCasilla(i, j);
        }
    }

    private void iniciarPartida() {
        try {
            int ancho = vista.getAnchoTablero();
            int alto = vista.getAltoTablero();
            int cantMinas = vista.getCantidadMinas();

            modelo = new Buscaminas(ancho, alto, cantMinas);
            descubiertas = new boolean[alto][ancho];
            casillasRestantes = ancho * alto - cantMinas;
            terminado = false;

            vista.crearTablero(alto, ancho);
        } catch (ParametrosInvalidosException ex) {
            vista.mostrarMensaje(ex.getMessage());
        }
    }

    private void descubrirCasilla(int i, int j) {
        if (terminado || modelo == null || descubiertas[i][j]) {
            return;
        }
        try {
            descubiertas[i][j] = true;
            if (modelo.isMina(i, j)) {
                vista.mostrarMina(i, j);
                terminado = true;
                vista.mostrarMensaje("Perdiste. Encontraste una mina.");
                vista.finalizarPartida();
            } else {
                int cercanas = modelo.getMinasCercanas(i, j);
                vista.mostrarNumero(i, j, cercanas);
                casillasRestantes--;
                if (cercanas == 0) {
                    descubrirVecinas(i, j);
                }
                if (casillasRestantes == 0) {
                    terminado = true;
                    vista.mostrarMensaje("Ganaste la partida.");
                    vista.finalizarPartida();
                }
            }
        } catch (FueraTableroException ex) {
            vista.mostrarMensaje(ex.getMessage());
        }
    }
    
    private void descubrirVecinas(int i, int j) {
        for (int fila = i - 1; fila <= i + 1; fila++) {
            for (int columna = j - 1; columna <= j + 1; columna++) {
                if (!terminado 
                    && fila >= 0 && fila < descubiertas.length
                    && columna >= 0
                    && columna < descubiertas[0].length
                    && !descubiertas[fila][columna]) {

                    descubrirCasilla(fila, columna);
                }
            }
        }
    }
}
