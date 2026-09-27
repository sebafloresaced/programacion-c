package ej3;

public class Surtidor {
    private double cantidadDiesel, cantidadPremium, cantidadSuper;
    private static final double maxCant = 20000; 
    
    public Surtidor() {
        cantidadDiesel = maxCant;   
        cantidadPremium = maxCant;
        cantidadSuper = maxCant;
    }
    public void cargarCombustible(String combustible, double cantidad) throws CargaInvalidaException {
        switch (combustible) {
            case "Diesel":
                if (cantidad < 0) {
                    throw new CargaInvalidaException("No se puede cargar una cantidad invalida",combustible,cantidad,cantidadDiesel);
                }
                if (cantidad > cantidadDiesel) {
                    double disponible = cantidadDiesel;
                    cantidadDiesel = 0;
                    throw new FaltaCombustibleException("No se puede cargar mas de la cantidad almacenada",combustible,cantidad,disponible);   
                }
                cantidadDiesel -= cantidad;
                break;
            case "Premium":
                if (cantidad < 0) {
                    throw new CargaInvalidaException("No se puede cargar una cantidad invalida",combustible,cantidad,cantidadPremium);
                }
                if (cantidad > cantidadPremium) {
                    double disponible = cantidadPremium;
                    cantidadPremium = 0;
                    throw new FaltaCombustibleException("No se puede cargar mas de la cantidad almacenada",combustible,cantidad,disponible);   
                }
                cantidadPremium -= cantidad;
                break;
            case "Super":
                if (cantidad < 0) {
                    throw new CargaInvalidaException("No se puede cargar una cantidad invalida",combustible,cantidad,cantidadSuper);
                }
                if (cantidad > cantidadSuper) {
                    double disponible = cantidadSuper;
                    cantidadSuper = 0;
                    throw new FaltaCombustibleException("No se puede cargar mas de la cantidad almacenada",combustible,cantidad,disponible);   
                }
                cantidadSuper -= cantidad;
                break;
            default: 
                throw new TipoCombustibleInvalidoException("No existe ese combustible",combustible,cantidad,0);
        }
    }
    public double getCantidadDiesel() {
        return cantidadDiesel;
    }
    public double getCantidadPremium() {
        return cantidadPremium;
    }
    public double getCantidadSuper() {
        return cantidadSuper;
    }
    public void llenarDiesel() {
        cantidadDiesel = maxCant;
    }
    public void llenarPremium() {
        cantidadPremium = maxCant;
    }
    public void llenarSuper() {
        cantidadSuper = maxCant;
    }
}
