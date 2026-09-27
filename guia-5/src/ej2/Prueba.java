package ej2;

public class Prueba {

    public static void main(String[] args) {

        Biblioteca biblioteca = new Biblioteca();

        Libro libro = new Libro(
            "1984",
            1,
            1949
        );

        Revista revista = new Revista(
            "National Geographic",
            2,
            2026,
            10
        );

        CD cd = new CD(
            "Abbey Road",
            3,
            "The Beatles"
        );

        cd.agregarCancion(
            new Cancion(1, "Come Together", 4.20)
        );

        cd.agregarCancion(
            new Cancion(2, "Something", 3.03)
        );

        biblioteca.agregarElemento(libro);
        biblioteca.agregarElemento(revista);
        biblioteca.agregarElemento(cd);

        for (ElementoBiblioteca elemento : biblioteca.getElementos()) {
            System.out.println(elemento);
            System.out.println();
        }
    }
}