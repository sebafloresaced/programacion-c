package ej6;

public class Dragon extends Personaje {
    private double poderFuego;

    public Dragon(double x, double y) {
        super(1000, x, y);
        poderFuego = 100;
    }
    public double getPoderFuego() {
        return poderFuego;
    }
    public void setPoderFuego(double poderFuego) {
        this.poderFuego = poderFuego;
    }
    @Override
    public void recibeDano(double cantidad) {
        setVitalidad( getVitalidad() - cantidad * 0.50 );
    }
    public void atacar(Personaje enemigo) {
        if (distancia(enemigo) < 50) {
            enemigo.recibeDano(poderFuego);
        }
    }
    @Override
    public void recibirHechizo(Hechizo hechizo) {
        hechizo.aplicar(this);
    }
}