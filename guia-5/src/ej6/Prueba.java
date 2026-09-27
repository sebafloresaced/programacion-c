package ej6;

public class Prueba {

    public static void main(String[] args) {

        // ---------- HECHIZOS ----------

        Caballero caballero =
            new Caballero(500, 1000, 0, 0);

        Arquero arquero =
            new Arquero(500, 10, 10, 10);

        Guerrero guerrero =
            new Guerrero(500, 20, 20);

        Dragon dragon =
            new Dragon(30, 30);

        Hechizo bendicion = new Bendicion();
        Hechizo maldicion = new Maldicion();


        caballero.recibirHechizo(bendicion);

        System.out.println(
            "Armadura caballero: "
            + caballero.getArmadura()
        );


        arquero.recibirHechizo(maldicion);

        System.out.println(
            "Flechas arquero: "
            + arquero.getFlechas()
        );


        guerrero.recibirHechizo(bendicion);

        System.out.println(
            "Vitalidad guerrero: "
            + guerrero.getVitalidad()
        );


        dragon.recibirHechizo(bendicion);

        System.out.println(
            "Vitalidad dragon: "
            + dragon.getVitalidad()
        );

        System.out.println(
            "Poder fuego dragon: "
            + dragon.getPoderFuego()
        );


        // ---------- ATAQUE DRAGON ----------

        Guerrero enemigo =
            new Guerrero(500, 35, 35);

        dragon.atacar(enemigo);

        System.out.println(
            "Vitalidad enemigo: "
            + enemigo.getVitalidad()
        );


        // ---------- GEMAS ----------

        Gema rubi = new Rubi();
        Gema zafiro = new Zafiro();
        Gema esmeralda = new Esmeralda();
        Gema diamante = new Diamante();

        System.out.println(
            rubi.combinar(rubi)
        );

        System.out.println(
            rubi.combinar(zafiro)
        );

        System.out.println(
            zafiro.combinar(esmeralda)
        );

        System.out.println(
            diamante.combinar(diamante)
        );
    }
}
