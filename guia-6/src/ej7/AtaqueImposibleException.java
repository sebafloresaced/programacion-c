package ej7;

public class AtaqueImposibleException extends Exception {
    private Personaje atacante, atacado;
    
    public AtaqueImposibleException(Personaje atacante, Personaje atacado) {
        this.atacante = atacante;
        this.atacado = atacado;
    }
    public Personaje getAtacante() {
        return atacante;
    }
    public Personaje getAtacado() {
        return atacado;
    }
}
