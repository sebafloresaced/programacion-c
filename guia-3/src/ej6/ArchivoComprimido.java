package ej6;

import java.util.ArrayList;

public class ArchivoComprimido extends ElementoFS {
    private ArrayList<ElementoFS> elementos;
    private double tasaCompresion;
    public ArchivoComprimido(String nombre, double tasaCompresion) {
        super(nombre);
        this.tasaCompresion = tasaCompresion;
        elementos = new ArrayList<>();
    }
    public void agregarElemento(ElementoFS elemento) {
        elementos.add(elemento);
    }
    public void listar() {
        for (ElementoFS e : elementos) {
            System.out.println(e.getNombre());
            if (e instanceof Directorio) {
                ((Directorio)e).listar();
            }
        }
    }
    @Override
    public double getTamanio() {
        double total = 0;
        for (ElementoFS e : elementos) {
            total += e.getTamanio();
        }
        return total * tasaCompresion;
    }
}