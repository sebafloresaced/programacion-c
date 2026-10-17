package ej4.modelo;

public class FaltaCombustibleException extends Exception {
    private DatoCargaInvalida datosCarga;

    public FaltaCombustibleException(DatoCargaInvalida datosCarga) {
        super("No hay suficiente combustible para completar la carga");
        this.datosCarga = datosCarga;
    }

    public DatoCargaInvalida getDatosCarga() {
        return datosCarga;
    }
}