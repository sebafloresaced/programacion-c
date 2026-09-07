package ej5;

public class AutomovilManual extends Automovil {
    public AutomovilManual(String patente, double velocidadMax) {
        super(patente,velocidadMax);
    }
    public AutomovilManual(String patente) {
        super(patente);
    }
    public void cambiarMarcha(int nuevaMarcha) {
        setMarcha(nuevaMarcha);
    }
    @Override
    public void acelerar(double vel) {
        double velocidadMax = getVelocidadMax();
        if (vel >= 0) {
            velocidad += vel;
            if (velocidad > velocidadMax) {
                velocidad = velocidadMax;
            }
        }
    }
    public void frenar(double vel) {
        double velocidad = getVelocidad();
        if (vel >= 0) {
            velocidad -= vel;
            if (velocidad < 0) {
                velocidad = 0;
            }
        }
    }
}
