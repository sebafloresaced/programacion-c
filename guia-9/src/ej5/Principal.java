package ej5;

public class Principal {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        for (int i = 1; i <= 30; i++) {
            Socio socio = new Socio("Socio " + i, biblioteca, 10);
            new Thread(socio, "Socio " + i).start();
        }
        Donador donador = new Donador(biblioteca, 10);
        new Thread(donador, "Donador").start();
    }
}