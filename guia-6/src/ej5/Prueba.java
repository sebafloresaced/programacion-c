package ej5;

public class Prueba {

    public static void main(String[] args) {

        Domicilio domicilio1 = new Domicilio("Colon", 2500);
        Perro perro = new Perro("Firulais", 15, 5);

        Persona personaConPerro =
            new Persona("Juan", 12345678, domicilio1, perro);


        Domicilio domicilio2 = new Domicilio("Independencia", 3000);
        Gato gato = new Gato("Michi", 18, 3);

        Persona personaConGato =
            new Persona("Pedro", 87654321, domicilio2, gato);


        // Persona con perro
        try {

            Persona clonPerro =
                (Persona) personaConPerro.clone();

            System.out.println("PERSONA CON PERRO");
            System.out.println("Original: " + personaConPerro);
            System.out.println("Clon:     " + clonPerro);

            // Modificamos objetos internos del clon
            clonPerro.getDomicilio().setCalle("Luro");
            clonPerro.getMascota().setNombre("Toby");

            System.out.println("\nLuego de modificar el clon:");

            System.out.println("Original: " + personaConPerro);
            System.out.println("Clon:     " + clonPerro);

        } catch (CloneNotSupportedException e) {

            System.out.println(
                "No se pudo clonar la persona con perro"
            );
        }


        System.out.println("\n--------------------------\n");


        // Persona con gato
        try {

            Persona clonGato =
                (Persona) personaConGato.clone();

            System.out.println("PERSONA CON GATO");
            System.out.println("Original: " + personaConGato);
            System.out.println("Clon:     " + clonGato);

        } catch (CloneNotSupportedException e) {

            System.out.println(
                "No se pudo clonar la persona con gato"
            );
        }
    }
}