package ej1;

import java.util.ArrayList;

public class Prueba {

    public static void main(String[] args) {
        ArrayList<Emisor_de_Sonido> emisores = new ArrayList<>();

        emisores.add(new Perro("Firulais", 15));
        emisores.add(new Gato("Michi", 18));
        emisores.add(new Vaca("Lola", 20));
        emisores.add(new Pollito("Pio", 5));
        emisores.add(new Ambulancia("AB123CD", "Mercedes"));

        for (Emisor_de_Sonido emisor : emisores) {
            emisor.emiteSonido();
        }
    }
}