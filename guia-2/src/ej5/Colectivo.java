package ej5;

public class Colectivo {
    private String modelo;
    private int numeroInterno;
    private static int sigNumeroInterno=1;
    public Colectivo(String modelo) {
        this.modelo = modelo;
        numeroInterno = sigNumeroInterno;
        sigNumeroInterno++;
    }
    public String getModelo() {
        return modelo;
    }
    public int getNumeroInterno() {
        return numeroInterno;
    }
    public static int getSigNumeroInterno() {
        return sigNumeroInterno;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
}

