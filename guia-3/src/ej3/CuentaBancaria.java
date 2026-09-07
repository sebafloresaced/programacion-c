package ej3;

public abstract class CuentaBancaria {
    private String titular;
    private double saldo;
    public CuentaBancaria(String titular) {
        this.titular = titular;
        saldo = 0;
    }
    public String getTitular() {
        return titular;
    }
    public double getSaldo() {
        return saldo;
    }
    protected void descontarSaldo(double monto) {
        saldo -= monto;
    }
    public void depositar(double monto) {
        if (monto > 0) {
            saldo += monto;
        }
    }
    public abstract boolean extraer(double monto);
}
