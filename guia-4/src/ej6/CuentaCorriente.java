package ej6;

public class CuentaCorriente extends CuentaBancaria {
    private double topeDescubierto;
    public CuentaCorriente(String titular, double topeDescubierto) {
        super(titular);
        this.topeDescubierto = topeDescubierto;
    }
    public double getTopeDescubierto() {
        return topeDescubierto;
    }
    public void setTopeDescubierto(double topeDescubierto) {
        this.topeDescubierto = topeDescubierto;
    }
    @Override
    protected boolean validaExtraccion(double monto) {
        return saldo - monto >= -topeDescubierto;
    }
}