package ej4;

public class VehiculoCarga extends Vehiculo {
    private double pma;
    /*
     * Crea un vehículo de carga.
     *
     * Pre: patente no es null ni vacía.
     * Pre: pma > 0.
     * Post: se crea el vehículo con la patente y PMA indicados.
    */
    public VehiculoCarga(String patente, double pma) {
        super(patente);
        this.pma = pma;
    }
    /*
     * Retorna el peso máximo autorizado.
     *
     * Pre: ninguna.
     * Post: retorna un valor mayor a 0.
    */
    public double getPma() {
        return pma;
    }
    /*
     * Calcula el precio de alquiler de un vehículo de carga.
     *
     * Pre: dias > 0.
     * Post: retorna el precio base diario incrementado
     *       un 20% por cada tonelada de PMA.
    */
    @Override
    public double calcularAlquiler(int dias) {
        return precioBase * dias * (1 + 0.20 * pma);
    }
}