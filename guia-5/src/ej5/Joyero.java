package ej5;

public class Joyero extends Artesano {
    public Joyero(String nombre) {
        super(nombre);
    }
    @Override
    public String trabajar(Material mat) {
        return getNombre() + mat.trabajadoJoyero();
    }
}
