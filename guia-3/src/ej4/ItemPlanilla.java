package ej4;

public class ItemPlanilla {
    private String nombreEmpleado;
    private double sueldoNeto;
    public ItemPlanilla(String nombreEmpleado, double sueldoNeto) {
        this.nombreEmpleado = nombreEmpleado;
        this.sueldoNeto = sueldoNeto;
    }
    public String getNombreEmpleado() {
        return nombreEmpleado;
    }
    public double getSueldoNeto() {
        return sueldoNeto;
    }
}