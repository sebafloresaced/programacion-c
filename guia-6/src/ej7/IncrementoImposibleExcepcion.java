package ej7;

public class IncrementoImposibleExcepcion extends Exception {
    private double maxDistanciaSoportada, distanciaPretendida;
    
    public IncrementoImposibleExcepcion(double distanciaPretendida, double maxDistanciaSoportada) {
        this.maxDistanciaSoportada = maxDistanciaSoportada;
        this.distanciaPretendida = distanciaPretendida;
    }
    public double getMaxDistanciaSoportada() {
        return maxDistanciaSoportada;
    }
    public double getDistanciaPretendida() {
        return distanciaPretendida;
    }
}
