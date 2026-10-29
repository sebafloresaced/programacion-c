package ej2;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class VentanaCalculadora extends JFrame {
    private Calculadora calculadora;
    private JTextField txtPantalla;

    public VentanaCalculadora() {
        calculadora = new Calculadora();
        setTitle("Calculadora");
        setSize(300, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(5, 5));

        txtPantalla = new JTextField(calculadora.getPantalla());
        txtPantalla.setEditable(false);
        txtPantalla.setHorizontalAlignment(JTextField.RIGHT);
        txtPantalla.setFont(new Font("Arial", Font.PLAIN, 28));

        add(txtPantalla, BorderLayout.NORTH);

        JPanel panelBotones = new JPanel(new GridLayout(4, 4, 5, 5));

        String[] etiquetas = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "CE", "0", "=", "+"
        };

        for (String etiqueta : etiquetas) {
            JButton boton = new JButton(etiqueta);
            boton.setFont(new Font("Arial", Font.BOLD, 20));
            boton.addActionListener(e -> procesarBoton(etiqueta));
            panelBotones.add(boton);
        }

        add(panelBotones, BorderLayout.CENTER);
    }

    private void procesarBoton(String texto) {
        switch (texto) {
            case "CE":
                calculadora.cancelar();
                break;
            case "=":
                calculadora.igual();
                break;
            case "+":
            case "-":
            case "*":
            case "/":
                calculadora.ingresarOperador(texto.charAt(0));
                break;
            default:
                calculadora.ingresarDigito(Integer.parseInt(texto));
                break;
        }
        txtPantalla.setText(calculadora.getPantalla());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            VentanaCalculadora ventana = new VentanaCalculadora();
            ventana.setVisible(true);
        });
    }
}