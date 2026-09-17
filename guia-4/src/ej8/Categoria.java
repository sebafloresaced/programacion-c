package ej8;

public class Categoria {
    private String nombreCategoria;
    private double sueldo;
    private boolean habilitaColectivo;
    private boolean habilitaMicro;
    private boolean habilitaCamion;
    
    public Categoria(String nombreCategoria, double sueldo, boolean habilitaColectivo, boolean habilitaMicro, boolean habilitaCamion) {
        this.nombreCategoria = nombreCategoria;
        this.sueldo = sueldo;
        this.habilitaColectivo = habilitaColectivo;
        this.habilitaMicro = habilitaMicro;
        this.habilitaCamion = habilitaCamion;
    }
    public String getNombreCategoria() {
        return nombreCategoria;
    }
    public double getSueldo() {
        return sueldo;
    }
    public boolean getHabilitaColectivo() {
        return habilitaColectivo;
    }
    public boolean getHabilitaMicro() {
        return habilitaMicro;
    }
    public boolean getHabilitaCamion() {
        return habilitaCamion;
    }
    @Override
    public String toString() {
        return nombreCategoria +
               " - Sueldo: $" + sueldo;
    }
}

