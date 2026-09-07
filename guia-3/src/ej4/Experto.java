package ej4;

public class Experto extends Categoria{
    public Experto() {
        super();
    }
    @Override
    public double sueldoBruto(double sueldoBase, int antiguedad) {
        return sueldoBase * (1.5 + antiguedad *  0.015);
    }
}