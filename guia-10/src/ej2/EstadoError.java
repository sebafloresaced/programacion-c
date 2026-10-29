package ej2;

public class EstadoError implements EstadoCalculadora {
    @Override
    public void ingresarDigito(Calculadora calculadora, int digito) {
        // Ignora los digitos.
    }

    @Override
    public void ingresarOperador(Calculadora calculadora, char operador) {
        // Ignora los operadores.
    }

    @Override
    public void igual(Calculadora calculadora) {
        // Ignora el igual.
    }

    @Override
    public void cancelar(Calculadora calculadora) {
        calculadora.reiniciar();
    }
}