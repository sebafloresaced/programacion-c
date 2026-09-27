package ej5;

public abstract class Material {
    private String color;
    
    public Material(String color) {
        this.color = color;
    }
    public abstract String trabajadoJuguetero();
    public abstract String trabajadoJoyero();
    public String getColor() {
        return color;
    }
}

