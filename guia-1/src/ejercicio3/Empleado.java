package ejercicio3;

public class Empleado {
    private String nombre;
    private int antiguedad, hstrabajadas;
    private Categoria cat;
    
    public Empleado() {
        super();
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getAntiguedad() {
        return antiguedad;
    }
    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }
    public int getHsTrabajadas() {
        return hstrabajadas;
    }
    public void setHsTrabajadas(int hstrabajadas) {
        this.hstrabajadas = hstrabajadas;
    }
    public Categoria getCat() {
        return cat;
    }
    public void setCat(Categoria cat) {
        this.cat = cat;
    }
    public double sueldo() {
        double aux;
        aux = this.cat.getSueldoporhora() * this.hstrabajadas;
        if (this.antiguedad > 5) {
            if (this.antiguedad < 10) {
                aux *= 1.25;
            }
            else {
                aux *= 1.35;
            }
        }
        return aux;
    }
    public String detalle() {
        String retorno = "Nombre: " + this.nombre + "\nAntiguedad: " + this.antiguedad + "anios\nHoras trabajadas: "
            + this.hstrabajadas + "\nTipo de categoria: " + this.cat.getNombrecategoria() + "\nSueldo por hora: "
            + this.cat.getSueldoporhora() + "\nSueldo a cobrar: " + this.sueldo() + "\n";
        return retorno;
    }
}
