package ej1;

public class ObservadorConsola implements Observador {
    @Override
    public void actualizar(Mascota mascota) {
        System.out.println(mascota.getNombre() + " " + mascota.getNecesidad());
    }
}