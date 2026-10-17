package ej3;

import javax.swing.*;

public class Prueba {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            VentanaMemotest vista = new VentanaMemotest();
            vista.setAccionAceptar(e -> {
                try {
                    int ancho = vista.getAnchoTablero();
                    int alto = vista.getAltoTablero();
                    String nombres = JOptionPane.showInputDialog(vista, "Ingrese los jugadores separados por comas:");
                    if (nombres == null) {
                        return;
                    }
                    String[] jugadores = nombres.split(",");
                    for (int i = 0; i < jugadores.length; i++) {
                        jugadores[i] = jugadores[i].trim();
                    }
                    if (nombres.trim().isEmpty()) {
                        vista.mostrarMensaje("Debe ingresar al menos un jugador");
                        return;
                    }
                    for (String jugador : jugadores) {
                        if (jugador.isEmpty()) {
                            vista.mostrarMensaje("Los nombres no pueden estar vacios");
                            return;
                        }
                    }
                    Tablero tablero = new Tablero(ancho, alto);
                    Memotest modelo = new Memotest(tablero, jugadores);
                    ControladorMemotest controlador = new ControladorMemotest(modelo, vista);
                    vista.setControlador(controlador);
                    vista.crearTablero(alto, ancho);
                    vista.actualizarJugadores(modelo);
                } catch (ParametrosInvalidosException ex) {
                    vista.mostrarMensaje(ex.getMessage());
                }
            });
        });
    }
}