package ej5;

import java.util.ArrayList;
import java.util.List;

public class Empresa {
    private List<Categoria> categorias = new ArrayList<>();
    private List<Colectivo> colectivos = new ArrayList<>();
    private List<Chofer> choferes = new ArrayList<>();
    public Empresa() {
        super();
    }
    public Categoria crearCategoria(String nombreCategoria,double sueldo) {
        Categoria aux;
        aux = new Categoria(nombreCategoria,sueldo);
        categorias.add(aux);
        return aux;
    }
    public Colectivo crearColectivo(String modelo) {
        Colectivo aux;
        aux = new Colectivo(modelo);
        colectivos.add(aux);
        return aux;
    }
    public Chofer crearChofer(String nombre, String calle, int numero, Categoria categoria) {
        Chofer aux;
        aux = new Chofer(nombre,calle,numero,categoria);
        choferes.add(aux);
        return aux;
    }
    public Chofer crearChofer(String nombre, String calle, int numero, Categoria categoria,Colectivo colectivo) {
        Chofer aux;
        aux = new Chofer(nombre,calle,numero,categoria,colectivo);
        return aux;
    }
    public int cantChoferesSinColectivo() {
        int i,cont = 0, tope = choferes.size();
        for (i=0;i<tope;i++) {
            if (choferes.get(i).tieneColectivo() == false)  
                cont ++;
        }
        return cont;
    }
    public int cantColectivos() {
        return colectivos.size();
    }
    public void getChoferesCategoria(Categoria categoria) {
        int i, tope = choferes.size();
        System.out.println("Choferes de categoria " + categoria.getNombreCategoria() + ":");
        for (i=0;i<tope;i++) {
             if (choferes.get(i).getCategoria() == categoria) {
                 System.out.println("\n" + choferes.get(i).getNombre());
             }
        }
    }
    public void getCategoriasSupMonto(double monto) {
        int i, tope = categorias.size();
        System.out.println("Categorias con sueldo mayor a " + monto + ":");
        for (i=0;i<tope;i++) {
            if (categorias.get(i).getSueldo() > monto) {
                System.out.println(categorias.get(i).getNombreCategoria());
            }
        }
    }
    public void getChoferesSueldoSupMonto(double monto) {
        int i, tope = categorias.size();
        System.out.println("Choferes con sueldo mayor a " + monto + ":");
        for (i=0;i<tope;i++) {
            if (categorias.get(i).getSueldo() > monto) {
                getChoferesCategoria(categorias.get(i));
            }
        }
    }
}
