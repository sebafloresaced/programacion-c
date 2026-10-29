package ej1;

public class ViaCompartida {
    private final int caso;

    private int circulando = 0;
    private int sentidoActual = -1;
    private int turno = 0;

    private final int[] esperando = new int[2];

    public ViaCompartida(int caso) {
        if (caso < 1 || caso > 4) {
            throw new IllegalArgumentException("Caso invalido");
        }
        this.caso = caso;
    }

    public synchronized void entrar(String nombre, int sentido) throws InterruptedException {
        esperando[sentido]++;
        try {
            while (!puedeEntrar(sentido)) {
                wait();
            }
            circulando++;
            sentidoActual = sentido;
            System.out.println(nombre + " entra en sentido " + sentido + ". Trenes dentro: " + circulando);
            Thread.sleep(1000);
        } finally {
            esperando[sentido]--;
            // Si un hilo deja de esperar por interrupcion,
            // puede cambiar la posibilidad de entrada de otros.
            notifyAll();
        }
    }

    private boolean puedeEntrar(int sentido) {
        int contrario = 1 - sentido;
        switch (caso) {
            case 1:
                return circulando == 0;
            case 2:
                return circulando == 0 && (esperando[contrario] == 0 || turno == sentido);
            case 3:
                return circulando == 0 || sentidoActual == sentido;
            case 4:
                if (circulando == 0) {
                    return esperando[contrario] == 0 || turno == sentido;
                }
                return sentidoActual == sentido && esperando[contrario] == 0;
            default:
                return false;
        }
    }

    public synchronized void salir(String nombre, int sentido) throws InterruptedException {
        circulando--;
        System.out.println(nombre + " sale del sentido " + sentido + ". Trenes dentro: " + circulando);
        Thread.sleep(1000);
        if (circulando == 0) {
            sentidoActual = -1;
            // Se da preferencia al sentido contrario.
            turno = 1 - sentido;
        }
        notifyAll();
    }
}