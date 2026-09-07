package ej6;

public class Link extends ElementoFS {
    private ElementoFS destino;
    public Link(String nombre, ElementoFS destino) {
        super(nombre);
        this.destino = destino;
    }
    public ElementoFS getDestino() {
        return destino;
    }
    @Override
    public double getTamanio() {
        return 1;
    }
}