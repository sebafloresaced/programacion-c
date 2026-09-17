package ej8;

public class Acoplado {
    private int tara;
    private int cargaMaxima;
    private int numeroAcoplado;
    private boolean refrigerado;
    private boolean enUso;

    public Acoplado(int tara, int cargaMaxima, int numeroAcoplado, boolean refrigerado) {
        this.tara = tara;
        this.cargaMaxima = cargaMaxima;
        this.numeroAcoplado = numeroAcoplado;
        this.refrigerado = refrigerado;
        enUso = false;
    }
    public boolean getEnUso() {
        return enUso;
    }
    public void setEnUso(boolean enUso) {
        this.enUso = enUso;
    }
    public int getNumeroAcoplado() {
        return numeroAcoplado;
    }
    @Override
    public String toString() {
        return "Acoplado " + numeroAcoplado +
               " - Tara: " + tara +
               " - Carga maxima: " + cargaMaxima +
               " - Refrigerado: " + refrigerado;
    }
}
