package ej7;

import java.util.ArrayList;

public class Contacto {
    private String nombre;
    private String telefonoFijo;
    private ArrayList<String> celulares;

    public Contacto(String nombre, String telefonoFijo) {
        this.nombre = nombre;
        this.telefonoFijo = telefonoFijo;
        celulares = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefonoFijo() {
        return telefonoFijo;
    }

    public ArrayList<String> getCelulares() {
        return celulares;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTelefonoFijo(String telefonoFijo) {
        this.telefonoFijo = telefonoFijo;
    }

    public boolean agregarCelular(String celular) {
        if (!celulares.contains(celular)) {
            celulares.add(celular);
            return true;
        }

        return false;
    }

    public boolean eliminarCelular(String celular) {
        return celulares.remove(celular);
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre
             + "\nTeléfono fijo: " + telefonoFijo
             + "\nCelulares: " + celulares;
    }
}