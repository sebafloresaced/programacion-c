package ej4.modelo;

import java.util.ArrayList;

public class EstacionServicio {
    private ArrayList<Combustible> combustibles;
    private ArrayList<Surtidor> surtidores;

    public EstacionServicio() {
        combustibles = new ArrayList<>();
        surtidores = new ArrayList<>();
    }

    public void agregarCombustible(String nombre, double precio) {
        if (buscarCombustible(nombre) != null) {
            throw new IllegalArgumentException("Ya existe un combustible con ese nombre");
        }
        combustibles.add(new Combustible(nombre, precio));
    }

    public Combustible buscarCombustible(String nombre) {
        if (nombre == null) {
            return null;
        }
        for (Combustible combustible : combustibles) {
            if (combustible.getNombre().equalsIgnoreCase(nombre.trim())) {
                return combustible;
            }
        }
        return null;
    }

    public void modificarPrecio(String nombre, double nuevoPrecio) {
        Combustible combustible = buscarCombustible(nombre);
        if (combustible == null) {
            throw new IllegalArgumentException("El combustible no existe");
        }
        combustible.setPrecioUnidad(nuevoPrecio);
    }

    public void agregarSurtidor() {
        int numero = 1;
        while (buscarSurtidor(numero) != null) {
            numero++;
        }
        surtidores.add(new Surtidor(numero));
    }

    public Surtidor buscarSurtidor(int numero) {
        for (Surtidor surtidor : surtidores) {
            if (surtidor.getNumero() == numero) {
                return surtidor;
            }
        }
        return null;
    }

    public ArrayList<Combustible> getCombustibles() {
        return new ArrayList<>(combustibles);
    }

    public ArrayList<Surtidor> getSurtidores() {
        return new ArrayList<>(surtidores);
    }
}
