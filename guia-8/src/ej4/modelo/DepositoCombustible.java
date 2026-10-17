package ej4.modelo;

import ej4.modelo.FaltaCombustibleException;

public class DepositoCombustible {
    private Combustible combustible;
    private double capacidadMaxima;
    private double litrosDisponibles;
    private double cantidadUltimaCarga;
    private double montoUltimaCarga;
    private double cantidadHistorica;
    private double montoHistorico;

    public DepositoCombustible(Combustible combustible, double capacidadMaxima) {
        if (combustible == null || capacidadMaxima <= 0) {
            throw new IllegalArgumentException(
                "Parametros invalidos");
        }
        this.combustible = combustible;
        this.capacidadMaxima = capacidadMaxima;
        litrosDisponibles = capacidadMaxima;
        cantidadUltimaCarga = 0;
        montoUltimaCarga = 0;
        cantidadHistorica = 0;
        montoHistorico = 0;
    }

    public void reponer() {
        litrosDisponibles = capacidadMaxima;
    }

    public double cargarPorLitros(double litros) throws FaltaCombustibleException, Exception {
        if (litros < 0) {
            throw new Exception("La cantidad de combustible debe ser positiva");
        }
        double litrosCargados = Math.min(litros, litrosDisponibles);
        double monto = litrosCargados * combustible.getPrecioUnidad();
        registrarCarga(litrosCargados, monto);
        litrosDisponibles -= litrosCargados;
        if (litrosCargados < litros) {
            DatoCargaInvalida datos = new DatoCargaInvalida(combustible, litros, litrosCargados, monto);
            throw new FaltaCombustibleException(datos);
        }
        return monto;
    }

    public double cargarPorDinero(double dinero) throws FaltaCombustibleException, Exception {
        if (dinero < 0) {
            throw new Exception("La cantidad de combustible debe ser positiva");
        }
        double litrosSolicitados = dinero / combustible.getPrecioUnidad();
        return cargarPorLitros(litrosSolicitados);
    }

    private void registrarCarga(double litros, double monto) {
        cantidadUltimaCarga = litros;
        montoUltimaCarga = monto;
        cantidadHistorica += litros;
        montoHistorico += monto;
    }

    public Combustible getCombustible() {
        return combustible;
    }

    public double getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public double getLitrosDisponibles() {
        return litrosDisponibles;
    }

    public double getCantidadUltimaCarga() {
        return cantidadUltimaCarga;
    }

    public double getMontoUltimaCarga() {
        return montoUltimaCarga;
    }

    public double getCantidadHistorica() {
        return cantidadHistorica;
    }

    public double getMontoHistorico() {
        return montoHistorico;
    }
}