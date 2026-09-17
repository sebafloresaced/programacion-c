package ej8;

public class Chofer {
    private String nombre;
    private Categoria categoria;
    private Domicilio domicilio;
    private Vehiculo vehiculoAsignado;

    public Chofer(String nombre, Categoria categoria, Domicilio domicilio) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.domicilio = domicilio;
        vehiculoAsignado = null;
    }
    public String getNombre() {
        return nombre;
    }
    public Categoria getCategoria() {
        return categoria;
    }
    public Vehiculo getVehiculoAsignado() {
        return vehiculoAsignado;
    }
    public Domicilio getDomicilio() {
        return domicilio;
    }
    public boolean asignarVehiculo(Vehiculo vehiculo) {
        if (vehiculoAsignado == null &&
            vehiculo != null &&
            vehiculo.aceptoChofer(this)) {

            vehiculoAsignado = vehiculo;
            return true;
        }
        return false;
    }
    public void desvincularVehiculo() {
        vehiculoAsignado = null;
    }
    @Override
    public String toString() {
        String resultado =
            "Chofer: " + nombre +
            " - Categoria: " + categoria.getNombreCategoria() +
            " - Domicilio: " + domicilio;
        if (vehiculoAsignado == null) {
            resultado += " - Sin vehiculo asignado";
        } else {
            resultado += "\nVehiculo: " + vehiculoAsignado;
        }
        return resultado;
    }
}
