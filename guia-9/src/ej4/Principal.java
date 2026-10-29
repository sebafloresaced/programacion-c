package ej4;

public class Principal {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        for (int i = 1; i <= 10; i++) {
            Socio socio = new Socio("Socio " + i, biblioteca, 3);
            Thread hilo = new Thread(socio, "Socio " + i);
            hilo.start();
        }
    }
}