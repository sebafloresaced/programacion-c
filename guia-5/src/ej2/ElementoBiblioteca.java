package ej2;

public class ElementoBiblioteca {
    private String titulo;
    private int codigo;
    
    public ElementoBiblioteca(String titulo, int codigo) {
        this.titulo = titulo;
        this.codigo = codigo;
    }
    public String getTitulo() {
        return titulo;
    }
    public int getCodigo() {
        return codigo;
    }
    @Override
    public String toString() {
        String resultado = 
            "Titulo: " + titulo +
            "- codigo: " + codigo;
        return resultado;
    }
}
