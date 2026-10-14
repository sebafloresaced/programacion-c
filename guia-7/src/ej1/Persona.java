package ej1;

public class Persona implements Comparable<Persona> {
    private String nombre, apellido, direccion;
    
    public Persona(String nombre, String apellido, String direccion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getApellido() {
        return apellido;
    }
    
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    public String getDireccion() {
        return direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    @Override
    public boolean equals(Object obj) {
        // se establecen como criterio los atributos nombre y apellido
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Persona)) {
            return false;
        }
        final Persona p = (Persona)obj;
        return (this.nombre.equals(p.getNombre()) && this.apellido.equals(p.getApellido()));
    }
    
    @Override
    public int hashCode() {
        int hash = 1;
        hash = hash * 17 + nombre.hashCode();
        hash = hash * 9 + apellido.hashCode();
        return hash;
    }
    
    @Override
    public int compareTo(Persona p) {
        int aux = this.getApellido().compareTo(p.getApellido());
        if (aux == 0) {
            return this.getNombre().compareTo(p.getNombre());
        }
        return aux;
    }
    
    @Override 
    public String toString() {
        return " - Apellido: " + apellido +
            ", Nombre: " + nombre +
            ", Direccion: " + direccion;
    }
}