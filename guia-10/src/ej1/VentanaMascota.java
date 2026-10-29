package ej1;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class VentanaMascota extends JFrame implements Observador {
    private JTextArea txtAvisos;

    public VentanaMascota() {
        setTitle("Mascotas virtuales");
        setSize(500, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        txtAvisos = new JTextArea();
        txtAvisos.setEditable(false);

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(new JScrollPane(txtAvisos), BorderLayout.CENTER);

        add(panel);
    }

    @Override
    public void actualizar(Mascota mascota) {
        String mensaje = mascota.getNombre() + " " + mascota.getNecesidad();
        SwingUtilities.invokeLater(() -> {
            txtAvisos.append(mensaje + "\n");
        });
    }
}