package ej7;

public class Principal {
    public static void main(String[] args) {
        // Inciso A
        // int capacidad = 3;
        // int personasOrilla0 = 6;
        // int personasOrilla1 = 6;
        // Bote bote = new Bote(capacidad, personasOrilla0, personasOrilla1, false);
        // Inciso B
        int capacidad = 3;
        int personasOrilla0 = 8;
        int personasOrilla1 = 2;
        Bote bote = new Bote(capacidad, personasOrilla0, personasOrilla1, true);
        for (int i = 1; i <= personasOrilla0; i++) {
            Persona persona = new Persona("Persona A" + i, 0, bote);
            new Thread(persona).start();
        }
        for (int i = 1; i <= personasOrilla1; i++) {
            Persona persona = new Persona("Persona B" + i, 1, bote);
            new Thread(persona).start();
        }
        new Thread(bote, "Bote").start();
    }
}