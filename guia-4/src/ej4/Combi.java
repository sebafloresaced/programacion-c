package ej4;

public class Combi extends VehiculoPasajeros {
    public Combi(String patente, int plazas) {
        super(patente, plazas);
    }
    /*
     * Calcula el precio de alquiler de una combi.
     *
     * Pre: dias > 0.
     * Post: retorna el precio equivalente al de un auto
     *       más un 2% del precio base por plaza,
     *       agregado una sola vez independientemente
     *       de la cantidad de días.
    */
    @Override
    public double calcularAlquiler(int dias) {
        double precioComoAuto = calcularPrecioPorPlazas(dias, 0.015);
        double adicional = precioBase * 0.02 * getPlazas();
        return precioComoAuto + adicional;
    }
}