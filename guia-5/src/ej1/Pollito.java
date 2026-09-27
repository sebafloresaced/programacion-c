package ej1;

public class Pollito extends Animal implements Emisor_de_Sonido {
    public Pollito(String nombre, int esperanzaDeVida) {
        super(nombre, esperanzaDeVida);
    }
    @Override
    public void emiteSonido() {
        System.out.println("pio pio");
    }
}