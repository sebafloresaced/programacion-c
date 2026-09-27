package ej2;

public class Cancion {
    private int nroPista;
    private String titulo;
    private double duracion;
    
    public Cancion(int nroPista, String titulo, double duracion) {
        this.nroPista = nroPista;
        this.titulo = titulo;
        this.duracion = duracion;
    }
    @Override
    public String toString() {
        String resultado = 
            "- titulo: " + titulo +
            "- nroPista: " + nroPista +
            "- duracion en minutos: " + duracion;
        return resultado;
    }
}
