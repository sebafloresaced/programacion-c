package ej5;

public class Persona implements Cloneable, Comparable<Persona> {
    private int DNI, legajo;
    private static int sigLegajo = 1;
    private String apellido;
    private Domicilio domicilio;
    private Animal mascota;
    
    public Persona(String apellido, int DNI, Domicilio domicilio, Animal mascota) {
        this.DNI = DNI;
        legajo = sigLegajo;
        sigLegajo++;
        this.apellido = apellido;
        this.domicilio = domicilio;
        this.mascota = mascota;
    }
    public Persona(String apellido, int DNI, Domicilio domicilio) {
        this(apellido,DNI,domicilio,null);
    }
    @Override 
    public Object clone() throws CloneNotSupportedException {
        Persona clon = (Persona)super.clone();
        clon.domicilio = (Domicilio)domicilio.clone();
        clon.mascota = (Animal)mascota.clone();
        return clon;
    }
    public String getApellido() {
        return apellido;
    }
    public int getDNI() {
        return DNI;
    }
    public Domicilio getDomicilio() {
        return domicilio;
    }
    public int getLegajo() {
        return legajo;
    }
    public Animal getMascota() {
        return mascota;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public void setDNI(int DNI) {
        this.DNI = DNI;
    }
    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }
    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }
    public void setMascota(Animal mascota) {
        this.mascota = mascota;
    }
    @Override 
    public String toString() {
        return " - DNI: " + DNI +
            " - Legajo: " + legajo +
            " - Apellido: " + apellido +
            " - Domicilio: " + domicilio +
            " - Mascota: " + mascota;
    }
    @Override
    public int compareTo(Persona otro) {
        int comparacion = this.apellido.compareTo(otro.apellido);
        if (comparacion == 0) {
            return Integer.compare(this.DNI, otro.DNI);
        }
        return comparacion;
    }
}