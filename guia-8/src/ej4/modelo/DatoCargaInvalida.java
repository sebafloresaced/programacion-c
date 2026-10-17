package ej4.modelo;

public class DatoCargaInvalida {
    private Combustible combustible;
    private double litrosSolicitados;
    private double litrosCargados;
    private double montoCargado;

    public DatoCargaInvalida(Combustible combustible, double litrosSolicitados, double litrosCargados, double montoCargado) {
        this.combustible = combustible;
        this.litrosSolicitados = litrosSolicitados;
        this.litrosCargados = litrosCargados;
        this.montoCargado = montoCargado;
    }

    public Combustible getCombustible() {
        return combustible;
    }

    public double getLitrosSolicitados() {
        return litrosSolicitados;
    }

    public double getLitrosCargados() {
        return litrosCargados;
    }

    public double getMontoCargado() {
        return montoCargado;
    }
}
