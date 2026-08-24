package ejercicio6;

public class Prueba {
    public Prueba() {
        super();
    }

    public static void main(String[] args) {
        Socio s1,s2,s3;
        s1 = new Socio();
        s2 = new Socio();
        s3 = new Socio();
        s1.setNombre("Carlos");
        s2.setNombre("Franco");
        s3.setNombre("Andres");
        s1.setEdad(78);
        s2.setEdad(14);
        s3.setEdad(24);
        s1.setParticipaTorneo(0);
        s2.setParticipaTorneo(1);
        s3.setParticipaTorneo(0);
        System.out.println("Cuota de " + s1.getNombre() + ": $" + s1.calcularCuota());
        System.out.println("Cuota de " + s2.getNombre() + ": $" + s2.calcularCuota());
        System.out.println("Cuota de " + s2.getNombre() + ": $" + s3.calcularCuota());
    }
}
