package ej3;

import java.util.Iterator;
import java.util.LinkedHashSet;

public class ConjuntoGenerico<T> implements IConjunto<T> {
    private LinkedHashSet<T> elementos;
    
    public ConjuntoGenerico() {
        elementos = new LinkedHashSet<T>();
    }
    
    public void agrega(T o) throws OperacionConjuntosException {
        boolean resultado = elementos.add(o);
        if (resultado == false) {
            throw new OperacionConjuntosException("El elemento ya existe en la coleccion", o);
        }
    }
    public void elimina(T o) throws OperacionConjuntosException {
        boolean resultado = elementos.remove(o);
        if (resultado == false) {
            throw new OperacionConjuntosException("El elemento no existe en la coleccion", o);
        }
    }
    public int getCardinal() {
        return elementos.size();
    }
    public Iterator<T> getIterator() {
        return elementos.iterator();
    }
}
