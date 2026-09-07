package ej3;

import java.time.LocalDate;

public class CuentaUniversitaria extends CuentaBancaria {
    private LocalDate fechaUltimaExtraccion;
    private double extraidoDia;
    private static final double maxExtraccionesDia = 1000; 
    public CuentaUniversitaria(String titular) {
        super(titular);
        fechaUltimaExtraccion = LocalDate.now();
        extraidoDia = 0;
    }
    @Override
    public boolean extraer(double monto) {
        LocalDate hoy = LocalDate.now();
        if (!hoy.equals(fechaUltimaExtraccion)) {
            fechaUltimaExtraccion = hoy;
            extraidoDia = 0;
        }
        if (monto > 0 && getSaldo() >= monto && extraidoDia + monto <= maxExtraccionesDia) {
            descontarSaldo(monto);
            extraidoDia += monto;
            return true;
        }
        return false;
    }
}
