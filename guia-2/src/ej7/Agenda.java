package ej7;

import java.util.HashMap;

public class Agenda {
    private HashMap<String, Contacto> contactos;

    public Agenda() {
        contactos = new HashMap<>();
    }

    // Alta
    public boolean agregarContacto(Contacto contacto) {
        String nombre = contacto.getNombre();

        if (!contactos.containsKey(nombre)) {
            contactos.put(nombre, contacto);
            return true;
        }

        return false;
    }

    // Búsqueda
    public Contacto buscarContacto(String nombre) {
        return contactos.get(nombre);
    }

    // Baja
    public boolean eliminarContacto(String nombre) {
        return contactos.remove(nombre) != null;
    }

    // Modificación del teléfono fijo
    public boolean modificarTelefonoFijo(String nombre,
                                         String nuevoTelefono) {
        Contacto contacto = contactos.get(nombre);

        if (contacto != null) {
            contacto.setTelefonoFijo(nuevoTelefono);
            return true;
        }

        return false;
    }

    // Modificación del nombre
    public boolean modificarNombre(String nombreActual,
                                   String nuevoNombre) {

        if (!contactos.containsKey(nombreActual)
                || contactos.containsKey(nuevoNombre)) {
            return false;
        }

        Contacto contacto = contactos.remove(nombreActual);
        contacto.setNombre(nuevoNombre);
        contactos.put(nuevoNombre, contacto);

        return true;
    }

    public boolean agregarCelular(String nombre, String celular) {
        Contacto contacto = contactos.get(nombre);

        if (contacto != null) {
            return contacto.agregarCelular(celular);
        }

        return false;
    }

    public boolean eliminarCelular(String nombre, String celular) {
        Contacto contacto = contactos.get(nombre);

        if (contacto != null) {
            return contacto.eliminarCelular(celular);
        }

        return false;
    }

    // Mostrar todos los contactos
    public void mostrarContactos() {
        for (Contacto contacto : contactos.values()) {
            System.out.println(contacto);
            System.out.println("--------------------");
        }
    }

    public int cantidadContactos() {
        return contactos.size();
    }
}