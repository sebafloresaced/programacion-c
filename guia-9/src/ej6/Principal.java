package ej6;

public class Principal {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        for (int i = 1; i <= 10; i++) {
            SocioLibro socioLibro = new SocioLibro("SocioLibro " + i, biblioteca);
            SocioRevista socioRevista = new SocioRevista("SocioRevista " + i, biblioteca);
            new Thread(socioLibro).start();
            new Thread(socioRevista).start();
        }
    }
}