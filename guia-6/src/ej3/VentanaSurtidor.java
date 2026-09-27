package ej3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VentanaSurtidor extends JFrame {
    private Surtidor surtidor;

    private JTextField txtCombustible;
    private JTextField txtCantidad;
    
    private JLabel lblDiesel;
    private JLabel lblPremium;
    private JLabel lblSuper;

    private JTextArea areaErrores;

    private JButton btnCargar;
    private JButton btnLlenarDiesel;
    private JButton btnLlenarPremium;
    private JButton btnLlenarSuper;

    public VentanaSurtidor() {
        surtidor = new Surtidor();

        setTitle("Estacion de Servicio");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Datos para cargar combustible
        add(new JLabel("Combustible:"));

        txtCombustible = new JTextField(10);
        add(txtCombustible);

        add(new JLabel("Cantidad:"));

        txtCantidad = new JTextField(10);
        add(txtCantidad);

        btnCargar = new JButton("Cargar combustible");
        add(btnCargar);


        // Cantidades disponibles
        lblDiesel = new JLabel();
        lblPremium = new JLabel();
        lblSuper = new JLabel();

        add(lblDiesel);
        add(lblPremium);
        add(lblSuper);


        // Botones para llenar los depositos
        btnLlenarDiesel = new JButton("Llenar Diesel");
        btnLlenarPremium = new JButton("Llenar Premium");
        btnLlenarSuper = new JButton("Llenar Super");

        add(btnLlenarDiesel);
        add(btnLlenarPremium);
        add(btnLlenarSuper);


        // Area donde mostramos los errores
        areaErrores = new JTextArea(10, 40);
        areaErrores.setEditable(false);

        add(new JScrollPane(areaErrores));


        // Eventos
        btnCargar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cargar();
            }
        });
        btnLlenarDiesel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                surtidor.llenarDiesel();
                actualizarCantidades();
            }
        });
        btnLlenarPremium.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                surtidor.llenarPremium();
                actualizarCantidades();
            }
        });
        btnLlenarSuper.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                surtidor.llenarSuper();
                actualizarCantidades();
            }
        });

        actualizarCantidades();

        setVisible(true);
    }


    private void cargar() {
        try {
            String combustible = txtCombustible.getText();
            double cantidad = Double.parseDouble(txtCantidad.getText());
            surtidor.cargarCombustible(
                combustible,
                cantidad
            );
            actualizarCantidades();
        } catch (FaltaCombustibleException e) {
            DatoCargaInvalido dato = e.getDatoCargaInvalido();
            areaErrores.append(
                "FALTA COMBUSTIBLE\n"
                + e.getMessage() + "\n"
                + "Combustible: "
                + dato.getCombustible() + "\n"
                + "Cantidad requerida: "
                + dato.getCantidadRequerida() + "\n"
                + "Cantidad disponible: "
                + dato.getCantidadDisponible() + "\n\n"
            );
            actualizarCantidades();
        } catch (TipoCombustibleInvalidoException e) {
            DatoCargaInvalido dato = e.getDatoCargaInvalido();
            areaErrores.append(
                "TIPO DE COMBUSTIBLE INVALIDO\n"
                + e.getMessage() + "\n"
                + "Combustible ingresado: "
                + dato.getCombustible() + "\n\n"
            );
        } catch (CargaInvalidaException e) {
            DatoCargaInvalido dato = e.getDatoCargaInvalido();
            areaErrores.append(
                "CARGA INVALIDA\n"
                + e.getMessage() + "\n"
                + "Combustible: "
                + dato.getCombustible() + "\n"
                + "Cantidad requerida: "
                + dato.getCantidadRequerida() + "\n\n"
            );
        } catch (NumberFormatException e) {
            areaErrores.append("La cantidad debe ser un numero.\n\n");
        }
    }

    private void actualizarCantidades() {
        lblDiesel.setText(
            "Diesel: " + surtidor.getCantidadDiesel()
        );
        lblPremium.setText(
            "Premium: " + surtidor.getCantidadPremium()
        );
        lblSuper.setText(
            "Super: " + surtidor.getCantidadSuper()
        );
    }

    public static void main(String[] args) {
        new VentanaSurtidor();
    }
}