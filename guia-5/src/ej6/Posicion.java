package ej6;

public class Posicion implements Movible {
    private double x;
    private double y;
    public Posicion(double x, double y) {
        this.x = x;
        this.y = y;
    }
    @Override
    public double getPosx() {
        return x;
    }
    @Override
    public double getPosy() {
        return y;
    }
    @Override
    public void setXY(double x, double y) {
        this.x = x;
        this.y = y;
    }
    @Override
    public void incrementaPos(double x, double y) {
        this.x += x;
        this.y += y;
    }
    @Override
    public double distancia(Movible otro) {
        double dx = x - otro.getPosx();
        double dy = y - otro.getPosy();
        return Math.sqrt(dx * dx + dy * dy);
    }
}