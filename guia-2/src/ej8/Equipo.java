package ej8;

import java.util.ArrayList;

public class Equipo {
    private String nombre;
    private ArrayList<Jugador> jugadores;
    private int cantGanados;
    private int cantPerdidos;
    private int cantEmpatados;
    private int cantGolesFavor;
    private int cantGolesContra;

    public Equipo(String nombre) {
        this.nombre = nombre;
        jugadores = new ArrayList<>();
        cantGanados = 0;
        cantPerdidos = 0;
        cantEmpatados = 0;
        cantGolesFavor = 0;
        cantGolesContra = 0;
    }
    public String getNombre() {
        return nombre;
    }
    public int getCantGolesFavor() {
        return cantGolesFavor;
    }
    public int getCantGolesContra() {
        return cantGolesContra;
    }
    public boolean agregarJugador(Jugador jugador) {
        for (Jugador actual : jugadores) {
            if (actual.getNombre().equalsIgnoreCase(jugador.getNombre())
                    || actual.getNroCamiseta()
                       == jugador.getNroCamiseta()) {
                return false;
            }
        }
        jugadores.add(jugador);
        return true;
    }
    public boolean contieneJugador(Jugador jugador) {
        return jugadores.contains(jugador);
    }
    public int cantidadPartidosJugados() {
        return cantGanados + cantEmpatados + cantPerdidos;
    }
    public int puntosObtenidos() {
        return cantGanados * 3 + cantEmpatados;
    }
    public void registrarResultado(int golesFavor, int golesContra) {
        cantGolesFavor += golesFavor;
        cantGolesContra += golesContra;
        if (golesFavor > golesContra) {
            cantGanados++;
        } else if (golesFavor < golesContra) {
            cantPerdidos++;
        } else {
            cantEmpatados++;
        }
        for (Jugador jugador : jugadores) {
            jugador.registrarPartido();
        }
    }
    public Jugador goleador() {
        if (jugadores.isEmpty()) {
            return null;
        }
        Jugador goleador = jugadores.get(0);
        for (int i = 1; i < jugadores.size(); i++) {
            if (jugadores.get(i).getCantGoles()
                    > goleador.getCantGoles()) {
                goleador = jugadores.get(i);
            }
        }
        return goleador;
    }
    public boolean tieneMejorPuntajeQue(Equipo otro) {
        if (puntosObtenidos() != otro.puntosObtenidos()) {
            return puntosObtenidos() > otro.puntosObtenidos();
        }
        if (cantGolesFavor != otro.cantGolesFavor) {
            return cantGolesFavor > otro.cantGolesFavor;
        }
        if (cantGolesContra != otro.cantGolesContra) {
            return cantGolesContra < otro.cantGolesContra;
        }
        // Si empatan en todo, se puede devolver cualquiera.
        return true;
    }
    @Override
    public String toString() {
        return nombre
             + " - Puntos: " + puntosObtenidos()
             + " - PJ: " + cantidadPartidosJugados()
             + " - GF: " + cantGolesFavor
             + " - GC: " + cantGolesContra;
    }
}