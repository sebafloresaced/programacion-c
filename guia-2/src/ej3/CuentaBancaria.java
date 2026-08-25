package ej3;

public class CuentaBancaria {
    private double saldo;
    private String titular;
    public CuentaBancaria(String titular) {
        super();
        this.titular = titular;
        this.saldo = 0;
    }
    public void depositar(double monto) {
        if (monto > 0) {
            saldo += monto;
        }
    }
    public boolean extraer(double monto) {
        if (monto > 0 && saldo >= monto) {
            saldo -= monto;
            return true;
        }
        else {
            return false;
        }
    }
    public double getSaldo() {
        return saldo;
    }
    public String getTitular() {
        return titular;
    }
}
