package ej8;

public class Gol {
    private Jugador jugador;
    private Equipo equipo;
    public Gol(Jugador jugador, Equipo equipo) {
        this.jugador = jugador;
        this.equipo = equipo;
    }
    public Jugador getJugador() {
        return jugador;
    }
    public Equipo getEquipo() {
        return equipo;
    }
    @Override
    public String toString() {
        return jugador.getNombre()
             + " (" + equipo.getNombre() + ")";
    }
}