package ejercicio5;

public class Guerrero {
    private String nombre;
    private double vitalidad,armadura,x,y;
    public Guerrero() {
        super();
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setVitalidad(double vitalidad) {
        this.vitalidad = vitalidad;
    }

    public void setArmadura(double armadura) {
        this.armadura = armadura;
    }

    public void setX(double y) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }
    public String getNombre() {
        return nombre;
    }
    public double getVitalidad() {
        return vitalidad;
    }
    public double getArmadura() {
        return armadura;
    }
    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
    public void mover(double inc_x, double inc_y) {
        this.x += inc_x;
        this.y += inc_y;
    }
    public void recibeDano(double cantidad) {
        this.armadura -= cantidad;
        if (armadura < 0) {
            this.vitalidad -= armadura;
            this.armadura = 0;
        }
    }
}

