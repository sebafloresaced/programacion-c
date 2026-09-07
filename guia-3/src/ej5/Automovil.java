package ej5;

public abstract class Automovil {
    private String patente;
    private double velocidadMax;
    protected double velocidad;
    private int marcha; // 0 - punto muerto ; -1 - marcha atras
    public Automovil(String patente, double velocidadMax) {
        this.patente = patente;
        this.velocidadMax = velocidadMax;
        marcha = 0;
        velocidad = 0;
    }
    public Automovil(String patente) {
        this(patente,160);
    }
    public String getPatente() {
        return patente;
    }
    public double getVelocidad() {
        return velocidad;
    }
    public int getMarcha() {
        return marcha;
    }
    protected double getVelocidadMax() {
        return velocidadMax;
    }
    public abstract void acelerar(double vel);
    public abstract void frenar(double vel);
    protected void setMarcha(int nuevaMarcha) {
        if (nuevaMarcha >= -1 && nuevaMarcha <= 5) {
            marcha = nuevaMarcha;
        }
    }
    @Override
    public String toString() {
        return "Automovil{patente='" + patente + "', velocidad=" + velocidad + ",velocidadMax=" + velocidadMax + ", marcha=" + marcha;
    }
}