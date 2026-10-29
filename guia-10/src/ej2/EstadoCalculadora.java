package ej2;

public interface EstadoCalculadora {
    void ingresarDigito(Calculadora calculadora, int digito);
    void ingresarOperador(Calculadora calculadora, char operador);
    void igual(Calculadora calculadora);
    void cancelar(Calculadora calculadora);
}