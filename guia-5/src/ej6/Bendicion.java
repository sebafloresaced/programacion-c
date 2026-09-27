package ej6;

public class Bendicion extends Hechizo {
    @Override
    public void aplicar(Caballero caballero) {
        caballero.setArmadura( caballero.getArmadura() + 200 );
    }
    @Override
    public void aplicar(Arquero arquero) {
        arquero.setFlechas( arquero.getFlechas() + 5 );
    }
    @Override
    public void aplicar(Guerrero guerrero) {
        guerrero.setVitalidad( guerrero.getVitalidad() * 1.25 );
    }
    @Override
    public void aplicar(Dragon dragon) {
        dragon.setPoderFuego( dragon.getPoderFuego() * 1.40 );
        dragon.setVitalidad( dragon.getVitalidad() + 250 );
    }
}