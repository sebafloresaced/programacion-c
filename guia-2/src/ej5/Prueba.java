package ej5;

public class Prueba {
    public static void main(String[] args) {
        Empresa empresa = new Empresa();
        // Crear categorías
        Categoria principiante = empresa.crearCategoria("Principiante", 700000);
        Categoria experimentado = empresa.crearCategoria("Experimentado", 950000);
        Categoria profesional = empresa.crearCategoria("Profesional", 1200000);
        // Crear colectivos
        Colectivo colectivo1 = empresa.crearColectivo("Mercedes Benz");
        Colectivo colectivo2 = empresa.crearColectivo("Iveco");
        Colectivo colectivo3 = empresa.crearColectivo("Scania");
        // Crear choferes inicialmente sin colectivo
        Chofer chofer1 = empresa.crearChofer("Juan", "Colón", 1500, principiante);
        Chofer chofer2 = empresa.crearChofer("María", "Independencia", 2450, experimentado);
        Chofer chofer3 = empresa.crearChofer("Carlos", "Luro", 3200, experimentado);
        Chofer chofer4 = empresa.crearChofer("Ana", "Constitución", 1800, profesional);
        // Asignar colectivos
        chofer1.asignarColectivo(colectivo1);
        chofer2.asignarColectivo(colectivo2);
        chofer4.asignarColectivo(colectivo3);
        // El chofer3 queda sin colectivo
        System.out.println("INFORMACIÓN DE LOS CHOFERES");
        System.out.println("--------------------------------");
        chofer1.informe();
        chofer2.informe();
        chofer3.informe();
        chofer4.informe();
        // Consultas solicitadas
        System.out.println("\nCONSULTAS");
        System.out.println("--------------------------------");
        System.out.println(
            "Choferes sin colectivo: "
            + empresa.cantChoferesSinColectivo()
        );
        System.out.println(
            "Cantidad total de colectivos: "
            + empresa.cantColectivos()
        );
        System.out.println();
        empresa.getChoferesCategoria(experimentado);
        System.out.println();
        empresa.getCategoriasSupMonto(800000);
        System.out.println();
        empresa.getChoferesSueldoSupMonto(900000);
        // Probar la desvinculación
        System.out.println("\nDESVINCULACIÓN");
        System.out.println("--------------------------------");
        System.out.println("Se desvincula el colectivo de María.");
        chofer2.desasignarColectivo();
        chofer2.informe();
        System.out.println(
            "Choferes sin colectivo después de desvincular: "
            + empresa.cantChoferesSinColectivo()
        );
    }
}
