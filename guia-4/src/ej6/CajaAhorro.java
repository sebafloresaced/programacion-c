package ej6;

public class CajaAhorro extends CuentaBancaria {
    private static int maxExtraccionesMensuales = 5;
    private int extraccionesRealizadas;
    public CajaAhorro(String titular) {
        super(titular);
        extraccionesRealizadas = 0;
    }
    @Override
    protected boolean validaExtraccion(double monto) {
        return monto <= saldo && extraccionesRealizadas < maxExtraccionesMensuales;
    }
    @Override
    protected void extraccionRealizada(double monto) {
        extraccionesRealizadas++;
    }
}