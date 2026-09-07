package ej7;

import java.util.ArrayList;
import java.util.Iterator;

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
    public double indiceDefensa() {
        double acum = 0;
        for (Jugador j : jugadores) {
            acum += j.indiceDefensa();
        }
        return acum;
    }
    public double indiceAtaque() {
        double acum = 0;
        for (Jugador j : jugadores) {
            acum += j.indiceAtaque();
        }
        return acum;
    }
    public String agregaDelantero(String nombre, double velocidad, double potencia) {
        if (velocidad < 0 || velocidad > 1) {
            return "Imposible crear un delantero con velocidad = " + velocidad;
        }
        else if (potencia < 0 || potencia > 1) {
            return "Imposible crear un delantero con potencia = " + potencia;
        }
        else {
            Delantero d = new Delantero(nombre,velocidad,potencia);
            jugadores.add(d);
            return "Jugador agregado";
        }
    }
    public String agregaDefensor(String nombre, double velocidad, double potencia) {
        if (velocidad < 0 || velocidad > 1) {
            return "Imposible crear un defensor con velocidad = " + velocidad;
        }
        else if (potencia < 0 || potencia > 1) {
            return "Imposible crear un defensor con potencia = " + potencia;
        }
        else {
            Defensor d = new Defensor(nombre,velocidad,potencia);
            jugadores.add(d);
            return "Jugador agregado";
        }
    }
    public String agregaArquero(String nombre, double velocidad, double potencia, double efectividad) {
        if (velocidad < 0 || velocidad > 1) {
            return "Imposible crear un arquero con velocidad = " + velocidad;
        }
        else if (potencia < 0 || potencia > 1) {
            return "Imposible crear un arquero con potencia = " + potencia;
        }
        else if (efectividad < 0 || efectividad > 1) {
            return "Imposible crear un arquero con efectividad = " + efectividad;
        }
        else {
            Arquero a = new Arquero(nombre,velocidad,potencia,efectividad);
            jugadores.add(a);
            return "Jugador agregado";
        }
    }
    public String agregaArquero(String nombre, double velocidad, double potencia) {
        return agregaArquero (nombre,velocidad,potencia,0.5);
    }
    public void eliminaJugador(Jugador jugador) {
        if (jugadores.contains(jugador)) {
            jugadores.remove(jugador);
        }
    }
    public Iterator<Jugador> getJugadores() {
        return jugadores.iterator();
    }
    
    // deberian reemplazarse los agrega...() por un unico agregaJugador(), ya que las validaciones deberian hacerse al momento de crear el objeto jugador.
    // el equipo no deberia tener la responsabilidad de validar los atributos de los jugadores
}

