package ej6;

public abstract class CuentaBancaria {
    private String titular;
    protected double saldo;
    public CuentaBancaria(String titular) {
        this.titular = titular;
        this.saldo = 0;
    }
    public String getTitular() {
        return titular;
    }
    public double getSaldo() {
        return saldo;
    }
    public void depositar(double monto) {
        saldo += monto;
    }
    public boolean extraer(double monto) {
        if (validaExtraccion(monto)) {
            saldo -= monto;
            extraccionRealizada(monto);
            return true;
        }
        return false;
    }
    protected abstract boolean validaExtraccion(double monto);
    protected void extraccionRealizada(double monto) { // hook para CajaAhorro
    }
}