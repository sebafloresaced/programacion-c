package ej6;

public class Esmeralda extends Gema {
    @Override
    public String combinar(Gema gema) {
        return gema.combinarConEsmeralda(this);
    }
    @Override
    public String combinarConRubi(Rubi rubi) {
        return "Terremoto";
    }
    @Override
    public String combinarConZafiro(Zafiro zafiro) {
        return "Huracan";
    }
    @Override
    public String combinarConEsmeralda(Esmeralda esmeralda) {
        return "Niebla Desoladora";
    }
    @Override
    public String combinarConDiamante(Diamante diamante) {
        return "Vientos venenosos";
    }
}