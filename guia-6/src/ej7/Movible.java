package ej7;

public interface Movible {
    double getPosx();
    double getPosy();
    void incrementaPos(double x, double y) throws IncrementoImposibleExcepcion;
    double distancia(Movible otro);
}
