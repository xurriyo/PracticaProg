package clases;

public class Butaca {
    protected int id;
    protected String posicion;
    protected boolean disponibilidad;
    protected boolean accesibilidad;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public boolean isAccesibilidad() {
        return accesibilidad;
    }

    public void setAccesibilidad(boolean accesibilidad) {
        this.accesibilidad = accesibilidad;
    }

    public boolean isDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }



    public Butaca(int id, String posicion, boolean disponibilidad, boolean accesibilidad) {
        this.id = id;
        this.posicion = posicion;
        this.disponibilidad = disponibilidad;
        this.accesibilidad = accesibilidad;
    }
}
