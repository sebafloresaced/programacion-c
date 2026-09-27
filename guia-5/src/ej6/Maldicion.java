package ej6;

public class Maldicion extends Hechizo {
    @Override
    public void aplicar(Caballero caballero) {
        caballero.setArmadura( caballero.getArmadura() - 200 );
    }
    @Override
    public void aplicar(Arquero arquero) {
        arquero.setFlechas(0);
    }
    @Override
    public void aplicar(Guerrero guerrero) {
        guerrero.setVitalidad( guerrero.getVitalidad() * 0.50 );
    }
    @Override
    public void aplicar(Dragon dragon) {
        dragon.setPoderFuego( dragon.getPoderFuego() * 0.70 );
        dragon.setVitalidad( dragon.getVitalidad() * 0.80 );
    }
}