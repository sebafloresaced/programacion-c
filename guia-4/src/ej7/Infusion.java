package ej7;

public abstract class Infusion {
    public Infusion() {
        super();
    }
    public void prepararInfusion() {
        calentarAgua();
        agregarTipoInfusion();
        endulzar();
        System.out.println("Tomando bebida\n");
    }
    public void calentarAgua() {
        System.out.println("Calentando el agua\n");
    }
    public abstract void agregarTipoInfusion();
    public void endulzar() {
        System.out.println("La bebida se tomara amarga\n");
    }
}