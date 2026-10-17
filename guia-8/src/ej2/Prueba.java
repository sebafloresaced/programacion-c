package ej2;

import javax.swing.SwingUtilities;

// Contiene el main e inicializa el MVC

public class Prueba {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            VentanaBuscaminas vista = new VentanaBuscaminas();
            ControladorBuscaminas controlador = new ControladorBuscaminas(vista);
            vista.setControlador(controlador);
        });
    }
}