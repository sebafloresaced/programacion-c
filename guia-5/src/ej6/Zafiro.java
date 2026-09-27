package ej6;

public class Zafiro extends Gema {
    @Override
    public String combinar(Gema gema) {
        return gema.combinarConZafiro(this);
    }
    @Override
    public String combinarConRubi(Rubi rubi) {
        return "Erupcion Volcanica";
    }
    @Override
    public String combinarConZafiro(Zafiro zafiro) {
        return "Inundacion";
    }
    @Override
    public String combinarConEsmeralda(Esmeralda esmeralda) {
        return "Huracan";
    }
    @Override
    public String combinarConDiamante(Diamante diamante) {
        return "Granizo Asesino";
    }
}