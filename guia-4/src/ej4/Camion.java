package ej4;

public class Camion extends VehiculoCarga {
    public Camion(String patente, double pma) {
        super(patente, pma);
    }
    /*
     * Calcula el precio de alquiler de un camión.
     *
     * Pre: dias > 0.
     * Post: retorna el precio correspondiente a un vehículo
     *       de carga más un adicional fijo del 40%
     *       del precio base.
    */
    @Override
    public double calcularAlquiler(int dias) {
        double precioCarga = super.calcularAlquiler(dias);
        double adicional = precioBase * 0.40;
        return precioCarga + adicional;
    }
}