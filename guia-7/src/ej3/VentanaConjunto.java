package ej3;

import ej1.Persona;
import java.awt.*;
import java.util.Iterator;
import javax.swing.*;
import javax.swing.SwingUtilities;

public class VentanaConjunto extends JFrame {
    private ConjuntoGenerico<Persona> personas;
    private JTextField txtApellido;
    private JTextField txtNombre;
    private JTextField txtDireccion;
    private JTextArea txtResultado;
    private JLabel lblCantidad;
    
    public VentanaConjunto() {
        personas = new ConjuntoGenerico<Persona>();
        
        setTitle("Sistema de Gestion de Personas");
        setSize(550, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));
        
        // Panel de ingreso de datos
        JPanel panelDatos = new JPanel(new GridLayout(4, 2, 5, 5));

        txtApellido = new JTextField();
        txtNombre = new JTextField();
        txtDireccion = new JTextField();

        panelDatos.add(new JLabel("Apellido:"));
        panelDatos.add(txtApellido);

        panelDatos.add(new JLabel("Nombre:"));
        panelDatos.add(txtNombre);

        panelDatos.add(new JLabel("Direccion:"));
        panelDatos.add(txtDireccion);

        add(panelDatos, BorderLayout.NORTH);
        
        // Panel central
        txtResultado = new JTextArea();
        txtResultado.setEditable(false);

        add(new JScrollPane(txtResultado), BorderLayout.CENTER);

        // Panel de botones
        JPanel panelInferior = new JPanel(new BorderLayout());

        JPanel panelBotones = new JPanel(new GridLayout(1, 3, 5, 5));

        JButton btnAgregar = new JButton("Agregar persona");
        JButton btnConsultar = new JButton("Consultar personas");
        JButton btnEliminar = new JButton("Eliminar persona");

        panelBotones.add(btnAgregar);
        panelBotones.add(btnConsultar);
        panelBotones.add(btnEliminar);

        panelInferior.add(panelBotones, BorderLayout.CENTER);

        lblCantidad = new JLabel("Cantidad de personas: 0");
        panelInferior.add(lblCantidad, BorderLayout.SOUTH);

        add(panelInferior, BorderLayout.SOUTH);

        // Eventos
        btnAgregar.addActionListener(e -> agregarPersona());
        btnConsultar.addActionListener(e -> consultarPersonas());
        btnEliminar.addActionListener(e -> eliminarPersona());
    }
    
    private void agregarPersona() {
        try {
            String apellido = txtApellido.getText().trim();
            String direccion = txtDireccion.getText().trim();
            String nombre = txtNombre.getText().trim();
            
            if (nombre.isEmpty() || apellido.isEmpty() || direccion.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Ingrese datos no vacios");
                return;
            }
            
            Persona p = new Persona(nombre,apellido,direccion);
            personas.agrega(p);
            txtResultado.setText("Persona agregada:\n" + p);
            
            txtNombre.setText("");
            txtApellido.setText("");
            txtDireccion.setText("");

            actualizarCantidad();
        }
        catch (OperacionConjuntosException e) {
            txtResultado.setText("Error: " + e.getMessage());
        }
    }
    
    private void consultarPersonas() {
        Iterator<Persona> i = personas.getIterator();
        String res = "";
        Persona p;
        
        while (i.hasNext()) {
            p = i.next();
            res += p.toString() + "\n";
        }
        
        txtResultado.setText(res);
    }
    
    private void eliminarPersona() {
        try {
            String apellido = txtApellido.getText().trim();
            String direccion = txtDireccion.getText().trim();
            String nombre = txtNombre.getText().trim();
            
            if (nombre.isEmpty() || apellido.isEmpty() || direccion.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Ingrese datos no vacios");
                return;
            }
            
            Persona p = new Persona(nombre,apellido,direccion);
            personas.elimina(p);
            txtResultado.setText("Persona eliminada:\n" + p);
            
            txtNombre.setText("");
            txtApellido.setText("");
            txtDireccion.setText("");

            actualizarCantidad();
        }
        catch (OperacionConjuntosException e) {
            txtResultado.setText("Error: " + e.getMessage());
        }
    }
    
    private void actualizarCantidad() {
        lblCantidad.setText("Cantidad de personas: " + personas.getCardinal());
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new VentanaConjunto().setVisible(true);
        });
    }
    
}
