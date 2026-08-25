package ej4;

public class LineaDePedido {
    /**
     * @aggregation shared
     */
    private Producto prod;
    private int cant;
    public LineaDePedido() {
        super();
    }
    public void setProd(Producto prod){
        this.prod = prod;
    }
    public void setCant(int cant){
        this.cant = cant;
    }
    public Producto getProd(){
        return prod;
    }
    public int getCant(){
        return cant;
    }
    public double precioTotal(){
        return prod.getPrecio() * cant;
    }
}
