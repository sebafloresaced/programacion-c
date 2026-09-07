package ej4;

public class EmpleadoTemporal extends Empleado {
    private double sueldoPorHora;
    private int cantHoras;
    public EmpleadoTemporal(String nombre, int legajo, String calle, int altura, double sueldoPorHora) {
        super(nombre,legajo,calle,altura);
        cantHoras = 0;
        this.sueldoPorHora = sueldoPorHora;
    }
    public int getCantHoras() {
        return cantHoras;
    }
    public double getSueldoPorHora() {
        return sueldoPorHora;
    }
    public void setSueldoPorHora(double sueldoPorHora) {
        this.sueldoPorHora = sueldoPorHora;
    }
    public void cargarHoras(int cant) {
        if (cant > 0) {
            cantHoras += cant;
        }
    }
    public void resetearHoras() {
        cantHoras = 0;
    }
    @Override
    public double calcularSueldoNeto() {
        return sueldoPorHora * cantHoras;
    }
}
