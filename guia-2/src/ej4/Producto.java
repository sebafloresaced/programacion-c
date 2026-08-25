package ej4;

public class Producto {
    private int codigo;
    private double precio;
    private String descripcion;
    public Producto() {
        super();
    }
    public int getCodigo(){
        return codigo;
    }
    public double getPrecio(){
        return precio;
    }
    public String getDescripcion(){
        return descripcion;
    }
    public void setCodigo(int codigo){
        this.codigo = codigo;
    }
    public void setPrecio(double precio){
        this.precio = precio;
    }
    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }
}