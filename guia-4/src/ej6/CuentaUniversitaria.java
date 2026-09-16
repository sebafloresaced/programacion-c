package ej6;

public class CuentaUniversitaria extends CuentaBancaria {
    private static final double MAXIMO_DIARIO = 1000;
    private double extraidoHoy;
    public CuentaUniversitaria(String titular) {
        super(titular);
        extraidoHoy = 0;
    }
    @Override
    protected boolean validaExtraccion(double monto) {
        return extraidoHoy + monto <= MAXIMO_DIARIO;
    }
    @Override
    protected void extraccionRealizada(double monto) {
        extraidoHoy += monto;
    }
}