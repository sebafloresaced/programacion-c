package ej3;

import java.util.Iterator;
import java.util.TreeSet;

public class ConjuntoGenericoOrdenado<T extends Comparable<T>> implements IConjunto<T> {
    private TreeSet<T> elementos;
    
    public ConjuntoGenericoOrdenado() {
        elementos = new TreeSet<T>();
    }
    
    public int getCardinal() {
        return elementos.size();
    }
    
    @Override
    public void agrega(T elemento) throws OperacionConjuntosException {
        boolean resultado = elementos.add(elemento);
        if (!resultado) {
            throw new OperacionConjuntosException("El elemento ya existe en la coleccion", elemento);
        }
    }

    @Override
    public void elimina(T elemento) throws OperacionConjuntosException {
        boolean resultado = elementos.remove(elemento);
        if (!resultado) {
            throw new OperacionConjuntosException("El elemento no existe en la coleccion", elemento);
        }
    }
    
    public Iterator<T> getIterator() {
        return elementos.iterator();
    }
    
    public T getMayor() {
        return elementos.isEmpty() ? null : elementos.last();
    }

    public T getMenor() {
        return elementos.isEmpty() ? null : elementos.first();
    }
}
