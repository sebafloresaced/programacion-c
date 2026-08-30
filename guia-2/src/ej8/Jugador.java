package ej8;

import java.time.LocalDate;

public class Jugador {
    private String nombre;
    private LocalDate fechaNacimiento;
    private int nroCamiseta,posicion,cantPartidos,cantGoles;
    public Jugador(String nombre,int nroCamiseta,int posicion, int dia, int mes, int anio) {
        this.nombre = nombre;
        this.nroCamiseta = nroCamiseta;
        this.posicion = posicion;
        this.fechaNacimiento = LocalDate.of(anio,mes,dia);
        cantPartidos = 0;
        cantGoles = 0;
    }
    public String getNombre() {
        return nombre;
    }
    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }
    public int getNroCamiseta() {
        return nroCamiseta;
    }
    public int getPosicion() {
        return posicion;
    }
    public void setNroCamiseta(int nroCamiseta) {
        this.nroCamiseta = nroCamiseta;
    }
    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }
    public void registrarPartido() {
        cantPartidos++;
    }
    public void registrarGoles(int cantGoles) {
        if (cantGoles>0) {
            this.cantGoles += cantGoles;
        }
    }
    public int getCantPartidos() {
        return cantPartidos;
    }
    public int getCantGoles() {
        return cantGoles;
    }
    public double promedioGolesPorPartido() {
        if (cantPartidos == 0) {
            return 0;
        }
        return (double) cantGoles / cantPartidos;
    }
    public Jugador masGoleador(Jugador otro) {
        if (cantGoles >= otro.getCantGoles()) {
            return this;
        }
        return otro;
    }
    @Override
    public String toString() {
        return nombre + " - Camiseta: " + nroCamiseta
               + " - Goles: " + cantGoles;
    }
}
