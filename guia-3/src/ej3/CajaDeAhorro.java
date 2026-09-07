package ej3;

import java.time.LocalDate;

public class CajaDeAhorro extends CuentaBancaria {
    private int cantExtracciones, mesUltimaExtraccion;
    private static int extraccionesMax = 5;
    public CajaDeAhorro(String titular) {
        super(titular);
        cantExtracciones = 0;
        mesUltimaExtraccion = LocalDate.now().getMonthValue();
    }
    private void resetExtracciones(int mesActual) {
        mesUltimaExtraccion = mesActual;
        cantExtracciones = 0;
    }
    public static void setExtraccionesMax(int max) {
        if (max >= 0)
            extraccionesMax = max;
    }
    @Override
    public boolean extraer(double monto) {
        int mesActual = LocalDate.now().getMonthValue();
        if (mesActual != mesUltimaExtraccion) {
            resetExtracciones(mesActual);
        }
        if (monto > 0 && monto <= getSaldo() && cantExtracciones < extraccionesMax) {
            descontarSaldo(monto);
            cantExtracciones++;
            return true;
        }
        return false;
    }
}
