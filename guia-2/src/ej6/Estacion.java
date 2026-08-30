package ej6;

import java.util.ArrayList;

public class Estacion {
    private  ArrayList<Surtidor> surtidores;
    public Estacion() {
        surtidores = new ArrayList<>();
    }
    public Surtidor CrearSurtidor() {
        Surtidor surtidor = new Surtidor();
        surtidores.add(surtidor);
        return surtidor;
    }
    public int cantidadSurtidores() {
        return surtidores.size();
    }
    public int getLitrosDisponibles(String combustible) {
        int i,acum=0,tope = surtidores.size();
        for (i=0;i<tope;i++) {
            if (combustible.equals("Gasoil")) {
                acum += surtidores.get(i).getCantGasoil();
            }
            else {
                if (combustible.equals("Premium")) {
                    acum += surtidores.get(i).getCantPremium();
                }
                else {
                    if (combustible.equals("Super")) {
                        acum += surtidores.get(i).getCantSuper();
                    }
                }
            }
        }
        return acum;
    }
    public int mayorVentasCombustible(String combustible) {
        int i,max=-1,tope = surtidores.size(),id=-1;
        for(i=0;i<tope;i++) {
            if (combustible.equals("Gasoil") && surtidores.get(i).getCantidadVentasGasoil() > max) {
                max = surtidores.get(i).getCantidadVentasGasoil();
                id = surtidores.get(i).getId();
            }
            else {
                if (combustible.equals("Premium") && surtidores.get(i).getCantidadVentasPremium() > max) {
                    max = surtidores.get(i).getCantidadVentasPremium();
                    id = surtidores.get(i).getId();
                }
                else {
                    if (combustible.equals("Super") && surtidores.get(i).getCantidadVentasSuper() > max) {
                        max = surtidores.get(i).getCantidadVentasSuper();
                        id = surtidores.get(i).getId();
                    }
                }
            }    
        }
        return id;
    }
    public int historialCombustible(String combustible){
        int i,acum=0,tope=surtidores.size();
        for (i=0;i<tope;i++) {
            if (combustible.equals("Gasoil")) {
                acum += surtidores.get(i).getGasoilVendido();
            }
            else {
                if (combustible.equals("Premium")) {
                    acum += surtidores.get(i).getPremiumVendido();
                }
                else {
                    acum += surtidores.get(i).getSuperVendido();
                }
            }
        }
        return acum;
    }
    public int historialSurtidor(int numeroSurtidor){
        Surtidor surtidor = surtidores.get(numeroSurtidor);
        return surtidor.getGasoilVendido() + surtidor.getPremiumVendido() + surtidor.getSuperVendido();
    }
    public int historialEstacion(){
        int i,acum=0,tope=surtidores.size();
        Surtidor surtidor;
        for (i=0;i<tope;i++) {
            surtidor = surtidores.get(i);
            acum += surtidor.getGasoilVendido() + surtidor.getPremiumVendido() + surtidor.getSuperVendido();
        }
        return acum;      
    }
}
