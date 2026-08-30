package ej9;

import java.util.ArrayList;

public class Equipo {
    private String nombre;
    private ArrayList<Jugador> jugadores;

    public Equipo(String nombre) {
        this.nombre = nombre;
        jugadores = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public boolean agregarJugador(Jugador jugador) {
        if (jugador != null && !jugadores.contains(jugador)) {
            jugadores.add(jugador);
            return true;
        }

        return false;
    }

    public boolean quitarJugador(Jugador jugador) {
        return jugadores.remove(jugador);
    }

    public boolean contieneJugador(Jugador jugador) {
        return jugadores.contains(jugador);
    }

    public int cantidadJugadores() {
        return jugadores.size();
    }

    public int calcularPuntaje() {
        int total = 0;

        for (Jugador jugador : jugadores) {
            total += jugador.getPuntaje();
        }

        return total;
    }

    public void registrarVictoria() {
        for (Jugador jugador : jugadores) {
            jugador.registrarVictoria();
        }
    }

    public void registrarEmpate() {
        for (Jugador jugador : jugadores) {
            jugador.registrarEmpate();
        }
    }

    public void registrarDerrota() {
        for (Jugador jugador : jugadores) {
            jugador.registrarDerrota();
        }
    }
    public String nombresJugadores() {
        String resultado = "";

        for (Jugador jugador : jugadores) {
            resultado += "\n- " + jugador.getNombre();
        }

        return resultado;
    }
    @Override
    public String toString() {
        String informacion =
            nombre + " - Puntaje total: " + calcularPuntaje();

        for (Jugador jugador : jugadores) {
            informacion += "\n- " + jugador.getNombre();
        }

        return informacion;
    }
}