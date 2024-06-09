package clases;

public class Butaca {
    protected int id;
    protected boolean posicion;
    protected boolean disponibilidad;
    protected String accesibilidad;


    public Butaca(int id, boolean posicion, boolean disponibilidad, String accesibilidad) {
        this.id = id;
        this.posicion = posicion;
        this.disponibilidad = disponibilidad;
        this.accesibilidad = accesibilidad;
    }
}
