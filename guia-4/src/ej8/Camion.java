package ej8;

public class Camion extends Vehiculo {
    private int tara;
    private int cargaMaxima;
    private Acoplado acoplado;

    public Camion(String modelo, int nroInterno, int tara, int cargaMaxima, Acoplado acoplado) {
        super(modelo, nroInterno);
        this.tara = tara;
        this.cargaMaxima = cargaMaxima;
        this.acoplado = acoplado;
        if (acoplado != null) {
            acoplado.setEnUso(true);
        }
    }

    public Camion(String modelo, int nroInterno, int tara, int cargaMaxima) {
        this(modelo, nroInterno, tara, cargaMaxima, null);
    }
    @Override
    public boolean aceptoChofer(Chofer chofer) {
        return chofer.getCategoria().getHabilitaCamion();
    }
    public boolean engancharAcoplado(Acoplado nuevoAcoplado) {
        if (acoplado == null &&
            nuevoAcoplado != null &&
            !nuevoAcoplado.getEnUso()) {
            acoplado = nuevoAcoplado;
            acoplado.setEnUso(true);
            return true;
        }
        return false;
    }
    public void desengancharAcoplado() {
        if (acoplado != null) {
            acoplado.setEnUso(false);
            acoplado = null;
        }
    }
    public Acoplado getAcoplado() {
        return acoplado;
    }
    @Override
    public String toString() {
        String resultado =
            "Camion - " +
            super.toString() +
            " - Tara: " + tara +
            " - Carga maxima: " + cargaMaxima;
        if (acoplado == null) {
            resultado += " - Sin acoplado";
        } else {
            resultado += " - " + acoplado;
        }
        return resultado;
    }
}
