
package ej4.vista;

import ej4.modelo.*;
import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class VentanaEstacion extends JFrame {
    private JTextField txtNombre, txtPrecio;
    private JTextField txtCapacidad, txtCantidad;
    private JComboBox<Combustible> cmbCombustibles;
    private JComboBox<Surtidor> cmbSurtidores;
    private JButton btnAgregarCombustible;
    private JButton btnModificarPrecio;
    private JButton btnAgregarSurtidor;
    private JButton btnAsignarCombustible;
    private JButton btnCargarLitros;
    private JButton btnCargarDinero;
    private JButton btnReponer;

    private JTable tabla;
    private DefaultTableModel modeloTabla;

    public VentanaEstacion() {
        setTitle("Estacion de Servicio");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        crearAdministracion();
        crearOperaciones();
        crearTabla();

        setSize(950, 650);
        setLocationRelativeTo(null);
    }

    private void crearAdministracion() {
        JPanel panel = new JPanel(new GridLayout(3, 3, 5, 5));

        panel.setBorder(BorderFactory.createTitledBorder("Administracion"));

        txtNombre = new JTextField();
        txtPrecio = new JTextField();

        btnAgregarCombustible = new JButton("Agregar combustible");
        btnModificarPrecio = new JButton("Modificar precio");
        btnAgregarSurtidor = new JButton("Agregar surtidor");
        btnAgregarCombustible.setActionCommand("AGREGAR_COMBUSTIBLE");
        btnModificarPrecio.setActionCommand("MODIFICAR_PRECIO");
        btnAgregarSurtidor.setActionCommand("AGREGAR_SURTIDOR");

        panel.add(new JLabel("Nombre:"));
        panel.add(txtNombre);
        panel.add(btnAgregarCombustible);

        panel.add(new JLabel("Precio por litro:"));
        panel.add(txtPrecio);
        panel.add(btnModificarPrecio);

        panel.add(new JLabel(""));
        panel.add(new JLabel(""));
        panel.add(btnAgregarSurtidor);

        add(panel, BorderLayout.NORTH);
    }

    private void crearOperaciones() {
        JPanel panel = new JPanel(new GridLayout(9, 1, 5, 5));

        panel.setBorder(BorderFactory.createTitledBorder("Operaciones"));

        cmbSurtidores = new JComboBox<>();
        cmbCombustibles = new JComboBox<>();

        // La seleccion permite actualizar el precio mostrado.
        cmbCombustibles.addActionListener(e -> {
            Combustible c =
                (Combustible) cmbCombustibles.getSelectedItem();

            if (c != null) {
                txtPrecio.setText(
                    String.valueOf(c.getPrecioUnidad()));
            }
        });

        txtCapacidad = new JTextField();
        txtCantidad = new JTextField();

        btnAsignarCombustible = new JButton("Asignar combustible");
        btnCargarLitros = new JButton("Cargar litros");
        btnCargarDinero = new JButton("Cargar dinero");
        btnReponer = new JButton("Reponer deposito");
        btnAsignarCombustible.setActionCommand("ASIGNAR_COMBUSTIBLE");
        btnCargarLitros.setActionCommand("CARGAR_LITROS");
        btnCargarDinero.setActionCommand("CARGAR_DINERO");
        btnReponer.setActionCommand("REPONER");

        panel.add(new JLabel("Surtidor:"));
        panel.add(cmbSurtidores);
        panel.add(new JLabel("Combustible:"));
        panel.add(cmbCombustibles);
        panel.add(new JLabel("Capacidad del deposito:"));
        panel.add(txtCapacidad);
        panel.add(new JLabel("Cantidad (litros o dinero):"));
        panel.add(txtCantidad);

        JPanel botones = new JPanel(new GridLayout(2, 2, 5, 5));

        botones.add(btnAsignarCombustible);
        botones.add(btnCargarLitros);
        botones.add(btnCargarDinero);
        botones.add(btnReponer);

        panel.add(botones);

        add(panel, BorderLayout.WEST);
    }

    private void crearTabla() {
        String[] columnas = {
            "Surtidor", "Combustible", "Precio",
            "Capacidad", "Disponible",
            "Ult. litros", "Ult. monto",
            "Hist. litros", "Hist. monto"
        };

        modeloTabla = new DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int fila, int columna) {
                return false;
            }
        };
        tabla = new JTable(modeloTabla);
        tabla.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tabla.setRowHeight(25);
        JScrollPane scroll = new JScrollPane(tabla);
        scroll.setBorder(BorderFactory.createTitledBorder("Estado de los surtidores"));
        add(scroll, BorderLayout.CENTER);
    }

    public void setControlador(ActionListener controlador) {
        btnAgregarCombustible.addActionListener(controlador);
        btnModificarPrecio.addActionListener(controlador);
        btnAgregarSurtidor.addActionListener(controlador);
        btnAsignarCombustible.addActionListener(controlador);
        btnCargarLitros.addActionListener(controlador);
        btnCargarDinero.addActionListener(controlador);
        btnReponer.addActionListener(controlador);
    }

    public String getNombreCombustible() {
        return txtNombre.getText().trim();
    }

    public double getPrecioCombustible() {
        return Double.parseDouble(txtPrecio.getText().trim());
    }

    public double getCapacidadDeposito() {
        return Double.parseDouble(txtCapacidad.getText().trim());
    }

    public double getCantidadCarga() {
        return Double.parseDouble(txtCantidad.getText().trim());
    }

    public Combustible getCombustibleSeleccionado() {
        return (Combustible) cmbCombustibles.getSelectedItem();
    }

    public Surtidor getSurtidorSeleccionado() {
        return (Surtidor) cmbSurtidores.getSelectedItem();
    }

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }

    public void actualizarDatos(EstacionServicio modelo) {
        Combustible seleccionado = getCombustibleSeleccionado();
        Surtidor surtidorSeleccionado = getSurtidorSeleccionado();
        cmbCombustibles.removeAllItems();
        cmbSurtidores.removeAllItems();
        for (Combustible c : modelo.getCombustibles()) {
            cmbCombustibles.addItem(c);
        }
        for (Surtidor s : modelo.getSurtidores()) {
            cmbSurtidores.addItem(s);
        }
        if (seleccionado != null) {
            cmbCombustibles.setSelectedItem(seleccionado);
        }
        if (surtidorSeleccionado != null) {
            cmbSurtidores.setSelectedItem(surtidorSeleccionado);
        }
        modeloTabla.setRowCount(0);
        for (Surtidor s : modelo.getSurtidores()) {
            for (DepositoCombustible d : s.getDepositos()) {
                Object[] fila = {
                    s.getNumero(),
                    d.getCombustible().getNombre(),
                    d.getCombustible().getPrecioUnidad(),
                    d.getCapacidadMaxima(),
                    d.getLitrosDisponibles(),
                    d.getCantidadUltimaCarga(),
                    d.getMontoUltimaCarga(),
                    d.getCantidadHistorica(),
                    d.getMontoHistorico()
                };
                modeloTabla.addRow(fila);
            }
        }
    }
}
