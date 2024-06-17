package clases;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Evento implements Serializable {
    protected String fecha;
    protected String nombre;
    protected Sala Sala;
    protected String hora;
    private String tipo_evento;


    public ArrayList<Usuario> listadoAsistente=new ArrayList<>();

    public Evento(String fecha, String nombre, clases.Sala sala, String hora, String tipo_evento, ArrayList<Usuario> listadoAsistente) {
        this.fecha = fecha;
        this.nombre = nombre;
        Sala = sala;
        this.hora = hora;
        this.tipo_evento = tipo_evento;
        this.listadoAsistente = listadoAsistente;
    }

    public Evento() {
    }


    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public clases.Sala getSala() {
        return Sala;
    }

    public void setSala(clases.Sala sala) {
        Sala = sala;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getTipo_evento() {
        return tipo_evento;
    }

    public void setTipo_evento(String tipo_evento) {
        this.tipo_evento = tipo_evento;
    }

    public ArrayList<Usuario> getListadoAsistente() {
        return listadoAsistente;
    }

    public void setListadoAsistente(ArrayList<Usuario> listadoAsistente) {
        this.listadoAsistente = listadoAsistente;
    }
}
