package ej5;

public class Perro extends Animal implements Cloneable {
    private int edad;
    
    public Perro(String nombre, int esperanzaDeVida, int edad) {
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
        return (Perro)super.clone();
    }
    @Override
    public String toString() {
        return super.toString() + " - Edad: " + edad;
    }
}
