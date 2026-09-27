package ej2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/* - JFrame: la ventana
 * - JLabel: texto en pantalla
 * - JTextField: donde escribis la cantidad
 * - JButton: botones
 * - JOptionPane: ventana emergente para mostrar errores
 */

public class VentanaCuenta extends JFrame {
    private CuentaBancaria cuenta;

    private JLabel lblSaldo;
    private JTextField txtCantidad;
    private JButton btnDepositar;
    private JButton btnExtraer;

    public VentanaCuenta() {
        cuenta = new CuentaBancaria("Sebastian");

        setTitle("Cuenta Bancaria");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 2));

        // Titular
        add(new JLabel("Titular:"));
        add(new JLabel(cuenta.getTitular()));

        // Saldo
        add(new JLabel("Saldo:"));
        lblSaldo = new JLabel("$" + cuenta.getSaldo());
        add(lblSaldo);

        // Cantidad
        add(new JLabel("Cantidad:"));
        txtCantidad = new JTextField();
        add(txtCantidad);

        // Botones
        btnDepositar = new JButton("Depositar");
        btnExtraer = new JButton("Extraer");

        add(btnDepositar);
        add(btnExtraer);

        // Eventos de los botones
        btnDepositar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                depositar();
            }
        });

        btnExtraer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                extraer();
            }
        });

        setVisible(true);
    }

    private void depositar() {
        try {
            double cantidad = Double.parseDouble(txtCantidad.getText());
            cuenta.depositar(cantidad);
            lblSaldo.setText("$" + cuenta.getSaldo());
        } catch (DepositoInvalidoException e) {
            JOptionPane.showMessageDialog(this, "Depósito inválido.\nCantidad: " + e.getCantidadInvalida());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Debe ingresar un número." );
        }
    }
    
    private void extraer() {
        try {
            double cantidad = Double.parseDouble(txtCantidad.getText());
            cuenta.extraer(cantidad);
            lblSaldo.setText("$" + cuenta.getSaldo());
        } catch (ExtraccionInvalidaException e) {
            Dato_Extraccion_Invalido dato = e.getDato();
            JOptionPane.showMessageDialog(
                this,
                "No hay saldo suficiente.\n"
                + "Saldo disponible: $" + dato.getSaldo()
                + "\nExtracción solicitada: $"
                + dato.getExtraccion_solicitada()
            );
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Debe ingresar un número.");
        }
    }

    public static void main(String[] args) {
        new VentanaCuenta();
    }
}
