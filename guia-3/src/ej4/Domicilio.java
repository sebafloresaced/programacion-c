package ej4;

public class Domicilio {
    private String calle;
    private int altura;
    public Domicilio(String calle, int altura) {
        this.calle = calle;
        this.altura = altura;
    }
    public String getCalle() {
        return calle;
    }
    public int getAltura() {
        return altura;
    }
    public void cambiarDomicilio(String calle, int altura) {
        this.calle = calle;
        this.altura = altura;
    }
}
