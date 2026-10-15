package ej4;

import ej3.ConjuntoGenericoOrdenado;
import java.util.GregorianCalendar;
import java.util.Iterator;

public class Pedido extends ConjuntoGenericoOrdenado {
    /**
     * @aggregation shared
     */
    private Empleado empleado;
    private GregorianCalendar fecha;

    public Pedido(Empleado empleado) {
        super();
        this.empleado = empleado;
        this.fecha = new GregorianCalendar();
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public GregorianCalendar getFecha() {
        return fecha;
    }

    public void setFecha(GregorianCalendar fecha) {
        this.fecha = fecha;
    }

    public String getDetalle() {
        String resultado = "";
        Iterator<LineaDePedido> it = getIterator();
        while (it.hasNext()) {
            LineaDePedido linea = it.next();
            resultado += linea.toString() + "\n";
        }
        return resultado;
    }

    public double getPrecioTotal() {
        double total = 0;
        Iterator<LineaDePedido> it = getIterator();
        while (it.hasNext()) {
            LineaDePedido linea = it.next();
            total += linea.getCantidad() * linea.getProducto().getPreciounitario();
        }
        return total;
    }

    @Override
    public String toString() {
        return "Empleado: " + empleado +
               "\nFecha: " + fecha.getTime() +
               "\nDetalle:\n" + getDetalle() +
               "\nPrecio total: $" + getPrecioTotal();
    }
}