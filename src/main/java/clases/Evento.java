package clases;

import java.time.LocalDate;
import java.util.ArrayList;

public class Evento {
    protected LocalDate fecha;
    protected String nombre;
    protected Sala Sala;
    protected String hora;
    private String tipo_evento;
    public ArrayList<Usuario> listadoAsistente=new ArrayList<>();

    public Evento(LocalDate fecha, String nombre, clases.Sala sala, String hora, String tipo_evento, ArrayList<Usuario> listadoAsistente) {
        this.fecha = fecha;
        this.nombre = nombre;
        Sala = sala;
        this.hora = hora;
        this.tipo_evento = tipo_evento;
        this.listadoAsistente = listadoAsistente;
    }
}
