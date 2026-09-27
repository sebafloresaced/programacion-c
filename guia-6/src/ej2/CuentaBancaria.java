package ej2;

public class CuentaBancaria {
    private double saldo;
    private String titular;
    
    public CuentaBancaria(String titular) {
        this.titular = titular;
    }
    public void depositar(double cantidad) throws DepositoInvalidoException {
        if (cantidad <= 0) {
            throw new DepositoInvalidoException(cantidad);
        }
        saldo += cantidad;
    }
    public void extraer(double cantidad) throws ExtraccionInvalidaException {
        if (cantidad > 0) {
            if (cantidad > saldo) {
                throw new ExtraccionInvalidaException(saldo,cantidad);
            }
            saldo -= cantidad;
        }
    }
    public double getSaldo() {
        return saldo;
    }
    public String getTitular() {
        return titular;
    }
}