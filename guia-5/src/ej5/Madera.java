package ej5;

public class Madera extends Material {
    private String tipo;
    
    public Madera(String tipo, String color) {
        super(color);
        this.tipo = tipo;
    }
    @Override
    public String trabajadoJuguetero() {
        return " fabrico un muniequito de " + this;
    }
    @Override
    public String trabajadoJoyero() {
        return " fabrico un par de aros de " + this;
    }
    @Override
    public String toString() {
        return tipo + " " + getColor();
    }
}
