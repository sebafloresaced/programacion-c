package ej4.modelo;

public class Combustible {
    private String nombre;
    private double precioUnidad;

    public Combustible(String nombre, double precioUnidad) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacio");
        }
        if (precioUnidad <= 0) {
            throw new IllegalArgumentException("El precio debe ser positivo");
        }
        this.nombre = nombre;
        this.precioUnidad = precioUnidad;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecioUnidad() {
        return precioUnidad;
    }

    public void setPrecioUnidad(double precioUnidad) {
        if (precioUnidad <= 0) {
            throw new IllegalArgumentException("El precio debe ser positivo");
        }
        this.precioUnidad = precioUnidad;
    }

    @Override
    public String toString() {
        return nombre + " ($" + precioUnidad + "/litro)";
    }
}