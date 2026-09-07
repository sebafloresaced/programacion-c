package ej5;

public class Prueba {

    public static void main(String[] args) {

        AutomovilManual manual = new AutomovilManual("ABC123");
        AutomovilAutomatico automatico = new AutomovilAutomatico("XYZ789");

        System.out.println("=== AUTOMOVIL MANUAL ===");

        System.out.println(manual);

        manual.cambiarMarcha(1);
        manual.acelerar(10);
        System.out.println(manual);

        manual.cambiarMarcha(2);
        manual.acelerar(20);
        System.out.println(manual);

        manual.frenar(15);
        System.out.println(manual);


        System.out.println("\n=== AUTOMOVIL AUTOMATICO ===");

        System.out.println(automatico);

        automatico.acelerar(8);
        System.out.println(automatico);

        automatico.acelerar(20);
        System.out.println(automatico);

        automatico.acelerar(30);
        System.out.println(automatico);

        automatico.frenar(40);
        System.out.println(automatico);
    }
}