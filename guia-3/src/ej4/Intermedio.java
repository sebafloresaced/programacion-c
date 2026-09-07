package ej4;

public class Intermedio extends Categoria{
    public Intermedio() {
        super();
    }
    @Override
    public double sueldoBruto(double sueldoBase, int antiguedad) {
        return sueldoBase * (1.25 + antiguedad * 0.01);
    }
}
