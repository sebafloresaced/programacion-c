package ej8;

import java.time.LocalDate;
import java.util.ArrayList;

public class Torneo {
    private static Torneo instancia; 
    private ArrayList<Equipo> equipos;
    private ArrayList<Partido> partidos;
 
    private Torneo() { // privado por el singleton
        equipos = new ArrayList<>();
        partidos = new ArrayList<>();
    }
    public static Torneo getInstancia() { // singleton
        if (instancia == null) {
            instancia = new Torneo();
        }
        return instancia;
    }
    public boolean agregarEquipo(Equipo equipo) {
        for (Equipo actual : equipos) {
            if (actual.getNombre().equalsIgnoreCase(
                    equipo.getNombre())) {
                return false;
            }
        }
        equipos.add(equipo);
        return true;
    }
    public Partido crearPartido(Equipo local,Equipo visitante,int dia,int mes,int anio) {
        if (local == visitante
                || !equipos.contains(local)
                || !equipos.contains(visitante)) {
            return null;
        }
        Partido partido = new Partido(
            local,
            visitante,
            LocalDate.of(anio, mes, dia)
        );
        partidos.add(partido);
        return partido;
    }
    public Equipo equipoConMayorPuntaje() {
        if (equipos.isEmpty()) {
            return null;
        }
        Equipo mejor = equipos.get(0);
        for (int i = 1; i < equipos.size(); i++) {
            if (equipos.get(i).tieneMejorPuntajeQue(mejor)) {
                mejor = equipos.get(i);
            }
        }
        return mejor;
    }
    public Jugador goleadorDelTorneo() {
        Jugador goleador = null;
        for (Equipo equipo : equipos) {
            Jugador goleadorEquipo = equipo.goleador();
            if (goleadorEquipo != null
                    && (goleador == null
                    || goleadorEquipo.getCantGoles()
                       > goleador.getCantGoles())) {
                goleador = goleadorEquipo;
            }
        }
        return goleador;
    }
}