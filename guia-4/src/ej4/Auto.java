package ej4;

public class Auto extends VehiculoPasajeros {
    public Auto(String patente, int plazas) {
        super(patente, plazas);
    }
    /*
     * Calcula el precio de alquiler de un auto.
     *
     * Pre: dias > 0.
     * Post: retorna el precio base diario incrementado
     *       un 1,5% por plaza, multiplicado por los días.
    */
    @Override
    public double calcularAlquiler(int dias) {
        return calcularPrecioPorPlazas(dias, 0.015);
    }
}