package ej4;

public class Prueba {

    public static void main(String[] args) {

        ConjuntoNumeros conjunto1 = new ConjuntoNumeros("Original", 5);
        
        // inciso a
        conjunto1.getCelda()[0] = 10;
        conjunto1.getCelda()[1] = 20;
        conjunto1.getCelda()[2] = 30;

        // inciso b
        conjunto1.getNumeros().add(new Numero(10));

        ConjuntoNumeros conjunto2 = (ConjuntoNumeros) conjunto1.clone();

        System.out.println("Antes del cambio:");
        System.out.println("Original: " + conjunto1);
        System.out.println("Clon:     " + conjunto2);

        // Modificamos solamente el clon
        // inciso a
        conjunto2.getCelda()[0] = 999;

        // inciso b
        conjunto2.getNumeros().get(0).setDato(888);

        System.out.println("\nDespues del cambio:");
        System.out.println("Original: " + conjunto1);
        System.out.println("Clon:     " + conjunto2);
    }
}