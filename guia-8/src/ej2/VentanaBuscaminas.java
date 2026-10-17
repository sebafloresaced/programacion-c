package ej2;

import java.awt.*;
import java.awt.event.ActionListener;

import java.util.EventListener;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

// Vista: muestra la configuracion y el tablero grafico

public class VentanaBuscaminas extends JFrame {
    private JTextField txtAncho;
    private JTextField txtAlto;
    private JTextField txtMinas;
    private JButton btnAceptar;
    private JButton[][] botones;
    private JPanel panelTablero;
    private ActionListener controlador;

    public VentanaBuscaminas() {
        setTitle("Buscaminas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));
        crearConfiguracion();
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void crearConfiguracion() {
        JPanel panel = new JPanel(new GridLayout(7, 1, 5, 5));
        
        txtAncho = new JTextField(15);
        txtAlto = new JTextField(15);
        txtMinas = new JTextField(15);

        btnAceptar = new JButton("Aceptar");
        btnAceptar.setActionCommand("INICIAR");
        btnAceptar.setEnabled(false);

        panel.add(new JLabel("Ancho (maximo 20)"));
        panel.add(txtAncho);
        panel.add(new JLabel("Alto (maximo 20)"));
        panel.add(txtAlto);
        panel.add(new JLabel("Cantidad de minas"));
        panel.add(txtMinas);
        panel.add(btnAceptar);

        add(panel, BorderLayout.WEST);

        MiListener listener = new MiListener(this);

        txtAncho.getDocument().addDocumentListener(listener);
        txtAlto.getDocument().addDocumentListener(listener);
        txtMinas.getDocument().addDocumentListener(listener);
    }

    public void validarCampos() {
        try {
            int ancho = getAnchoTablero();
            int alto = getAltoTablero();
            int minas = getCantidadMinas();

            boolean valido = ancho > 0 && ancho <= 20
                    && alto > 0 && alto <= 20
                    && minas >= 0
                    && minas <= ancho * alto;

            btnAceptar.setEnabled(valido);
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

    public int getCantidadMinas() {
        return Integer.parseInt(txtMinas.getText().trim());
    }

    public void setControlador(ActionListener controlador) {
        if (this.controlador != null) {
            btnAceptar.removeActionListener(this.controlador);
        }
        this.controlador = controlador;
        btnAceptar.addActionListener(controlador);
    }

    public void crearTablero(int alto, int ancho) {
        if (panelTablero != null) {
            remove(panelTablero);
        }
        panelTablero = new JPanel(new GridLayout(alto, ancho, 2, 2));
        botones = new JButton[alto][ancho];

        for (int i = 0; i < alto; i++) {
            for (int j = 0; j < ancho; j++) {
                JButton boton = new JButton();
                boton.setActionCommand("CASILLA_" + i + "_" + j);
                boton.addActionListener(controlador);
                botones[i][j] = boton;
                panelTablero.add(boton);
            }
        }

        add(panelTablero, BorderLayout.CENTER);

        txtAncho.setEditable(false);
        txtAlto.setEditable(false);
        txtMinas.setEditable(false);
        btnAceptar.setEnabled(false);

        setSize(Math.max(550, ancho * 45 + 220), Math.max(350, alto * 40 + 80));

        setLocationRelativeTo(null);

        revalidate();
        repaint();
    }

    public void mostrarMina(int i, int j) {
        JButton boton = botones[i][j];
        boton.setText("M");
        boton.setEnabled(false);
    }

    public void mostrarNumero(int i, int j, int cantidad) {
        JButton boton = botones[i][j];
        if (cantidad == 0) {
            boton.setText("");
        } else {
            boton.setText(String.valueOf(cantidad));
        }
        boton.setEnabled(false);
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