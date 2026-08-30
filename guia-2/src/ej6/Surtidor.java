package ej6;

public class Surtidor {
    private int cantGasoil, cantPremium, cantSuper, id, gasoilVendido, premiumVendido, superVendido, cantVentasGasoil, cantVentasPremium, cantVentasSuper;
    private final int maximaCarga = 20000;
    private static int sigId = 0;
    public Surtidor() {
        cantGasoil = maximaCarga;
        cantPremium = maximaCarga;
        cantSuper = maximaCarga;
        id = sigId;
        sigId++;
        gasoilVendido = 0;
        premiumVendido = 0;
        superVendido = 0;
        cantVentasGasoil = 0;
        cantVentasPremium = 0;
        cantVentasSuper = 0;
    }
    public boolean extraerGasoil(int litros) {
        if (cantGasoil > 0 || litros <= 0) {   
            cantVentasGasoil++;
            cantGasoil -= litros;
            if (cantGasoil < 0) {
                gasoilVendido += litros + cantGasoil;
                cantGasoil = 0;
                return false;
            }
            else {
                gasoilVendido += litros;
                return true;
            }
        }
        return false;
    }    
    public boolean extraerPremium(int litros) {
        if (cantPremium > 0 || litros <= 0) {   
            cantVentasPremium++;
            cantPremium -= litros;
            if (cantPremium < 0) {
                premiumVendido += litros + cantPremium;
                cantPremium = 0;
                return false;
            }
            else {
                premiumVendido += litros;
                return true;
            }
        }
        return false;
    }
    public boolean extraerSuper(int litros) {
        if (cantSuper > 0 || litros <= 0) {   
            cantVentasSuper++;
            cantSuper -= litros;
            if (cantSuper < 0) {
                superVendido += litros + cantSuper;
                cantSuper = 0;
                return false;
            }
            else {
                superVendido += litros;
                return true;
            }
        }
        return false;
    }
    public int getCantGasoil() {
        return cantGasoil;
    }
    public int getCantPremium() {
        return cantPremium;
    }
    public int getCantSuper() {
        return cantSuper;
    }
    public void llenarDepositoGasoil() {
        cantGasoil = maximaCarga;
    }
    public void llenarDepositoPremium() {
        cantPremium = maximaCarga;
    }
    public void llenarDepositoSuper() {
        cantSuper = maximaCarga;
    }
    public int getCantidadVentasPremium() {
        return cantVentasPremium;
    }
    public int getCantidadVentasGasoil() {
        return cantVentasGasoil;
    }
    public int getCantidadVentasSuper() {
        return cantVentasSuper;
    }
    public int getGasoilVendido() {
        return gasoilVendido;
    }
    public int getPremiumVendido() {
        return premiumVendido;
    }
    public int getSuperVendido() {
        return superVendido;
    }
    public int getId() {
        return id;
    }
}
