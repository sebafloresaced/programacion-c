package ej3;

public class CuentaCorriente extends CuentaBancaria {
    private double tope;
    public CuentaCorriente(String titular, double tope) {
        super(titular);
        if (tope > 0) {
            this.tope = tope;
        }
        else {
            this.tope = 0;
        }
    }
    public double getTope() {
        return tope;
    }
    public void setTope(double tope) {
        if (tope >= 0) {
            this.tope = tope;
        }
    }
    @Override
    public boolean extraer(double monto) {
        if (monto > 0 && getSaldo() - monto >= -1 * tope) {
            descontarSaldo(monto);
            return true;
        }
        return false;
    }
}
