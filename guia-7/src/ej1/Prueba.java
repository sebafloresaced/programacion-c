package ej1;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Iterator;

public class Prueba {
    public static void main(String[] args) {
        Persona[] personas = new Persona[5];

        personas[0] = new Persona("Carlos", "Perez", "Colon 3212");
        personas[1] = new Persona("Carlos", "Perez", "Colon 3212");
        personas[2] = new Persona("Ana", "Garcia", "Mitre 2812");
        personas[3] = new Persona("Valeria", "Alvarez", "San Luis 2812");
        personas[4] = new Persona("Luis", "Garcia", "Matheu 3538");

        // Comparacion de las primeras dos personas
        System.out.println("Comparacion con ==: " + (personas[0] == personas[1]));
        System.out.println("Comparacion con equals: " + personas[0].equals(personas[1]));

        // Array original
        System.out.println("\nPersonas sin ordenar:");
        for (Persona p : personas) {
            System.out.println(p);
        }

        // Ordenamiento
        Ordenadora.ordenar(personas);

        // Array ordenado
        System.out.println("\nPersonas ordenadas:");
        for (Persona p : personas) {
            System.out.println(p);
        }
        
        // Creo las colecciones
        HashSet<Persona> hashSet = new HashSet<>();
        LinkedHashSet<Persona> linkedHashSet = new LinkedHashSet<>();
        TreeSet<Persona> treeSet = new TreeSet<>();
        ArrayList<Persona> arrayList = new ArrayList<>();
        LinkedList<Persona> linkedList = new LinkedList<>();
        PriorityQueue<Persona> priorityQueue = new PriorityQueue<>();

        // Agrego las 5 personas a cada colección
        for (Persona p : personas) {
            hashSet.add(p);
            linkedHashSet.add(p);
            treeSet.add(p);
            arrayList.add(p);
            linkedList.add(p);
            priorityQueue.add(p);
        }

        // Muestro las colecciones utilizando Iterator
        System.out.println("\nHASHSET:");
        Iterator<Persona> it = hashSet.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        System.out.println("\nLINKEDHASHSET:");
        it = linkedHashSet.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        System.out.println("\nTREESET:");
        it = treeSet.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        System.out.println("\nARRAYLIST:");
        it = arrayList.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        System.out.println("\nLINKEDLIST:");
        it = linkedList.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        // PriorityQueue utiliza poll()
        System.out.println("\nPRIORITYQUEUE:");
        while (!priorityQueue.isEmpty()) {
            System.out.println(priorityQueue.poll());
        }
    }
}