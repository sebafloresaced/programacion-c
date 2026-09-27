package ej6;

public abstract class Hechizo {
    public abstract void aplicar(Caballero caballero);
    public abstract void aplicar(Arquero arquero);
    public abstract void aplicar(Guerrero guerrero);
    public abstract void aplicar(Dragon dragon);
}