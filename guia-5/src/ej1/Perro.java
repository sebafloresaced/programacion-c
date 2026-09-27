package ej1;

public class Perro extends Animal implements Emisor_de_Sonido {
    public Perro(String nombre, int esperanzaDeVida) {
        super(nombre, esperanzaDeVida);
    }
    @Override
    public void emiteSonido() {
        System.out.println("guau");
    }
}
