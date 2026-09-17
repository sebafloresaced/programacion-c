package ej8;

public class ColectivoLinea extends Colectivo {
    public ColectivoLinea(String modelo, int cantidadPasajeros) {
        super(modelo, cantidadPasajeros);
    }
    @Override
    public boolean aceptoChofer(Chofer chofer) {
        return chofer.getCategoria().getHabilitaColectivo();
    }
    @Override
    public String toString() {
        return "Colectivo de linea - " + super.toString();
    }
}
