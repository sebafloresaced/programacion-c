package ej2;

public class Calculadora {
    private double primerOperando;
    private double segundoOperando;
    private char operador;
    private String pantalla;
    private EstadoCalculadora estado;

    public Calculadora() {
        reiniciar();
    }

    // Acciones que recibira desde la ventana.
    public void ingresarDigito(int digito) {
        estado.ingresarDigito(this, digito);
    }

    public void ingresarOperador(char operador) {
        estado.ingresarOperador(this, operador);
    }

    public void igual() {
        estado.igual(this);
    }

    public void cancelar() {
        estado.cancelar(this);
    }

    // Restablece los datos y el estado inicial.
    public void reiniciar() {
        primerOperando = 0;
        segundoOperando = 0;
        operador = ' ';
        pantalla = "0";
        estado = new EstadoPrimerOperando();
    }

    // Metodos utilizados por los estados.
    public void setEstado(EstadoCalculadora estado) {
        this.estado = estado;
    }

    public double getPrimerOperando() {
        return primerOperando;
    }

    public void setPrimerOperando(double primerOperando) {
        this.primerOperando = primerOperando;
    }

    public double getSegundoOperando() {
        return segundoOperando;
    }

    public void setSegundoOperando(double segundoOperando) {
        this.segundoOperando = segundoOperando;
    }

    public char getOperador() {
        return operador;
    }

    public void setOperador(char operador) {
        this.operador = operador;
    }

    public String getPantalla() {
        return pantalla;
    }

    public void setPantalla(String pantalla) {
        this.pantalla = pantalla;
    }
}