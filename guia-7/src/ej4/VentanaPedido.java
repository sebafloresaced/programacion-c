package ej4;

import ej3.OperacionConjuntosException;

import java.awt.*;
import java.util.Iterator;
import javax.swing.*;

public class VentanaPedido extends JFrame {
    private Pedido pedido;

    // Datos del empleado
    private JTextField txtLegajo;
    private JTextField txtEmpleadoNombre;
    private JTextField txtEmpleadoApellido;

    // Datos del producto
    private JTextField txtCodigo;
    private JTextField txtDescripcion;
    private JTextField txtPrecio;
    private JTextField txtCantidad;

    // Resultados
    private JTextArea txtResultado;
    private JLabel lblTotal;
    private JLabel lblCantidad;

    public VentanaPedido() {

        setTitle("Sistema de Pedidos");
        setSize(700, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // PANEL EMPLEADO
        JPanel panelEmpleado = new JPanel(new GridLayout(4, 2, 5, 5));
        panelEmpleado.setBorder(
            BorderFactory.createTitledBorder("Empleado responsable")
        );

        txtLegajo = new JTextField();
        txtEmpleadoNombre = new JTextField();
        txtEmpleadoApellido = new JTextField();

        panelEmpleado.add(new JLabel("Legajo:"));
        panelEmpleado.add(txtLegajo);

        panelEmpleado.add(new JLabel("Nombre:"));
        panelEmpleado.add(txtEmpleadoNombre);

        panelEmpleado.add(new JLabel("Apellido:"));
        panelEmpleado.add(txtEmpleadoApellido);

        JButton btnCrearPedido = new JButton("Crear pedido");
        panelEmpleado.add(btnCrearPedido);

        // PANEL PRODUCTO
        JPanel panelProducto = new JPanel(new GridLayout(4, 2, 5, 5));
        panelProducto.setBorder(
            BorderFactory.createTitledBorder("Producto")
        );

        txtCodigo = new JTextField();
        txtDescripcion = new JTextField();
        txtPrecio = new JTextField();
        txtCantidad = new JTextField();

        panelProducto.add(new JLabel("Codigo:"));
        panelProducto.add(txtCodigo);

        panelProducto.add(new JLabel("Descripcion:"));
        panelProducto.add(txtDescripcion);

        panelProducto.add(new JLabel("Precio unitario:"));
        panelProducto.add(txtPrecio);

        panelProducto.add(new JLabel("Cantidad:"));
        panelProducto.add(txtCantidad);

        // PANEL SUPERIOR
        JPanel panelSuperior = new JPanel(new GridLayout(2, 1, 5, 5));
        panelSuperior.add(panelEmpleado);
        panelSuperior.add(panelProducto);

        add(panelSuperior, BorderLayout.NORTH);

        // PANEL CENTRAL
        txtResultado = new JTextArea();
        txtResultado.setEditable(false);

        add(new JScrollPane(txtResultado), BorderLayout.CENTER);

        // PANEL INFERIOR
        JPanel panelInferior = new JPanel(new BorderLayout());

        JPanel panelBotones = new JPanel(new GridLayout(1, 4, 5, 5));

        JButton btnAgregar = new JButton("Agregar producto");
        JButton btnEliminar = new JButton("Eliminar producto");
        JButton btnConsultar = new JButton("Consultar pedido");
        JButton btnCalcular = new JButton("Calcular total");

        panelBotones.add(btnAgregar);
        panelBotones.add(btnEliminar);
        panelBotones.add(btnConsultar);
        panelBotones.add(btnCalcular);

        panelInferior.add(panelBotones, BorderLayout.CENTER);

        JPanel panelInfo = new JPanel(new GridLayout(2, 1));

        lblCantidad = new JLabel("Lineas de pedido: 0");
        lblTotal = new JLabel("Total: $0.00");

        panelInfo.add(lblCantidad);
        panelInfo.add(lblTotal);

        panelInferior.add(panelInfo, BorderLayout.SOUTH);

        add(panelInferior, BorderLayout.SOUTH);

        // EVENTOS
        btnCrearPedido.addActionListener(e -> crearPedido());
        btnAgregar.addActionListener(e -> agregarProducto());
        btnEliminar.addActionListener(e -> eliminarProducto());
        btnConsultar.addActionListener(e -> consultarPedido());
        btnCalcular.addActionListener(e -> calcularTotal());
    }

    private void crearPedido() {
        try {
            int legajo = Integer.parseInt(txtLegajo.getText().trim());
            String nombre = txtEmpleadoNombre.getText().trim();
            String apellido = txtEmpleadoApellido.getText().trim();

            if (legajo <= 0 || nombre.isEmpty() || apellido.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                    "Ingrese datos validos del empleado");
                return;
            }

            Empleado empleado = new Empleado(legajo, nombre, apellido);
            pedido = new Pedido(empleado);

            txtResultado.setText(
                "Pedido creado correctamente\n" +
                "Empleado: " + empleado
            );

            actualizarInformacion();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                "El legajo debe ser un numero entero");
        }
    }

    private void agregarProducto() {
        if (pedido == null) {
            JOptionPane.showMessageDialog(this,
                "Primero debe crear un pedido");
            return;
        }

        try {
            int codigo = Integer.parseInt(txtCodigo.getText().trim());
            String descripcion = txtDescripcion.getText().trim();
            double precio = Double.parseDouble(txtPrecio.getText().trim());
            int cantidad = Integer.parseInt(txtCantidad.getText().trim());

            if (codigo <= 0 || descripcion.isEmpty() ||
                precio < 0 || !Double.isFinite(precio) ||
                cantidad <= 0) {

                JOptionPane.showMessageDialog(this,
                    "Ingrese datos validos del producto");
                return;
            }

            Producto producto =
                new Producto(descripcion, codigo, precio);

            LineaDePedido linea =
                new LineaDePedido(cantidad, producto);

            pedido.agrega(linea);

            txtResultado.setText(
                "Producto agregado correctamente:\n" + linea
            );

            limpiarProducto();
            actualizarInformacion();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                "Verifique los datos numericos");
        } catch (OperacionConjuntosException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }

    private void eliminarProducto() {
        if (pedido == null) {
            JOptionPane.showMessageDialog(this,
                "Primero debe crear un pedido");
            return;
        }

        try {
            int codigo = Integer.parseInt(txtCodigo.getText().trim());

            // La igualdad de LineaDePedido depende del codigo
            Producto producto = new Producto("", codigo, 0);
            LineaDePedido linea = new LineaDePedido(0, producto);

            pedido.elimina(linea);

            txtResultado.setText(
                "Producto eliminado. Codigo: " + codigo
            );

            limpiarProducto();
            actualizarInformacion();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                "Ingrese un codigo numerico valido");
        } catch (OperacionConjuntosException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }

    private void consultarPedido() {
        if (pedido == null) {
            JOptionPane.showMessageDialog(this,
                "Primero debe crear un pedido");
            return;
        }

        String resultado = "DETALLE DEL PEDIDO\n\n";

        resultado += "Empleado: " + pedido.getEmpleado() + "\n";
        resultado += "Fecha: " + pedido.getFecha().getTime() + "\n\n";

        Iterator<LineaDePedido> it = pedido.getIterator();

        while (it.hasNext()) {
            LineaDePedido linea = it.next();
            resultado += linea + "\n";
        }

        resultado += "\nTotal: $" + pedido.getPrecioTotal();

        txtResultado.setText(resultado);
    }

    private void calcularTotal() {
        if (pedido == null) {
            JOptionPane.showMessageDialog(this,
                "Primero debe crear un pedido");
            return;
        }

        txtResultado.setText(
            "Precio total del pedido: $" + pedido.getPrecioTotal()
        );

        actualizarInformacion();
    }

    private void actualizarInformacion() {
        if (pedido != null) {
            lblCantidad.setText(
                "Lineas de pedido: " + pedido.getCardinal()
            );

            lblTotal.setText(
                String.format("Total: $%.2f", pedido.getPrecioTotal())
            );
        }
    }

    private void limpiarProducto() {
        txtCodigo.setText("");
        txtDescripcion.setText("");
        txtPrecio.setText("");
        txtCantidad.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new VentanaPedido().setVisible(true);
        });
    }
}