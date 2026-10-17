package ej4;

import ej4.modelo.EstacionServicio;
import ej4.vista.VentanaEstacion;
import ej4.controlador.ControladorEstacion;
import javax.swing.SwingUtilities;

public class Prueba {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            EstacionServicio modelo = new EstacionServicio();
            VentanaEstacion vista = new VentanaEstacion();
            ControladorEstacion controlador = new ControladorEstacion(modelo, vista);
            vista.setControlador(controlador);
            vista.actualizarDatos(modelo);
            vista.setVisible(true);
        });
    }
}
