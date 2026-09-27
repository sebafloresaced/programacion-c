package ej6;

public abstract class Personaje implements Movible {
    private Posicion posicion;
    private double vitalidad;

    public Personaje(double vitalidad, double x, double y) {
        this.vitalidad = vitalidad;
        posicion = new Posicion(x, y);
    }
    public double getVitalidad() {
        return vitalidad;
    }
    public void setVitalidad(double vitalidad) {
        this.vitalidad = vitalidad;
    }
    public void recibeDano(double cantidad) {
        vitalidad -= cantidad;
    }
    public abstract void recibirHechizo(Hechizo hechizo);
    @Override
    public double getPosx() {
        return posicion.getPosx();
    }
    @Override
    public double getPosy() {
        return posicion.getPosy();
    }
    @Override
    public void setXY(double x, double y) {
        posicion.setXY(x, y);
    }
    @Override
    public void incrementaPos(double x, double y) {
        posicion.incrementaPos(x, y);
    }
    @Override
    public double distancia(Movible otro) {
        return posicion.distancia(otro);
    }
}