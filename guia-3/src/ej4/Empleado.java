package ej4;

public abstract class Empleado {
    private String nombre;
    private int legajo;
    private Domicilio domicilio;
    public Empleado(String nombre, int legajo, String calle, int altura) {
        Domicilio domicilio = new Domicilio(calle,altura);
        this.domicilio = domicilio;
        this.nombre = nombre;
        this.legajo = legajo;
    }
    public String getNombre() {
        return nombre;
    }
    public int getLegajo() {
        return legajo;
    }
    public abstract double calcularSueldoNeto();
}
