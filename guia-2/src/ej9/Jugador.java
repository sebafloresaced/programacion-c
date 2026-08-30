package ej9;

public class Jugador {
    private String nombre;
    private int puntaje;
    private int partidosJugados;
    private int partidosGanados;
    private int partidosEmpatados;
    private int partidosPerdidos;

    public Jugador(String nombre) {
        this.nombre = nombre;
        puntaje = 0;
        partidosJugados = 0;
        partidosGanados = 0;
        partidosEmpatados = 0;
        partidosPerdidos = 0;
    }
    public String getNombre() {
        return nombre;
    }
    public int getPuntaje() {
        return puntaje;
    }
    public int getPartidosJugados() {
        return partidosJugados;
    }
    public int getPartidosGanados() {
        return partidosGanados;
    }
    public int getPartidosEmpatados() {
        return partidosEmpatados;
    }
    public int getPartidosPerdidos() {
        return partidosPerdidos;
    }
    public void registrarVictoria() {
        puntaje += 3;
        partidosJugados++;
        partidosGanados++;
    }
    public void registrarEmpate() {
        puntaje++;
        partidosJugados++;
        partidosEmpatados++;
    }
    public void registrarDerrota() {
        partidosJugados++;
        partidosPerdidos++;
    }
    @Override
    public String toString() {
        return nombre
             + " - Puntos: " + puntaje
             + " - PJ: " + partidosJugados
             + " - PG: " + partidosGanados
             + " - PE: " + partidosEmpatados
             + " - PP: " + partidosPerdidos;
    }
}