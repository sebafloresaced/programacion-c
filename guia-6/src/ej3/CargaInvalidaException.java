package ej3;

public class CargaInvalidaException extends Exception {
    private DatoCargaInvalido datoCargaInvalido;
    
    public CargaInvalidaException(String mensaje, String combustible, double cantidadRequerida, double cantidadDisponible) {
        super(mensaje);  
        datoCargaInvalido = new DatoCargaInvalido(combustible,cantidadRequerida,cantidadDisponible);                                                                 
    }
    public DatoCargaInvalido getDatoCargaInvalido() {
        return datoCargaInvalido;
    }
}
