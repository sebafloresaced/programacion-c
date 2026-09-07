package ej6;

import java.time.LocalDate;

public abstract class ElementoFS {
    private String nombre;
    private LocalDate fechaCreacion;
    public ElementoFS(String nombre) {
        this.nombre = nombre;
        this.fechaCreacion = LocalDate.now();
    }
    public String getNombre() {
        return nombre;
    }
    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }
    public abstract double getTamanio();
}