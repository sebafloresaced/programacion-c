package ej5;

public class Categoria {
    private String nombreCategoria;
    private double sueldo;
    public Categoria(String nombreCategoria,double sueldo) {
        this.nombreCategoria = nombreCategoria;
        this.sueldo = sueldo;
    }
    public String getNombreCategoria() {
        return nombreCategoria;
    }
    public double getSueldo() {
        return sueldo;
    }
    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }
    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }
}
