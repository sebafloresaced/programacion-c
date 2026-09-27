package ej2;

public class Libro extends ElementoBiblioteca implements Prestable {
    private boolean prestado;
    private int anioPublicacion;
    
    public Libro(String titulo, int codigo, int anioPublicacion) {
        super(titulo, codigo);
        prestado = false;
        this.anioPublicacion = anioPublicacion;
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
    public int getAnioPublicacion() {
        return anioPublicacion;
    }
    @Override
    public String toString() {
        String resultado = super.toString() +
            "- prestado: " + prestado +
            "- anioPublicacion: " + anioPublicacion;
        return resultado;
    }
}
