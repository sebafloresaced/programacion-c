package ej2;

public class Principal {
    public static void main(String[] args) {
        int cantidadPersonas = 3;
        int cantidadVueltas = 5;
        Mostrador mostrador = new Mostrador(cantidadPersonas);
        for (int numero = 1; numero <= cantidadPersonas; numero++) {
            Persona persona = new Persona(numero, cantidadVueltas, mostrador);
            Thread hilo = new Thread(persona, "Persona " + numero);
            hilo.start();
        }
    }
}