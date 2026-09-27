package ej6;

public class Diamante extends Gema {
    @Override
    public String combinar(Gema gema) {
        return gema.combinarConDiamante(this);
    }
    @Override
    public String combinarConRubi(Rubi rubi) {
        return "Tormenta de Rayos";
    }
    @Override
    public String combinarConZafiro(Zafiro zafiro) {
        return "Granizo Asesino";
    }
    @Override
    public String combinarConEsmeralda(Esmeralda esmeralda) {
        return "Vientos venenosos";
    }
    @Override
    public String combinarConDiamante(Diamante diamante) {
        return "Congelamiento";
    }
}