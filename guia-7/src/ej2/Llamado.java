package ej2;

import java.util.GregorianCalendar;

public class Llamado implements Comparable<Llamado> {
    private GregorianCalendar fechahoraAtendido, fechahoraPedido;
    private int prioridad;
    private Socio socio;
    
    public Llamado(int prioridad, Socio socio) {
        this.prioridad = prioridad;
        this.socio = socio;
        this.fechahoraPedido = new GregorianCalendar();
        this.fechahoraAtendido = null;
    }
    
    @Override
    public int compareTo(Llamado o) {
        int aux = Integer.compare(o.prioridad, this.prioridad);
        if (aux == 0) {
            return this.fechahoraPedido.compareTo(o.getFechahoraPedido());
        }
        return aux;
    }
    
    public GregorianCalendar getFechahoraAtendido() {
        return fechahoraAtendido;
    }
    
    public GregorianCalendar getFechahoraPedido() {
        return fechahoraPedido;
    }
    
    public int getPrioridad() {
        return prioridad;
    }
    
    public Socio getSocio() {
        return socio;
    }
    
    public void setFechahoraAtendido(GregorianCalendar fechahoraAtendido) {
        this.fechahoraAtendido = fechahoraAtendido;
    }
    
    @Override
    public String toString() {
        return socio + 
            "\n- Prioridad: " + prioridad +
            "\n- Fecha de pedido: " + fechahoraPedido;
    }
}
