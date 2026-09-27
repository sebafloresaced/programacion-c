package ej5;

public abstract class Artesano {
    private String nombre;
    
    public Artesano(String nombre) {
        this.nombre = nombre;
    }
    public abstract String trabajar(Material mat);
    public String getNombre() {
        return nombre;
    }
}
