package ej1;

import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class Mascota implements Runnable {
    private String nombre;
    private Random random;
    private String necesidad;
    private final List<Observador> observadores = new ArrayList<>();

    public Mascota(String nombre) {
        this.nombre = nombre;
        this.necesidad = "";
        this.random = new Random();
    }

    public String getNombre() {
        return nombre;
    }
    
    public String getNecesidad() {
        return necesidad;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                int segundos = random.nextInt(8) + 3; // genero un entero de 0 a 7 y le sumo 3
                Thread.sleep(segundos * 1000); // convierto seg en miliseg
                necesidad = generarNecesidad();
                notificarObservadores();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    private String generarNecesidad() {
        int opcion = random.nextInt(3);
        switch (opcion) {
            case 0:
                return "tiene sed";
            case 1:
                return "tiene hambre";
            default:
                return "esta aburrida y quiere jugar";
        }
    }
    
    // ---------- Observable ----------
        public void agregarObservador(Observador o) {
            observadores.add(o);
        }

        public void quitarObservador(Observador o) {
            observadores.remove(o);
        }

        public void notificarObservadores() {
            for (Observador o : observadores) {
                o.actualizar(this);     // estilo "pull": el observador lee lo que necesita
            }
        }
}