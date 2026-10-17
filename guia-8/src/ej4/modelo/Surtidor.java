package ej4.modelo;

import java.util.ArrayList;
import ej4.modelo.FaltaCombustibleException;

public class Surtidor {
    private int numero;
    private ArrayList<DepositoCombustible> depositos;

    public Surtidor(int numero) {
        if (numero <= 0) {
            throw new IllegalArgumentException("El numero de surtidor debe ser positivo");
        }
        this.numero = numero;
        depositos = new ArrayList<>();
    }

    public void agregarCombustible(Combustible combustible, double capacidadMaxima) {
        if (buscarDeposito(combustible) != null) {
            throw new IllegalArgumentException("El surtidor ya dispone de ese combustible");
        }
        depositos.add(new DepositoCombustible(combustible, capacidadMaxima));
    }
    
    private DepositoCombustible buscarDeposito(Combustible combustible) {
        for (DepositoCombustible deposito : depositos) {
            if (deposito.getCombustible() == combustible) {
                return deposito;
            }
        }
        return null;
    }

    public double cargarPorLitros(Combustible combustible, double litros) throws FaltaCombustibleException, Exception {
        DepositoCombustible deposito = buscarDeposito(combustible);
        if (deposito == null) {
            throw new IllegalArgumentException("El surtidor no dispone de ese combustible");
        }
        return deposito.cargarPorLitros(litros);
    }

    public double cargarPorDinero(Combustible combustible, double dinero) throws FaltaCombustibleException, Exception {
        DepositoCombustible deposito = buscarDeposito(combustible);
        if (deposito == null) {
            throw new IllegalArgumentException("El surtidor no dispone de ese combustible");
        }
        return deposito.cargarPorDinero(dinero);
    }

    public void reponerCombustible(Combustible combustible) {
        DepositoCombustible deposito = buscarDeposito(combustible);
        if (deposito == null) {
            throw new IllegalArgumentException("El surtidor no dispone de ese combustible");
        }
        deposito.reponer();
    }

    public int getNumero() {
        return numero;
    }

    public ArrayList<DepositoCombustible> getDepositos() {
        return new ArrayList<>(depositos);
    }

    public DepositoCombustible getDeposito(Combustible combustible) {
        return buscarDeposito(combustible);
    }
    
    @Override
    public String toString() {
        return "Surtidor " + numero;
    }
}