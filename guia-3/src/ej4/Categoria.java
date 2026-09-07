package ej4;

public abstract class Categoria {
    public Categoria() {
        super();
    }
    public abstract double sueldoBruto(double sueldoBase, int antiguedad);
    public double sueldoNeto(double sueldoBase, int antiguedad) {
        return sueldoBruto(sueldoBase,antiguedad) * 0.83; // 11% aporte y 6% obra social
    }
}
