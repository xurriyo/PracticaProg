package clases;

import java.io.Serializable;

public abstract class Usuario implements Serializable {
    protected String nombre_usuario;
    protected String numero_telefono;
    protected String email_usuario;
    protected String contrasenia;


    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getNumero_telefono() {
        return numero_telefono;
    }

    public void setNumero_telefono(String numero_telefono) {
        this.numero_telefono = numero_telefono;
    }

    public String getEmail_usuario() {
        return email_usuario;
    }

    public void setEmail_usuario(String email_usuario) {
        this.email_usuario = email_usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public Usuario(String nombre_usuario, String numero_telefono, String email_usuario,String contrasenia) {
        this.nombre_usuario = nombre_usuario;
        this.numero_telefono = numero_telefono;
        this.email_usuario = email_usuario;
        this.contrasenia=contrasenia;
    }



}
