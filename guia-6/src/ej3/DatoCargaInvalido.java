package ej3;

public class DatoCargaInvalido {
    private double cantidadDisponible;
    private double cantidadRequerida;
    private String combustible;
    
    public DatoCargaInvalido(String combustible, double cantidadRequerida, double cantidadDisponible) {
        this.combustible = combustible;
        this.cantidadDisponible = cantidadDisponible;
        this.cantidadRequerida = cantidadRequerida;
    }
    public double getCantidadDisponible() {
        return cantidadDisponible;
    }
    public double getCantidadRequerida() {
        return cantidadRequerida;
    }
    public String getCombustible() {
        return combustible;
    }
}
