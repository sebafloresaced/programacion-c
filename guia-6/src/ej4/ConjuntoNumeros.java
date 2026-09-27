package ej4;

import java.util.Arrays;
import java.util.ArrayList;

public class ConjuntoNumeros implements Cloneable {
    private String nombre;
    
    // inciso a
    private int[] celda; 
    private int largo;
    
    // inciso b
    private ArrayList<Numero> numeros; // inciso b
    
    
    public ConjuntoNumeros(String nombre, int largo) {
        this.nombre = nombre;
        
        // inciso a
        this.largo = largo;
        celda = new int[largo];
        
        // inciso b
        numeros = new ArrayList<>();
    }
    @Override
    public Object clone() {
        try {
            ConjuntoNumeros clon = (ConjuntoNumeros)super.clone();
            
            // inciso a
            clon.celda = (int[])celda.clone();
            
            // inciso b
            clon.numeros = new ArrayList<Numero>();
            for (Numero n : numeros) {
                clon.numeros.add((Numero)n.clone());
            }
            
            return clon;
        }
        catch(CloneNotSupportedException e) {
            throw new InternalError(e.toString());
        }
    }
    public int[] getCelda() {
        return celda;
    }
    public int getLargo() {
        return largo;
    }
    public String getNombre() {
        return nombre;
    }
    public ArrayList<Numero> getNumeros() {
        return numeros;
    }
    @Override
    public String toString() {
        return " - Nombre: " + nombre + " - Largo: " + largo + " - celda: " + Arrays.toString(celda) + " - Numeros: " + numeros; 
    }
}