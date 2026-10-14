package ej2;

import java.util.PriorityQueue;

public class ListaConPrioridades <T extends Comparable> {
    private PriorityQueue<T> elementos;
    
    public ListaConPrioridades() {
        elementos = new PriorityQueue<>();
    }
    
    public void agregar(T elemento) {
        elementos.add(elemento);
    }
    
    public T consultarElemento() {
        return elementos.peek();
    }
                  
    public int getCantidad() {
        return elementos.size();
    }
    
    public T getElemento() {
        return elementos.poll();
    }
}
