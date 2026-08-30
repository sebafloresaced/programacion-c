package ej9;

import java.time.LocalDate;

public class Encuentro {
    private LocalDate fecha;
    private Equipo equipo1;
    private Equipo equipo2;
    private int golesEquipo1;
    private int golesEquipo2;
    private boolean finalizado;

    public Encuentro(int dia, int mes, int anio) {
        fecha = LocalDate.of(anio, mes, dia);
        equipo1 = new Equipo("Equipo 1");
        equipo2 = new Equipo("Equipo 2");
        finalizado = false;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public Equipo getEquipo1() {
        return equipo1;
    }

    public Equipo getEquipo2() {
        return equipo2;
    }

    public boolean agregarJugadorEquipo1(Jugador jugador) {
        if (finalizado || equipo2.contieneJugador(jugador)) {
            return false;
        }

        return equipo1.agregarJugador(jugador);
    }

    public boolean agregarJugadorEquipo2(Jugador jugador) {
        if (finalizado || equipo1.contieneJugador(jugador)) {
            return false;
        }

        return equipo2.agregarJugador(jugador);
    }

    public boolean quitarJugadorEquipo1(Jugador jugador) {
        if (finalizado) {
            return false;
        }

        return equipo1.quitarJugador(jugador);
    }

    public boolean quitarJugadorEquipo2(Jugador jugador) {
        if (finalizado) {
            return false;
        }

        return equipo2.quitarJugador(jugador);
    }

    public boolean equiposValidos() {
        return equipo1.cantidadJugadores() >= 4
            && equipo2.cantidadJugadores() >= 4
            && equipo1.cantidadJugadores()
               == equipo2.cantidadJugadores();
    }

    public boolean registrarResultado(int golesEquipo1,
                                      int golesEquipo2) {
        if (finalizado
                || golesEquipo1 < 0
                || golesEquipo2 < 0
                || !equiposValidos()) {
            return false;
        }

        this.golesEquipo1 = golesEquipo1;
        this.golesEquipo2 = golesEquipo2;

        if (golesEquipo1 > golesEquipo2) {
            equipo1.registrarVictoria();
            equipo2.registrarDerrota();
        } else if (golesEquipo1 < golesEquipo2) {
            equipo1.registrarDerrota();
            equipo2.registrarVictoria();
        } else {
            equipo1.registrarEmpate();
            equipo2.registrarEmpate();
        }

        finalizado = true;
        return true;
    }

    public boolean estaFinalizado() {
        return finalizado;
    }

    public boolean jugaronEnMismoEquipo(Jugador jugador1,
                                        Jugador jugador2) {
        return equipo1.contieneJugador(jugador1)
               && equipo1.contieneJugador(jugador2)
            || equipo2.contieneJugador(jugador1)
               && equipo2.contieneJugador(jugador2);
    }

    public boolean jugaronEnfrentados(Jugador jugador1,
                                      Jugador jugador2) {
        return equipo1.contieneJugador(jugador1)
               && equipo2.contieneJugador(jugador2)
            || equipo2.contieneJugador(jugador1)
               && equipo1.contieneJugador(jugador2);
    }

    public String detalleEncuentro() {
        String detalle = "Fecha: " + fecha;

        detalle += "\nEquipo 1:"
                 + equipo1.nombresJugadores();

        detalle += "\nEquipo 2:"
                 + equipo2.nombresJugadores();

        if (finalizado) {
            detalle += "\nResultado: "
                     + golesEquipo1 + " - " + golesEquipo2;
        } else {
            detalle += "\nPartido todavía no finalizado";
        }

        return detalle;
    }
}