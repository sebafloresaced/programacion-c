package ej6;

public class Rubi extends Gema {
    @Override
    public String combinar(Gema gema) {
        return gema.combinarConRubi(this);
    }
    @Override
    public String combinarConRubi(Rubi rubi) {
        return "Lluvia de fuego";
    }
    @Override
    public String combinarConZafiro(Zafiro zafiro) {
        return "Erupcion Volcanica";
    }
    @Override
    public String combinarConEsmeralda(Esmeralda esmeralda) {
        return "Terremoto";
    }
    @Override
    public String combinarConDiamante(Diamante diamante) {
        return "Tormenta de Rayos";
    }
}