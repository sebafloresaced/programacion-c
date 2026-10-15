package ej4;

public class LineaDePedido implements Comparable<LineaDePedido> {
    private int cantidad;

    /**
     * @aggregation shared
     */
    private Producto producto;
    
    public LineaDePedido() {
        super();
    }
    
    public LineaDePedido(int cantidad, Producto producto) {
        this.cantidad = cantidad;
        this.producto = producto;
    }
    
    @Override
    public int compareTo(LineaDePedido otra) {
        return Integer.compare(this.producto.getCodigo(),otra.producto.getCodigo());
    }
    
    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof LineaDePedido)) {
            return false;
        }
        LineaDePedido otra = (LineaDePedido) object;
        return this.producto.equals(otra.producto);
    }
    
    public int getCantidad() {
        return cantidad;
    }
    
    public Producto getProducto() {
        return producto;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + producto.getCodigo();
        return hash;
    }
    
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    
    @Override
    public String toString() {
        return "Producto: " + producto +
            ", Cantidad: " + cantidad;
    }
}
