package ej3;

// procesar las acciones del usuario.

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class ControladorMemotest implements ActionListener {
    private Memotest modelo;
    private VentanaMemotest vista;
    private int primeraFila;
    private int primeraColumna;
    private boolean primeraSeleccionada;
    private boolean esperando;

    public ControladorMemotest(Memotest modelo, VentanaMemotest vista) {
        this.modelo = modelo;
        this.vista = vista;
        primeraSeleccionada = false;
        esperando = false;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        if (comando.startsWith("FICHA_")) { // FICHA_2_3 -> i = 2 ; j = 3
            String[] partes = comando.split("_");
            int fila = Integer.parseInt(partes[1]);
            int columna = Integer.parseInt(partes[2]);
            seleccionarFicha(fila, columna);
        }
    }

    private void seleccionarFicha(int fila, int columna) {
        if (esperando || modelo.juegoTerminado() || modelo.estaDescubierta(fila, columna)) {
            return;
        }
        if (primeraSeleccionada && fila == primeraFila && columna == primeraColumna) {
            return;
        }
        int ficha = modelo.getTablero().getFicha(fila, columna);
        vista.mostrarFicha(fila, columna, ficha);
        if (!primeraSeleccionada) {
            primeraFila = fila;
            primeraColumna = columna;
            primeraSeleccionada = true;
        } else {
            primeraSeleccionada = false;
            boolean coinciden = modelo.verificarPareja(primeraFila, primeraColumna, fila, columna);
            if (coinciden) {
                vista.fijarFicha(primeraFila, primeraColumna);
                vista.fijarFicha(fila, columna);
                vista.actualizarJugadores(modelo);
                if (modelo.juegoTerminado()) {
                    finalizarPartida();
                }
            } else {
                esperando = true;
                int segundaFila = fila;
                int segundaColumna = columna;
                Timer timer = new Timer(1200, evento -> {
                    vista.ocultarFicha(primeraFila, primeraColumna);
                    vista.ocultarFicha(segundaFila, segundaColumna);
                    esperando = false;
                    vista.actualizarJugadores(modelo);
                });
                timer.setRepeats(false);
                timer.start();
            }
        }
    }

    private void finalizarPartida() {
        String[] ganadores = modelo.getGanadores();
        String mensaje = "Partida terminada.\n";
        if (ganadores.length == 1) {
            mensaje += "Ganador: " + ganadores[0];
        } else {
            mensaje += "Empate entre: ";
            for (int i = 0; i < ganadores.length; i++) {
                if (i > 0) {
                    mensaje += ", ";
                }
                mensaje += ganadores[i];
            }
        }
        vista.mostrarMensaje(mensaje);
        vista.finalizarPartida();
    }
}