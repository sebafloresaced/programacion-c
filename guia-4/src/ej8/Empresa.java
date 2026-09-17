package ej8;

import java.util.ArrayList;

public class Empresa {
    private ArrayList<Chofer> choferes;
    private ArrayList<Vehiculo> vehiculos;
    private ArrayList<Acoplado> acoplados;

    public Empresa() {
        choferes = new ArrayList<>();
        vehiculos = new ArrayList<>();
        acoplados = new ArrayList<>();
    }
    public void agregarChofer(Chofer chofer) {
        choferes.add(chofer);
    }
    public void agregarVehiculo(Vehiculo vehiculo) {
        vehiculos.add(vehiculo);
    }
    public void agregarAcoplado(Acoplado acoplado) {
        acoplados.add(acoplado);
    }
    public int cantidadChoferesCategoria(Categoria categoria) {
        int cantidad = 0;
        for (Chofer chofer : choferes) {
            if (chofer.getCategoria() == categoria) {
                cantidad++;
            }
        }
        return cantidad;
    }
    public int cantidadChoferesSinVehiculo() {
        int cantidad = 0;
        for (Chofer chofer : choferes) {
            if (chofer.getVehiculoAsignado() == null) {
                cantidad++;
            }
        }
        return cantidad;
    }
    public int cantidadVehiculos() {
        return vehiculos.size();
    }
    public int cantidadAcoplados() {
        return acoplados.size();
    }
    private boolean vehiculoEstaAsignado(Vehiculo vehiculo) {
        for (Chofer chofer : choferes) {
            if (chofer.getVehiculoAsignado() == vehiculo) {
                return true;
            }
        }
        return false;
    }
    public boolean vincularChoferVehiculo(Chofer chofer, Vehiculo vehiculo) {
        if (vehiculoEstaAsignado(vehiculo)) {
            return false;
        }
        return chofer.asignarVehiculo(vehiculo);
    }
    public void desvincularChoferVehiculo(Chofer chofer) {
        chofer.desvincularVehiculo();
    }
    public void mostrarChoferes() {
        for (Chofer chofer : choferes) {
            System.out.println(chofer);
        }
    }
    public void mostrarVehiculos() {
        for (Vehiculo vehiculo : vehiculos) {
            System.out.println(vehiculo);
        }
    }
    public void mostrarAcoplados() {
        for (Acoplado acoplado : acoplados) {
            System.out.println(acoplado);
        }
    }
}