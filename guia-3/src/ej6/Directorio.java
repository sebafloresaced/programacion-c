package ej6;

import java.util.ArrayList;

public class Directorio extends ElementoFS {
    private ArrayList<ElementoFS> elementos;
    public Directorio(String nombre) {
        super(nombre);
        elementos = new ArrayList<>();
    }
    public void agregarElemento(ElementoFS elemento) {
        elementos.add(elemento);
    }
    public void listar() {
        for (ElementoFS e : elementos) {
            System.out.println(e.getNombre());
            if (e instanceof Directorio) {
                ((Directorio)e).listar(); // casteo para listar
            }
        }
    }
    @Override
    public double getTamanio() {
        double total = 0;
        for (ElementoFS e : elementos) {
            total += e.getTamanio();
        }
        return total;
    }
}