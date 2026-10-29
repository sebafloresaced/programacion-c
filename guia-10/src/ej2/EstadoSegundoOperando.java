package ej2;

public class EstadoSegundoOperando implements EstadoCalculadora {

    @Override
    public void ingresarDigito(Calculadora calculadora, int digito) {
        double numero = calculadora.getSegundoOperando();
        numero = numero * 10 + digito;
        calculadora.setSegundoOperando(numero);
        calculadora.setPantalla(String.valueOf(numero));
    }

    @Override
    public void ingresarOperador(Calculadora calculadora, char operador) {
        // Ignoramos los operadores mientras ingresamos el segundo numero.
    }

    @Override
    public void igual(Calculadora calculadora) {
        double primero = calculadora.getPrimerOperando();
        double segundo = calculadora.getSegundoOperando();
        char operador = calculadora.getOperador();
        double resultado;
        switch (operador) {
            case '+':
                resultado = primero + segundo;
                break;
            case '-':
                resultado = primero - segundo;
                break;
            case '*':
                resultado = primero * segundo;
                break;
            case '/':
                if (segundo == 0) {
                    calculadora.setPantalla("Error");
                    calculadora.setEstado(new EstadoError());
                    return;
                }
                resultado = primero / segundo;
                break;
            default:
                return;
        }

        calculadora.setPrimerOperando(resultado);
        calculadora.setSegundoOperando(0);
        calculadora.setOperador(' ');
        calculadora.setPantalla(String.valueOf(resultado));
        calculadora.setEstado(new EstadoPrimerOperando());
    }

    @Override
    public void cancelar(Calculadora calculadora) {
        calculadora.reiniciar();
    }
}