package ej6;

import java.time.LocalDate;

public class Archivo extends ElementoFS {
    private LocalDate fechaUltimaModificacion;
    private double tamanio;
    public Archivo(String nombre, double tamanio) {
        super(nombre);
        this.tamanio = tamanio;
        this.fechaUltimaModificacion = LocalDate.now();
    }
    public LocalDate getFechaUltimaModificacion() {
        return fechaUltimaModificacion;
    }
    @Override
    public double getTamanio() {
        return tamanio;
    }
}