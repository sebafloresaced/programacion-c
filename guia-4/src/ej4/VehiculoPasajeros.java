package ej4;

public class VehiculoPasajeros extends Vehiculo {
    private int plazas;
    /*
     * Crea un vehículo para transporte de pasajeros.
     *
     * Pre: patente no es null ni vacía.
     * Pre: plazas > 0.
     * Post: se crea el vehículo con la patente y cantidad
     *       de plazas indicadas.
    */
    public VehiculoPasajeros(String patente, int plazas) {
        super(patente);
        this.plazas = plazas;
    }
    /*
     * Retorna la cantidad de plazas.
     *
     * Pre: ninguna.
     * Post: retorna una cantidad mayor a 0.
    */
    public int getPlazas() {
        return plazas;
    }
    /*
     * Calcula un precio diario incrementado según
     * un porcentaje por plaza.
     *
     * Pre: dias > 0.
     * Pre: porcentaje >= 0.
     * Post: retorna el precio correspondiente.
    */
    protected double calcularPrecioPorPlazas(int dias, double porcentaje) {
        return precioBase * dias * (1 + porcentaje * plazas);
    }
}