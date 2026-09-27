package ej1;

public class Vaca extends Animal implements Emisor_de_Sonido {
    public Vaca(String nombre, int esperanzaDeVida) {
        super(nombre, esperanzaDeVida);
    }
    @Override
    public void emiteSonido() {
        System.out.println("muuu");
    }
}