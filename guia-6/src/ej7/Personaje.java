package ej7;

public abstract class Personaje implements Movible, Comparable<Personaje>, Cloneable {
    private Posicion posicion;
    private double vitalidad;
    private double distanciaMaximaDeDesplazamiento;
    private int alcance;
    private String nombre;

    public Personaje(String nombre, double vitalidad, double x, double y, double distanciaMaximaDeDesplazamiento, int alcance) {
        this.vitalidad = vitalidad;
        this.nombre = nombre;
        posicion = new Posicion(x, y);
        this.distanciaMaximaDeDesplazamiento = distanciaMaximaDeDesplazamiento;
        this.alcance = alcance;
    }
    public double getVitalidad() {
        return vitalidad;
    }
    public void setVitalidad(double vitalidad) {
        this.vitalidad = vitalidad;
    }
    public void recibeDano(double cantidad) {
        vitalidad -= cantidad;
    }
    @Override
    public double getPosx() {
        return posicion.getPosx();
    }
    @Override
    public double getPosy() {
        return posicion.getPosy();
    }
    @Override
    public void incrementaPos(double x, double y) throws IncrementoImposibleExcepcion {
        double distanciaPretendida = Math.sqrt(x * x + y * y);
        if (distanciaPretendida > distanciaMaximaDeDesplazamiento) {
            throw new IncrementoImposibleExcepcion(distanciaPretendida, distanciaMaximaDeDesplazamiento);
        }
        posicion.incrementaPos(x, y);
    }
    protected void moverSinValidar(double x, double y) {
        posicion.incrementaPos(x, y);
    }
    @Override
    public double distancia(Movible otro) {
        return posicion.distancia(otro);
    }
    public double getAlcance() {
        return alcance;
    }
    public String getNombre() {
        return nombre;
    }
    public void atacar(Personaje atacado) throws AtaqueImposibleException {
        double distanciaAtaque = this.distancia(atacado);
        if (distanciaAtaque > alcance) {
            throw new AtaqueImposibleException(this, atacado);
        }
        
        // falta atacar
    }
    @Override
    public int compareTo(Personaje otro) {
        int diferencia = nombre.compareTo(otro.getNombre());
        if (diferencia == 0) {
            diferencia = Double.compare(vitalidad,otro.getVitalidad());
        }
        return diferencia;
    }
    @Override
    public Object clone() {
        try {
            Personaje clon = (Personaje)super.clone();
            clon.posicion = (Posicion)posicion.clone();
            return clon;
        }
        catch(CloneNotSupportedException e) {
            throw new InternalError(e.toString());
        }
    }
}