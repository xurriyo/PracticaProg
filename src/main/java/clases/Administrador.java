package clases;

public class Administrador extends Usuario {
    protected int permisos;


    public Administrador(String nombre_usuario, String numero_telefono, String email_usuario, String contrasenia,int permisos) {
        super(nombre_usuario, numero_telefono, email_usuario, contrasenia);
        this.permisos=permisos;
    }
}
