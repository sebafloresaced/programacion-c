package ej5;

public class AutomovilAutomatico extends Automovil {
    public AutomovilAutomatico(String patente, double velocidadMax) {
        super(patente,velocidadMax);
    }
    public AutomovilAutomatico(String patente) {
        super(patente);
    }
    private void actualizarMarcha() {
        if (velocidad == 0)
           setMarcha(0);
       else if (velocidad <= 10)
           setMarcha(1);
       else if (velocidad <= 35)
           setMarcha(2);
       else if (velocidad <= 50)
           setMarcha(3);
       else if (velocidad <= 90)
           setMarcha(4);
       else
           setMarcha(5);
    }
    // poner marcha atras
    public void ponerMarchaAtras() {
        if (velocidad == 0) {
            setMarcha(-1);
        }
    }
    @Override
    public void acelerar(double vel) {
        double velocidadMax = getVelocidadMax();
        if (vel >= 0) {
            velocidad += vel;
            if (velocidad > velocidadMax) {
                velocidad = velocidadMax;
            }
            actualizarMarcha();
        }
    }
    public void frenar(double vel) {
        double velocidad = getVelocidad();
        if (vel >= 0) {
            velocidad -= vel;
            if (velocidad < 0) {
                velocidad = 0;
            }
            actualizarMarcha();
        }
    }
}
