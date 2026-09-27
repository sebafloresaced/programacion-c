package ej2;

import java.util.ArrayList;

public class CD extends ElementoBiblioteca implements Prestable, Comparable<CD> {
    private String interprete;
    private ArrayList<Cancion> canciones;
    private boolean prestado;
    
    public CD(String titulo, int codigo, String interprete) {
        super(titulo,codigo);
        this.interprete = interprete;
        canciones = new ArrayList<>();
    }
    public void agregarCancion(Cancion cancion) {
        canciones.add(cancion);
    }
    public String getInterprete() {
        return interprete;
    }
    public ArrayList<Cancion> getCanciones() {
        return canciones;
    }
    @Override
    public void prestar() {
        prestado = true;
    }
    @Override
    public void devolver() {
        prestado = false;
    }
    @Override
    public boolean isPrestado() {
        return prestado;
    }
    @Override
    public String toString() {
        String resultado = super.toString() +
            "- interprete: " + interprete;
        for (Cancion cancion : canciones) {
            resultado += cancion.toString();
        }
        resultado += "- prestado: " + prestado;
        return resultado;
    }
    @Override
    public int compareTo(CD otro) {
        int comparacion = interprete.compareToIgnoreCase(otro.interprete);
        if (comparacion == 0) {
            return getTitulo().compareToIgnoreCase(otro.getTitulo());
        }
        return comparacion;
    }
}
