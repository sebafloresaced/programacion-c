package ej4;

import java.util.ArrayList;

public class Departamento {
    private String nombre;
    private ArrayList<Empleado> empleados = new ArrayList<>();    
    public Departamento(String nombre) {
        this.nombre = nombre;
    }
    public String getNombre() {
        return nombre;
    }
    public ArrayList<Empleado> getEmpleados() {
        return empleados;
    }
    public void agregarEmpleado(Empleado empleado) {
        if (!empleados.contains(empleado)) { 
            empleados.add(empleado);
        }
    }
    public boolean eliminarEmpleado(Empleado empleado) {
        return empleados.remove(empleado); // devuelve true si elimino o false si no lo encontro
    }
    public ArrayList<ItemPlanilla> generarPlanilla() {
        ArrayList<ItemPlanilla> planilla = new ArrayList<>();
        for (Empleado empleado : empleados) {
            planilla.add(new ItemPlanilla(empleado.getNombre(), empleado.calcularSueldoNeto()));
        }
        return planilla;
    }
}
