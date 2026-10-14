package ej3;

import java.util.Iterator;

public interface IConjunto<T> {
    public void agrega(T elemento) throws OperacionConjuntosException;
    public void elimina(T elemento) throws OperacionConjuntosException;
    public int getCardinal();
    public Iterator<T> getIterator();
}
