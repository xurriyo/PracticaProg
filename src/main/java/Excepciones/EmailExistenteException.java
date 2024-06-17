package Excepciones;

public class EmailExistenteException extends Exception {
    public EmailExistenteException(){
        System.out.println("El correo ya existe");
    }
    public EmailExistenteException(String mensaje){
        super(mensaje);
    }
}
