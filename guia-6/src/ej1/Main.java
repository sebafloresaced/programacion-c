package ej1;

public class Main {
    public Main() {
        super();
    }
    public static void main(String[] args) {
        try {
            Usuario u = new Usuario("Sebastian", "a123456");
            System.out.println("Usuario creado");
        } catch (NombreInvalidoException e) {
            System.out.println(e.getMensaje());
        } catch (ContraseniaInvalidaException e) {
            System.out.println(e.getMensaje());
        }
    }
}
