package ej7;

import ej4.Numero;

import java.util.ArrayList;

public class Mapa implements Cloneable {
    private ArrayList<Personaje> personajes;
    
    public Mapa() {
        personajes = new ArrayList<>();
    }
    public void agregaPersonaje(Personaje personaje) {
        personajes.add(personaje);
    }
    public void mueve(Personaje personaje, double valorX, double valorY) {
        try {
            personaje.incrementaPos(valorX, valorY);
        } catch (IncrementoImposibleExcepcion e) {
           double distanciaPretendida = e.getDistanciaPretendida();
           double maximaDistancia = e.getMaxDistanciaSoportada();

           // Mantengo la dirección pero reduzco la longitud
           double proporcion = maximaDistancia / distanciaPretendida;

           double nuevoX = valorX * proporcion;
           double nuevoY = valorY * proporcion;

           try {
               personaje.incrementaPos(nuevoX, nuevoY);
           }
           catch (IncrementoImposibleExcepcion ex) {
               // Matemáticamente no debería ocurrir
           }
       }
    }
    public void ataca(Personaje atacante, Personaje atacado) throws AtaqueImposibleException {
        atacante.atacar(atacado);
    }
    @Override
    public Object clone() {
        try {
            Mapa clon = (Mapa)super.clone();
            clon.personajes = new ArrayList<>();
            for (Personaje p : personajes) {
                clon.personajes.add((Personaje)p.clone());
            }
            return clon;
        }
        catch(CloneNotSupportedException e) {
            throw new InternalError(e.toString());
        }
    }
}
