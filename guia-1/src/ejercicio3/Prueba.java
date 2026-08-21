package ejercicio3;

public class Prueba {
    public static void main(String[] args) {
        Categoria Principiante = new Categoria("Principiante",80);
        Categoria Operario = new Categoria("Operario",100);
        Categoria Experto = new Categoria("Experto",130);
        Empleado Juan = new Empleado();
        Juan.setNombre("Juan Perez");
        Juan.setAntiguedad(4);
        Juan.setHsTrabajadas(100);
        Juan.setCat(Principiante);
        Empleado Roberto = new Empleado();
        Roberto.setNombre("Roberto Gonzalez");
        Roberto.setAntiguedad(8);
        Roberto.setHsTrabajadas(120);
        Roberto.setCat(Principiante);
        Empleado Sandra = new Empleado();
        Sandra.setNombre("Sandra Lopez");
        Sandra.setAntiguedad(14);
        Sandra.setHsTrabajadas(120);
        Sandra.setCat(Principiante);
        Empleado German = new Empleado();
        German.setNombre("German Gutierrez");
        German.setAntiguedad(16);
        German.setHsTrabajadas(110);
        German.setCat(Operario);
        Empleado Vicente = new Empleado();
        Vicente.setNombre("Vicente Hernandez");
        Vicente.setAntiguedad(9);
        Vicente.setHsTrabajadas(100);
        Vicente.setCat(Experto);
        Empleado Carolina = new Empleado();
        Carolina.setNombre("Carolina Gomez");
        Carolina.setAntiguedad(20);
        Carolina.setHsTrabajadas(115);
        Carolina.setCat(Experto);
        
        System.out.println("Empleado: " + Juan.getNombre() + "  Saldo: " + Juan.sueldo());        
        System.out.println("\nEmpleado: " + Roberto.getNombre() + "  Saldo: " + Roberto.sueldo());        
        System.out.println("\nEmpleado: " + Sandra.getNombre() + "  Saldo: " + Sandra.sueldo());        
        System.out.println("\nEmpleado: " + German.getNombre() + "  Saldo: " + German.sueldo());        
        System.out.println("\nEmpleado: " + Vicente.getNombre() + "  Saldo: " + Vicente.sueldo());        
        System.out.println("\nEmpleado: " + Carolina.getNombre() + "  Saldo: " + Carolina.sueldo());
    }
}
