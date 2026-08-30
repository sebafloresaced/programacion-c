package ej6;

public class Prueba {

    public static void main(String[] args) {

        Estacion estacion = new Estacion();

        // Crear surtidores
        Surtidor surtidor1 = estacion.CrearSurtidor();
        Surtidor surtidor2 = estacion.CrearSurtidor();
        Surtidor surtidor3 = estacion.CrearSurtidor();

        System.out.println("Cantidad de surtidores: "
                           + estacion.cantidadSurtidores());

        System.out.println("\nDISPONIBILIDAD INICIAL");

        System.out.println("Gasoil: "
                           + estacion.getLitrosDisponibles("Gasoil"));

        System.out.println("Premium: "
                           + estacion.getLitrosDisponibles("Premium"));

        System.out.println("Super: "
                           + estacion.getLitrosDisponibles("Super"));

        // Ventas del surtidor 1
        System.out.println("\nVENTAS DEL SURTIDOR 1");

        System.out.println("Carga completa: "
                           + surtidor1.extraerGasoil(5000));

        System.out.println("Carga completa: "
                           + surtidor1.extraerGasoil(3000));

        System.out.println("Carga completa: "
                           + surtidor1.extraerPremium(2000));

        // Ventas del surtidor 2
        System.out.println("\nVENTAS DEL SURTIDOR 2");

        System.out.println("Carga completa: "
                           + surtidor2.extraerGasoil(8000));

        System.out.println("Carga completa: "
                           + surtidor2.extraerPremium(4000));

        // Ventas del surtidor 3
        System.out.println("\nVENTAS DEL SURTIDOR 3");

        /*
         * Pide 25000 litros, pero el surtidor solamente tiene 20000.
         * Debe entregar los 20000 disponibles y devolver false.
         */
        System.out.println("Carga completa: "
                           + surtidor3.extraerGasoil(25000));

        System.out.println("Carga completa: "
                           + surtidor3.extraerSuper(6000));

        // Disponibilidad restante
        System.out.println("\nDISPONIBILIDAD DESPUÉS DE LAS VENTAS");

        System.out.println("Gasoil: "
                           + estacion.getLitrosDisponibles("Gasoil"));

        System.out.println("Premium: "
                           + estacion.getLitrosDisponibles("Premium"));

        System.out.println("Super: "
                           + estacion.getLitrosDisponibles("Super"));

        // Surtidor con mayor cantidad de ventas
        System.out.println("\nMAYOR CANTIDAD DE VENTAS");

        System.out.println(
            "Surtidor con más ventas de Gasoil: "
            + estacion.mayorVentasCombustible("Gasoil")
        );

        System.out.println(
            "Surtidor con más ventas de Premium: "
            + estacion.mayorVentasCombustible("Premium")
        );

        System.out.println(
            "Surtidor con más ventas de Super: "
            + estacion.mayorVentasCombustible("Super")
        );

        // Históricos
        System.out.println("\nHISTÓRICO DE COMBUSTIBLES");

        System.out.println(
            "Gasoil vendido: "
            + estacion.historialCombustible("Gasoil")
        );

        System.out.println(
            "Premium vendido: "
            + estacion.historialCombustible("Premium")
        );

        System.out.println(
            "Super vendido: "
            + estacion.historialCombustible("Super")
        );

        System.out.println("\nHISTÓRICO POR SURTIDOR");

        System.out.println(
            "Surtidor 1: "
            + estacion.historialSurtidor(surtidor1.getId())
        );

        System.out.println(
            "Surtidor 2: "
            + estacion.historialSurtidor(surtidor2.getId())
        );

        System.out.println(
            "Surtidor 3: "
            + estacion.historialSurtidor(surtidor3.getId())
        );

        System.out.println(
            "\nHistórico de toda la estación: "
            + estacion.historialEstacion()
        );

        // Reposición
        System.out.println("\nREPOSICIÓN DE GASOIL DEL SURTIDOR 3");

        surtidor3.llenarDepositoGasoil();

        System.out.println(
            "Gasoil disponible después de reponer: "
            + estacion.getLitrosDisponibles("Gasoil")
        );

        /*
         * El histórico no debe cambiar por una reposición.
         */
        System.out.println(
            "Histórico de gasoil después de reponer: "
            + estacion.historialCombustible("Gasoil")
        );
    }
}