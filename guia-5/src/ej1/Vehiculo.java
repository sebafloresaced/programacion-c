package ej1;

public class Vehiculo {
    private String patente;
    private String modelo;

    public Vehiculo(String patente, String modelo) {
        this.patente = patente;
        this.modelo = modelo;
    }
    public String getPatente() {
        return patente;
    }
    public void setPatente(String patente) {
        this.patente = patente;
    }
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
}