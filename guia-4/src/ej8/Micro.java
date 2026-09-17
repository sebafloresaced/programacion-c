package ej8;

public class Micro extends Colectivo {
    private boolean cocheCama;

    public Micro(String modelo, int cantidadPasajeros, boolean cocheCama) {
        super(modelo, cantidadPasajeros);
        this.cocheCama = cocheCama;
    }
    public boolean getCocheCama() {
        return cocheCama;
    }
    @Override
    public boolean aceptoChofer(Chofer chofer) {
        return chofer.getCategoria().getHabilitaMicro();
    }
    @Override
    public String toString() {
        return "Colectivo de larga distancia - " +
               super.toString() +
               " - Coche cama: " + cocheCama;
    }
}
