package ej5;

public class Chofer {
    private Categoria categoria;
    private Domicilio domicilio;
    private String nombre;
    private Colectivo colectivo;
    public Chofer(String nombre, String calle, int numero, Categoria categoria) { // constructor sin colectivo
        this.nombre = nombre;
        this.domicilio = new Domicilio(calle,numero);
        this.categoria = categoria;
        this.colectivo = null;
    }
    public Chofer(String nombre, String calle, int numero, Categoria categoria,Colectivo colectivo) { // constructor con colectivo
        this.nombre = nombre;
        this.domicilio = new Domicilio(calle,numero);
        this.categoria = categoria;
        this.colectivo = colectivo;
    }
    public Categoria getCategoria() {
        return categoria;
    }
    public Domicilio getDomicilio() {
        return domicilio;
    }
    public String getNombre() {
        return nombre;
    }
    public Colectivo getColectivo() {
        return colectivo;
    }
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void cambiarDomicilio(String calle,int numero) {
        this.domicilio = new Domicilio(calle,numero);
    }
    public void asignarColectivo(Colectivo colectivo) {
        this.colectivo = colectivo;
    }
    public void desasignarColectivo() {
        this.colectivo = null;
    }
    public boolean tieneColectivo() {
        return colectivo != null;
    }
    public void informe() {
        System.out.println("Nombre: " + nombre + "\nDomicilio: " + getDomicilio().getCalle() + ' ' + getDomicilio().getNumero() +
                           "\nCategoria: " + getCategoria().getNombreCategoria());
        if (tieneColectivo()) {
            System.out.println("\nColectivo: \n\tModelo: " + getColectivo().getModelo() + "\n\tNumero interno: " + getColectivo().getNumeroInterno());
        }
        else {
            System.out.println("\nEl chofer no tiene colectivo asignado");
        }
    }
}
