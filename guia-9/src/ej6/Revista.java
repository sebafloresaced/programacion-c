package ej6;

public class Revista {
    private final int idRevista;
    private final String titulo;

    public Revista(int idRevista, String titulo) {
        this.idRevista = idRevista;
        this.titulo = titulo;
    }

    public int getIdRevista() {
        return idRevista;
    }

    public String getTitulo() {
        return titulo;
    }

    @Override
    public String toString() {
        return idRevista + " - " + titulo;
    }
}