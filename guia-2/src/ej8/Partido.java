package ej8;

import java.time.LocalDate;
import java.util.ArrayList;

public class Partido {
    private Equipo equipoLocal;
    private Equipo equipoVisitante;
    private LocalDate fecha;
    private ArrayList<Gol> goles;
    private boolean finalizado;

    public Partido(Equipo equipoLocal,
                   Equipo equipoVisitante,
                   LocalDate fecha) {
        if (equipoLocal == equipoVisitante) {
            throw new IllegalArgumentException(
                "Un equipo no puede jugar contra sí mismo"
            );
        }
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
        this.fecha = fecha;
        goles = new ArrayList<>();
        finalizado = false;
    }
    public boolean registrarGol(Jugador jugador) {
        if (finalizado) {
            return false;
        }
        Equipo equipoDelJugador;
        if (equipoLocal.contieneJugador(jugador)) {
            equipoDelJugador = equipoLocal;
        } else if (equipoVisitante.contieneJugador(jugador)) {
            equipoDelJugador = equipoVisitante;
        } else {
            return false;
        }
        goles.add(new Gol(jugador, equipoDelJugador));
        jugador.registrarGoles(1);

        return true;
    }
    public int golesDelEquipo(Equipo equipo) {
        int cantidad = 0
        for (Gol gol : goles) {
            if (gol.getEquipo() == equipo) {
                cantidad++;
            }
        }
        return cantidad;
    }
    public boolean finalizarPartido() {
        if (finalizado) {
            return false;
        }
        int golesLocal = golesDelEquipo(equipoLocal);
        int golesVisitante = golesDelEquipo(equipoVisitante);
        equipoLocal.registrarResultado(
            golesLocal, golesVisitante
        );
        equipoVisitante.registrarResultado(
            golesVisitante, golesLocal
        );
        finalizado = true;
        return true;
    }
    public String detallePartido() {
        String detalle =
            equipoLocal.getNombre() + " "
            + golesDelEquipo(equipoLocal) + " - "
            + golesDelEquipo(equipoVisitante) + " "
            + equipoVisitante.getNombre()
            + "\nFecha: " + fecha
            + "\nGoles:";
        if (goles.isEmpty()) {
            detalle += "\nNo hubo goles";
        } else {
            for (Gol gol : goles) {
                detalle += "\n- " + gol;
            }
        }
        return detalle;
    }
    public boolean estaFinalizado() {
        return finalizado;
    }
}