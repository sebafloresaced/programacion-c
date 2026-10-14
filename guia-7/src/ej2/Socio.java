package ej2;

public class Socio {
    private int dni;
    private String domicilio, nombre;
    
    public Socio() {
    }
    
    public Socio(int dni, String nombre, String domicilio) {
        this.dni = dni;
        this.nombre = nombre;
        this.domicilio = domicilio;
    }
    
    public int getDni() {
        return dni;
    }
    
    public String getDomicilio() {
        return domicilio;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setDni(int dni) {
        this.dni = dni;
    }
    
    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    @Override
    public String toString() {
        return "- Dni: " + dni +
            "\n- Nombre: " + nombre +
            "\n- Direccion: " + domicilio;
    }
}