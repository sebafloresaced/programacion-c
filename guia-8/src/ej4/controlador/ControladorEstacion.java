package ej4.controlador;

import ej4.modelo.*;
import ej4.modelo.FaltaCombustibleException;
import ej4.vista.VentanaEstacion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorEstacion implements ActionListener {
    private EstacionServicio modelo;
    private VentanaEstacion vista;

    public ControladorEstacion(EstacionServicio modelo, VentanaEstacion vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        try {
            switch (comando) {
                case "AGREGAR_COMBUSTIBLE":
                    agregarCombustible();
                    break;
                case "MODIFICAR_PRECIO":
                    modificarPrecio();
                    break;
                case "AGREGAR_SURTIDOR":
                    agregarSurtidor();
                    break;
                case "ASIGNAR_COMBUSTIBLE":
                    asignarCombustible();
                    break;
                case "CARGAR_LITROS":
                    cargarPorLitros();
                    break;
                case "CARGAR_DINERO":
                    cargarPorDinero();
                    break;
                case "REPONER":
                    reponerCombustible();
                    break;
            }
        } catch (FaltaCombustibleException ex) {
            DatoCargaInvalida datos = ex.getDatosCarga();
            vista.mostrarMensaje(
                "No habia suficiente combustible.\n" +
                "Litros solicitados: " +
                datos.getLitrosSolicitados() + "\n" +
                "Litros cargados: " +
                datos.getLitrosCargados() + "\n" +
                "Monto cobrado: $" +
                datos.getMontoCargado()
            );
            vista.actualizarDatos(modelo);
        } catch (Exception ex) {
            vista.mostrarMensaje(ex.getMessage());
        }
    }

    private void agregarCombustible() {
        String nombre = vista.getNombreCombustible();
        double precio = vista.getPrecioCombustible();
        modelo.agregarCombustible(nombre, precio);
        vista.actualizarDatos(modelo);
    }

    private void modificarPrecio() {
        Combustible combustible = vista.getCombustibleSeleccionado();
        double precio = vista.getPrecioCombustible();
        if (combustible == null) {
            throw new IllegalArgumentException("Debe seleccionar un combustible");
        }
        modelo.modificarPrecio(combustible.getNombre(), precio);
        vista.actualizarDatos(modelo);
    }

    private void agregarSurtidor() {
        modelo.agregarSurtidor();
        vista.actualizarDatos(modelo);
    }

    private void asignarCombustible() {
        Surtidor surtidor = vista.getSurtidorSeleccionado();
        Combustible combustible = vista.getCombustibleSeleccionado();
        double capacidad = vista.getCapacidadDeposito();
        if (surtidor == null || combustible == null) {
            throw new IllegalArgumentException("Seleccione un surtidor y un combustible");
        }
        surtidor.agregarCombustible(combustible, capacidad);
        vista.actualizarDatos(modelo);
    }

    private void cargarPorLitros() throws Exception {
        Surtidor surtidor = vista.getSurtidorSeleccionado();
        Combustible combustible = vista.getCombustibleSeleccionado();
        double litros = vista.getCantidadCarga();
        validarSeleccion(surtidor, combustible);
        double monto = surtidor.cargarPorLitros(combustible, litros);
        vista.actualizarDatos(modelo);
        vista.mostrarMensaje("Carga realizada.\nMonto: $" + monto);
    }

    private void cargarPorDinero() throws Exception {
        Surtidor surtidor = vista.getSurtidorSeleccionado();
        Combustible combustible = vista.getCombustibleSeleccionado();
        double dinero = vista.getCantidadCarga();
        validarSeleccion(surtidor, combustible);
        double monto = surtidor.cargarPorDinero(combustible, dinero);
        vista.actualizarDatos(modelo);
        vista.mostrarMensaje("Carga realizada.\nMonto: $" + monto);
    }

    private void reponerCombustible() {
        Surtidor surtidor = vista.getSurtidorSeleccionado();
        Combustible combustible = vista.getCombustibleSeleccionado();
        validarSeleccion(surtidor, combustible);
        surtidor.reponerCombustible(combustible);
        vista.actualizarDatos(modelo);
    }

    private void validarSeleccion(Surtidor surtidor, Combustible combustible) {
        if (surtidor == null || combustible == null) {
            throw new IllegalArgumentException("Seleccione un surtidor y un combustible");
        }
    }
}
