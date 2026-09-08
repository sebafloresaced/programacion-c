package ej4;

public class Vehiculo {
    private String patente;
    protected static double precioBase = 500;
    /*
     * Crea un vehículo.
     *
     * Pre: patente no es null ni vacía.
     * Post: se crea un vehículo con la patente indicada.
    */
    public Vehiculo(String patente) {
        this.patente = patente;
    }

    /*
     * Retorna la patente del vehículo.
     *
     * Pre: ninguna.
     * Post: retorna la patente del vehículo.
    */
    public String getPatente() {
        return patente;
    }
    /*
     * Calcula el precio de alquiler.
     *
     * Pre: dias > 0.
     * Post: retorna el precio de alquiler del vehículo
     *       para la cantidad de días indicada.
     */
    public double calcularAlquiler(int dias) {
        return precioBase * dias;
    }
}