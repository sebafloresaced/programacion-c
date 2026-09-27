package ej5;

public class Gato extends Animal {
    private int edad;
    
    public Gato(String nombre, int esperanzaDeVida, int edad) {
        super(nombre, esperanzaDeVida);
        this.edad = edad;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    @Override
    public String toString() {
        return super.toString() + " - Edad: " + edad;
    }
}
