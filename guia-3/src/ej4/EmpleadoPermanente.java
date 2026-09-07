package ej4;

public class EmpleadoPermanente extends Empleado {
    private Categoria categoria;
    private double sueldoBase;
    private int antiguedad;
    public EmpleadoPermanente(String nombre, int legajo, String calle, int altura, Categoria categoria, double sueldoBase) {
        super(nombre,legajo,calle,altura);
        this.categoria = categoria;
        antiguedad = 0;
        this.sueldoBase = sueldoBase;
    }
    public Categoria getCategoria() {
        return categoria;
    }
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    public int getAntiguedad() {
        return antiguedad;
    }
    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }
    public double getSueldoBase() {
        return sueldoBase;
    }
    public void setSueldoBase(double sueldoBase) {
        this.sueldoBase = sueldoBase;
    }
    @Override
    public double calcularSueldoNeto() {
        return categoria.sueldoNeto(sueldoBase, antiguedad);
    }
}
