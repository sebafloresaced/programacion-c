package ej2;

import java.awt.*;
import javax.swing.*;
import java.util.GregorianCalendar;

public class VentanaEmergencias extends JFrame {
    private ListaConPrioridades<Llamado> lista;
    private JTextField txtDni;
    private JTextField txtNombre;
    private JTextField txtDomicilio;
    private JTextField txtPrioridad;
    private JTextArea txtResultado;
    private JLabel lblCantidad;

    public VentanaEmergencias() {
        lista = new ListaConPrioridades<>();

        setTitle("Sistema de Emergencias");
        setSize(550, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // Panel de ingreso de datos
        JPanel panelDatos = new JPanel(new GridLayout(4, 2, 5, 5));

        txtDni = new JTextField();
        txtNombre = new JTextField();
        txtDomicilio = new JTextField();
        txtPrioridad = new JTextField();

        panelDatos.add(new JLabel("DNI:"));
        panelDatos.add(txtDni);

        panelDatos.add(new JLabel("Nombre:"));
        panelDatos.add(txtNombre);

        panelDatos.add(new JLabel("Domicilio:"));
        panelDatos.add(txtDomicilio);

        panelDatos.add(new JLabel("Prioridad:"));
        panelDatos.add(txtPrioridad);

        add(panelDatos, BorderLayout.NORTH);

        // Panel central
        txtResultado = new JTextArea();
        txtResultado.setEditable(false);

        add(new JScrollPane(txtResultado), BorderLayout.CENTER);

        // Panel de botones
        JPanel panelInferior = new JPanel(new BorderLayout());

        JPanel panelBotones = new JPanel(new GridLayout(1, 3, 5, 5));

        JButton btnAgregar = new JButton("Agregar llamado");
        JButton btnConsultar = new JButton("Consultar próximo");
        JButton btnAtender = new JButton("Atender llamado");

        panelBotones.add(btnAgregar);
        panelBotones.add(btnConsultar);
        panelBotones.add(btnAtender);

        panelInferior.add(panelBotones, BorderLayout.CENTER);

        lblCantidad = new JLabel("Llamados pendientes: 0");
        panelInferior.add(lblCantidad, BorderLayout.SOUTH);

        add(panelInferior, BorderLayout.SOUTH);

        // Eventos
        btnAgregar.addActionListener(e -> agregarLlamado());
        btnConsultar.addActionListener(e -> consultarLlamado());
        btnAtender.addActionListener(e -> atenderLlamado());
    }

    private void agregarLlamado() {
        try {
            int dni = Integer.parseInt(txtDni.getText().trim());
            int prioridad = Integer.parseInt(txtPrioridad.getText().trim());
            String nombre = txtNombre.getText().trim();
            String domicilio = txtDomicilio.getText().trim();

            if (dni <= 0 || nombre.isEmpty() || domicilio.isEmpty() || prioridad < 0) {
                JOptionPane.showMessageDialog(this, "Ingrese datos válidos");
                return;
            }

            Socio socio = new Socio(dni, nombre, domicilio);
            Llamado llamado = new Llamado(prioridad, socio);
           
            lista.agregar(llamado);
            txtResultado.setText("Llamado agregado:\n" + llamado);

            txtDni.setText("");
            txtNombre.setText("");
            txtDomicilio.setText("");
            txtPrioridad.setText("");

            actualizarCantidad();

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "DNI y prioridad deben ser números enteros");
        }
    }

    private void consultarLlamado() {
        Llamado llamado = lista.consultarElemento();
        if (llamado == null) {
            txtResultado.setText("No hay llamados pendientes");
        } else {
            txtResultado.setText("Próximo llamado:\n" + llamado);
        }
    }

    private void atenderLlamado() {
        Llamado llamado = lista.getElemento();
        if (llamado == null) {
            txtResultado.setText("No hay llamados pendientes");
        } else {
            llamado.setFechahoraAtendido(new GregorianCalendar());
            txtResultado.setText("Llamado atendido:\n" + llamado);
        }
        actualizarCantidad();
    }

    private void actualizarCantidad() {
        lblCantidad.setText("Llamados pendientes: " + lista.getCantidad());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new VentanaEmergencias().setVisible(true);
        });
    }
}