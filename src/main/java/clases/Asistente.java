package clases;

public class Asistente extends Usuario{
    protected String dni;


    public Asistente(String nombre_usuario, String numero_telefono, String email_usuario,String contrasenia,String dni) {
        super(nombre_usuario, numero_telefono, email_usuario,contrasenia);
        this.dni=dni;
    }


}
