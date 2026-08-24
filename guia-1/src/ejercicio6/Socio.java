package ejercicio6;

public class Socio {
    private String nombre;
    double edad;
    int participaTorneo; 
    public Socio() {
        super();
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setEdad(double edad) {
        this.edad = edad;
    }
    public void setParticipaTorneo(int participa) {
        this.participaTorneo = participa;
    }
    public String getNombre() {
        return nombre;
    }
    public double getEdad() {
        return edad;
    }
    public int getParticipaTorneo() {
        return participaTorneo;
    }
    public double calcularCuota() {
        final double cuota = 500;
        if (edad >= 65) {
            return cuota * 0.5;
        }
        else {
            if (edad <= 18 && participaTorneo == 1) {
                return cuota * 0.75;
            }
            else {
                return cuota;
            }
        }
    }
}