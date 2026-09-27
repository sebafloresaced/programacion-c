package ej1;

public class Usuario {
    private String nombre, contrasenia;
    
    public Usuario(String nombre, String contrasenia) throws NombreInvalidoException, ContraseniaInvalidaException {
        setNombre(nombre);
        setContrasenia(contrasenia);
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) throws NombreInvalidoException {
        if (nombre == null) {
            throw new NombreInvalidoException("El nombre no puede ser null");
        }
        if (nombre.isEmpty()) {
            throw new NombreInvalidoException("El nombre no puede estar vacio");
        }
        this.nombre = nombre;
    }
    public void setContrasenia(String contrasenia) throws ContraseniaInvalidaException {
        if (contrasenia == null) { 
            throw new ContraseniaInvalidaException("La contrasenia no puede ser null");
        }
        if (contrasenia.length() < 7) {
            throw new ContraseniaInvalidaException("La contrasenia no puede contener menos de 7 caracteres");
        }
        if (!Character.isLetter(contrasenia.charAt(0))) {
            throw new ContraseniaInvalidaException("El primer caracter de la constrasenia debe ser una letra");
        }
        this.contrasenia = contrasenia;
    }
}