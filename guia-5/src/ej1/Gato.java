package ej1;

public class Gato extends Animal implements Emisor_de_Sonido {
    public Gato(String nombre, int esperanzaDeVida) {
        super(nombre, esperanzaDeVida);
    }
    @Override
    public void emiteSonido() {
        System.out.println("miau");
    }
}