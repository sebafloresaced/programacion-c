package ej1;

import javax.swing.SwingUtilities;

public class Principal {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            VentanaMascota ventana = new VentanaMascota();
            ObservadorConsola consola = new ObservadorConsola();

            Mascota[] mascotas = {
                new Mascota("Luna"),
                new Mascota("Toby"),
                new Mascota("Milo"),
                new Mascota("Nina")
            };

            // Registramos ambos observadores en cada mascota.
            for (Mascota mascota : mascotas) {
                mascota.agregarObservador(consola);
                mascota.agregarObservador(ventana);
            }

            ventana.setVisible(true);

            // Iniciamos un hilo independiente por mascota.
            for (Mascota mascota : mascotas) {
                Thread hilo = new Thread(mascota);
                hilo.start();
            }
        });
    }
}