package ej8;

public class Prueba {

    public static void main(String[] args) {

        Empresa empresa = new Empresa();

        Categoria cat1 =
            new Categoria("Categoria 1", 10000,
                          true, false, false);

        Categoria cat2 =
            new Categoria("Categoria 2", 15000,
                          true, true, false);

        Categoria cat3 =
            new Categoria("Categoria 3", 15000,
                          false, false, true);

        Categoria cat4 =
            new Categoria("Categoria 4", 17000,
                          true, true, true);


        ColectivoLinea colectivo =
            new ColectivoLinea("Mercedes Benz 1114", 40);

        Micro micro =
            new Micro("Mercedes Benz O500", 50, true);

        Camion camion =
            new Camion("Scania R450", 50, 8000, 20000);


        Acoplado acoplado =
            new Acoplado(3000, 15000, 1, true);


        empresa.agregarVehiculo(colectivo);
        empresa.agregarVehiculo(micro);
        empresa.agregarVehiculo(camion);

        empresa.agregarAcoplado(acoplado);

        // Suponiendo que ya tenés tu clase Domicilio:
        Domicilio d1 = new Domicilio("Tomas Guido", 400, "Mar del Plata");
        Domicilio d2 = new Domicilio("Juan B Justo",3400, "Mar del Plata");
        Domicilio d3 = new Domicilio("San Juan" , 100, "Mar del Plata");

        Chofer juan = new Chofer("Juan", cat1, d1);
        Chofer pedro = new Chofer("Pedro", cat2, d2);
        Chofer lucas = new Chofer("Lucas", cat3, d3);

        empresa.agregarChofer(juan);
        empresa.agregarChofer(pedro);
        empresa.agregarChofer(lucas);


        System.out.println(
            empresa.vincularChoferVehiculo(juan, colectivo)
        );

        System.out.println(
            empresa.vincularChoferVehiculo(pedro, micro)
        );

        System.out.println(
            empresa.vincularChoferVehiculo(lucas, camion)
        );

        camion.engancharAcoplado(acoplado);


        empresa.mostrarChoferes();

        System.out.println(
            "Choferes categoria 1: " +
            empresa.cantidadChoferesCategoria(cat1)
        );

        System.out.println(
            "Sin vehiculo: " +
            empresa.cantidadChoferesSinVehiculo()
        );

        System.out.println(
            "Vehiculos: " +
            empresa.cantidadVehiculos()
        );

        System.out.println(
            "Acoplados: " +
            empresa.cantidadAcoplados()
        );
    }
}