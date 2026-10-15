package ej4;

public class Producto {
    private int codigo;
    private String descripcion;
    private double preciounitario;
    
    public Producto() {
        super();
    }
    
    public Producto(String descripcion, int codigo, double preciounitario) {
        this.descripcion = descripcion;
        this.codigo = codigo;
        this.preciounitario = preciounitario;
    }
    
    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Producto)) {
            return false;
        }
        Producto otro = (Producto) object;
        return this.codigo == otro.codigo;
    }
    
    public int getCodigo() {
        return codigo;
    }
    
    public String getDescripcion() {
        return descripcion;
    }
    
    public double getPreciounitario() {
        return preciounitario;
    }
    
    @Override
    public int hashCode() {
        return codigo;
    }
    
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public void setPrecioUnitario(double preciounitario) {
        this.preciounitario = preciounitario;
    }
    
    @Override
    public String toString() {
        return "Codigo: " + codigo +
            ", Precio unitario: " + preciounitario +
            ", Descripcion: " + descripcion;
    }
}
