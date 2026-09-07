package ej4;

import java.util.ArrayList;

public class Prueba {

    public static void main(String[] args) {

        // DEPARTAMENTOS
        Departamento mantenimiento = new Departamento("Mantenimiento");
        Departamento contabilidad = new Departamento("Contabilidad");


        // =========================
        // MANTENIMIENTO
        // =========================

        EmpleadoPermanente juan = new EmpleadoPermanente(
                "Juan Perez",
                1234,
                "Matheu",
                2343,
                new Intermedio(),
                12000
        );
        juan.setAntiguedad(7);


        EmpleadoTemporal julio = new EmpleadoTemporal(
                "Julio Garcia",
                3209,
                "Colon",
                5561,
                80
        );
        julio.cargarHoras(160);


        EmpleadoTemporal martin = new EmpleadoTemporal(
                "Martin Rodriguez",
                3210,
                "Legajo",
                3210,
                70
        );
        martin.cargarHoras(100);


        mantenimiento.agregarEmpleado(juan);
        mantenimiento.agregarEmpleado(julio);
        mantenimiento.agregarEmpleado(martin);


        // =========================
        // CONTABILIDAD
        // =========================

        EmpleadoPermanente mara = new EmpleadoPermanente(
                "Mara Anchorena",
                9876,
                "Luro",
                3489,
                new Experto(),
                13000
        );
        mara.setAntiguedad(18);


        EmpleadoPermanente sandra = new EmpleadoPermanente(
                "Sandra Fernandez",
                1276,
                "Cordoba",
                3843,
                new Principiante(),
                11500
        );
        sandra.setAntiguedad(6);


        EmpleadoPermanente luis = new EmpleadoPermanente(
                "Luis Gomez",
                1544,
                "Formosa",
                2354,
                new Principiante(),
                10500
        );
        luis.setAntiguedad(2);


        EmpleadoPermanente lucas = new EmpleadoPermanente(
                "Lucas Benitez",
                1634,
                "Castelli",
                4563,
                new Intermedio(),
                0
        );
        lucas.setAntiguedad(12);


        contabilidad.agregarEmpleado(mara);
        contabilidad.agregarEmpleado(sandra);
        contabilidad.agregarEmpleado(luis);
        contabilidad.agregarEmpleado(lucas);


        // =========================
        // GENERAR PLANILLAS
        // =========================

        ArrayList<ItemPlanilla> planillaMantenimiento =
                mantenimiento.generarPlanilla();

        ArrayList<ItemPlanilla> planillaContabilidad =
                contabilidad.generarPlanilla();


        // MOSTRAR PLANILLA MANTENIMIENTO

        System.out.println("PLANILLA DE MANTENIMIENTO");

        for (ItemPlanilla item : planillaMantenimiento) {
            System.out.println(
                    item.getNombreEmpleado()
                    + " - Sueldo neto: $"
                    + item.getSueldoNeto()
            );
        }


        // MOSTRAR PLANILLA CONTABILIDAD

        System.out.println("\nPLANILLA DE CONTABILIDAD");

        for (ItemPlanilla item : planillaContabilidad) {
            System.out.println(
                    item.getNombreEmpleado()
                    + " - Sueldo neto: $"
                    + item.getSueldoNeto()
            );
        }
    }
}