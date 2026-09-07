package ej4;

public class Principiante extends Categoria {
    public Principiante() {
        super();
    }
    @Override
    public double sueldoBruto(double sueldoBase, int antiguedad) {
        if (antiguedad < 2) {
            return sueldoBase;
        }
        else if (antiguedad < 5) {
            return sueldoBase * 1.05;
        }
        else if (antiguedad < 10) {
            return sueldoBase * 1.07;
        }
        else if (antiguedad < 15) {
            return sueldoBase * 1.1;
        }
        else if (antiguedad < 20) {
            return sueldoBase * 1.15;
        }
        else {
            return sueldoBase * 1.2;
        }
    }
}
