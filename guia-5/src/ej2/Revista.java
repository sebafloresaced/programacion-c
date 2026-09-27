package ej2;

public class Revista extends ElementoBiblioteca {
    private int numero;
    private int anioPublicacion;
    
    public Revista(String titulo, int codigo, int anioPublicacion, int numero) {
        super(titulo, codigo);
        this.numero = numero;
        this.anioPublicacion = anioPublicacion;
    }
    public int getNumero() {
        return numero;
    }
    public int getAnioPublicacion() {
        return anioPublicacion;
    }
    @Override
    public String toString() {
        String resultado = super.toString() +
            "numero de revista: " + numero +
            "- anioPublicacion: " + anioPublicacion;
        return resultado;
    }
}
