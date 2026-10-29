package ej4;

public class Libro {
    private final int idLibro;
    private final String titulo;

    public Libro(int idLibro, String titulo) {
        this.idLibro = idLibro;
        this.titulo = titulo;
    }

    public int getIdLibro() {
        return idLibro;
    }

    public String getTitulo() {
        return titulo;
    }

    @Override
    public String toString() {
        return idLibro + " - " + titulo;
    }
}