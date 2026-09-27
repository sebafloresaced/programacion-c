package ej2;

import java.util.ArrayList;

public class Biblioteca {
    private ArrayList<ElementoBiblioteca> elementos;

    public Biblioteca() {
        elementos = new ArrayList<>();
    }
    public void agregarElemento(ElementoBiblioteca elemento) {
        elementos.add(elemento);
    }
    public ArrayList<ElementoBiblioteca> getElementos() {
        return elementos;
    }
}