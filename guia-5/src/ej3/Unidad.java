package ej3;

public abstract class Unidad implements IPosicionable {
    private String equipo;
    private int costo;
    private int energia;
    private int x;
    private int y;
    
    public Unidad(String equipo, int costo, int energia, int x, int y) {
        this.equipo = equipo;
        this.costo = costo;
        this.energia = energia;
        this.x = x;
        this.y = y;
    }
    public String getEquipo() {
        return equipo;
    }
    public int getCosto() {
        return costo;
    }
    public int getEnergia() {
        return energia;
    }
    protected void setEnergia(int energia) {
        this.energia = energia;
    }
    @Override
    public int getX() {
        return x;
    }
    @Override
    public int getY() {
        return y;
    }
    protected void setX(int x) {
        this.x = x;
    }
    protected void setY(int y) {
        this.y = y;
    }
    public abstract void recibeDano(int cantidad);
}