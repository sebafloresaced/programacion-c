package ej1;

public class Principal {
    public static void main(String[] args) {
        int caso = 1;
        ViaCompartida via = new ViaCompartida(caso);
        for (int i = 1; i <= 5; i++) {
            Tren tren0 = new Tren("Tren A" + i, 0, via);
            Tren tren1 = new Tren("Tren B" + i, 1, via);
            new Thread(tren0).start();
            new Thread(tren1).start();
        }
    }
}