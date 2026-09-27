package ej5;

public class Metal extends Material {
    private String nombre;
    
    public Metal(String nombre, String color) {
        super(color);
        this.nombre = nombre;
    }
    @Override
    public String trabajadoJuguetero() {
        return " fabrico un autito de " + this;
    }
    @Override
    public String trabajadoJoyero() {
        return " fabrico un anillo de " + this;
    }
    @Override
    public String toString() {
        return nombre + " " + getColor();
    }
}
