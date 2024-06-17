package Excepciones;

public class TelefonoExistenteException extends Exception{
    public TelefonoExistenteException(){
        System.out.println("Este telefono ya existe");
    }
    public TelefonoExistenteException(String telef){
        super(telef);
    }
}
