package ej4;
import java.util.ArrayList;

public class Pedido {
    /**
     * @aggregation shared
     */
    private Empleado emp;
    private String fecha;

    /**
     * @aggregation composite
     */
    private ArrayList< LineaDePedido > lineas = new ArrayList<>();
    public Pedido() {
        super();
    }
    public void setEmp(Empleado emp){
        this.emp = emp;
    }
    public void setFecha(String fecha){
        this.fecha = fecha;
    }
    public void AgregarLinea(LineaDePedido linea){
        lineas.add(linea);
    }
    public Empleado getEmp(){
        return emp;
    }
    public String getFecha(){
        return fecha;
    }
    public double precioPedido() {
        int i,tope = lineas.size();
        double aux=0;
        for (i=0;i<tope;i++) {
            aux += lineas.get(i).precioTotal();
        }
        return aux;
    }
}
