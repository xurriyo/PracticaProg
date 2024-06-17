package Excepciones;

public class UsuarioIncorrectoException extends Exception {
    public UsuarioIncorrectoException(){
        System.out.println("Este Usuario no coincide");
    }
    public UsuarioIncorrectoException(String mensaje){
        super(mensaje);
    }
}
