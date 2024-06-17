package Excepciones;

public class ContraseñaIncorrectaException extends Exception {

    public ContraseñaIncorrectaException(){
        System.out.println("Esta contraseña es incorrecta");
    }
    public ContraseñaIncorrectaException(String mensaje){
        super(mensaje);
    }
}
