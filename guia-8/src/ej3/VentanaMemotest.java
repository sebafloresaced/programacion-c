package ej3;

// representar el tablero gráficamente

import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class VentanaMemotest extends JFrame {
    private JTextField txtAncho;
    private JTextField txtAlto;
    private JButton btnAceptar;
    private JPanel panelTablero;
    private JButton[][] botones;
    private JTextArea txtJugadores;
    private JLabel lblTurno;

    private ImageIcon[] imagenes;
    private ActionListener controlador;

    public VentanaMemotest() {
        setTitle("Memotest");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        cargarImagenes();
        crearConfiguracion();

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void crearConfiguracion() {
        JPanel panelIzquierdo = new JPanel(new BorderLayout(5, 5));
        JPanel panelCampos = new JPanel(new GridLayout(5, 1, 5, 5));
        
        txtAncho = new JTextField(5);
        txtAlto = new JTextField(5);

        btnAceptar = new JButton("Aceptar");
        btnAceptar.setEnabled(false);

        panelCampos.add(new JLabel("Ancho:"));
        panelCampos.add(txtAncho);
        panelCampos.add(new JLabel("Alto:"));
        panelCampos.add(txtAlto);
        panelCampos.add(btnAceptar);

        panelIzquierdo.add(panelCampos, BorderLayout.NORTH);
        add(panelIzquierdo, BorderLayout.WEST);

        JPanel panelSuperior = new JPanel(new BorderLayout(10, 10));

        txtJugadores = new JTextArea(4, 18);
        txtJugadores.setEditable(false);

        lblTurno = new JLabel("Turno actual: -");

        panelSuperior.add(new JScrollPane(txtJugadores), BorderLayout.CENTER);
        panelSuperior.add(lblTurno, BorderLayout.EAST);
        add(panelSuperior, BorderLayout.NORTH);

        DocumentListener listener = new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                validarCampos();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                validarCampos();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                validarCampos();
            }
        };

        txtAncho.getDocument().addDocumentListener(listener);
        txtAlto.getDocument().addDocumentListener(listener);
    }

    private void validarCampos() {
        try {
            int ancho = getAnchoTablero();
            int alto = getAltoTablero();
            btnAceptar.setEnabled(
                ancho > 0 && ancho <= 20 &&
                alto > 0 && alto <= 20 &&
                (ancho * alto) % 2 == 0
            );
        } catch (NumberFormatException e) {
            btnAceptar.setEnabled(false);
        }
    }

    public int getAnchoTablero() {
        return Integer.parseInt(txtAncho.getText().trim());
    }

    public int getAltoTablero() {
        return Integer.parseInt(txtAlto.getText().trim());
    }

    public void setAccionAceptar(ActionListener listener) {
        btnAceptar.addActionListener(listener);
    }

    public void setControlador(ActionListener controlador) {
        this.controlador = controlador;
    }

    public void crearTablero(int alto, int ancho) {
        if (panelTablero != null) {
            remove(panelTablero);
        }
        panelTablero = new JPanel(new GridLayout(alto, ancho, 4, 4));
        botones = new JButton[alto][ancho];
        for (int i = 0; i < alto; i++) {
            for (int j = 0; j < ancho; j++) {
                JButton boton = new JButton();
                boton.setPreferredSize(new Dimension(64, 64));
                boton.setActionCommand("FICHA_" + i + "_" + j);
                boton.addActionListener(controlador);
                botones[i][j] = boton;
                panelTablero.add(boton);
            }
        }
        add(panelTablero, BorderLayout.CENTER);

        txtAncho.setEditable(false);
        txtAlto.setEditable(false);
        btnAceptar.setEnabled(false);

        pack();
        setLocationRelativeTo(null);
        revalidate();
        repaint();
    }

    private void cargarImagenes() {
        imagenes = new ImageIcon[120];
        for (int i = 0; i < 120; i++) {
            File archivo = new File("memotest/64/" + i + "_64px.png");
            if (archivo.exists()) {
                imagenes[i] = new ImageIcon(archivo.getAbsolutePath());
            }
        }
    }

    public void mostrarFicha(int fila, int columna, int ficha) {
        JButton boton = botones[fila][columna];
        if (ficha >= 0 && ficha < imagenes.length &&
            imagenes[ficha] != null) {
            boton.setIcon(imagenes[ficha]);
            boton.setDisabledIcon(imagenes[ficha]);
            boton.setText("");
        } else {
            // Permite jugar aunque falten las imagenes.
            boton.setIcon(null);
            boton.setText(String.valueOf(ficha));
        }
        boton.setEnabled(false);
    }

    public void ocultarFicha(int fila, int columna) {
        JButton boton = botones[fila][columna];
        boton.setIcon(null);
        boton.setText("");
        boton.setEnabled(true);
    }

    public void fijarFicha(int fila, int columna) {
        botones[fila][columna].setEnabled(false);
    }

    public void actualizarJugadores(Memotest modelo) {
        String texto = "Jugadores:\n";
        for (int i = 0; i < modelo.getCantidadJugadores(); i++) {
            texto += modelo.getJugador(i) + " (" + modelo.getAciertos(i) + " aciertos)\n";
        }
        txtJugadores.setText(texto);
        lblTurno.setText("Turno actual: " + modelo.getJugadorActual());
    }

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }

    public void finalizarPartida() {
        for (int i = 0; i < botones.length; i++) {
            for (int j = 0; j < botones[i].length; j++) {
                botones[i][j].setEnabled(false);
            }
        }
    }
}