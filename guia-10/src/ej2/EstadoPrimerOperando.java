package ej2;

public class EstadoPrimerOperando implements EstadoCalculadora {
    @Override
    public void ingresarDigito(Calculadora calculadora, int digito) {
        double numero = calculadora.getPrimerOperando();
        numero = numero * 10 + digito;
        calculadora.setPrimerOperando(numero);
        calculadora.setPantalla(String.valueOf(numero));
    }

    @Override
    public void ingresarOperador(Calculadora calculadora, char operador) {
        calculadora.setOperador(operador);
        calculadora.setSegundoOperando(0);
        calculadora.setEstado(new EstadoSegundoOperando());
    }

    @Override
    public void igual(Calculadora calculadora) {
        // Todavia no hay una operacion para resolver, por lo tanto se ignora
    }

    @Override
    public void cancelar(Calculadora calculadora) {
        calculadora.reiniciar();
    }
}