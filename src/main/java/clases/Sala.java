package clases;

import java.io.Serializable;
import java.util.ArrayList;

public class Sala implements Serializable {
    private String nombre;
    private int capacidad_maxima;
    private ArrayList<Butaca> listado_butacas_disponibles=new ArrayList<>();
    private  double dimension_en_m2;
    private boolean accesibilidad;
    private String caracteristicas;
    private String observaciones;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCapacidad_maxima() {
        return capacidad_maxima;
    }

    public void setCapacidad_maxima(int capacidad_maxima) {
        this.capacidad_maxima = capacidad_maxima;
    }

    public ArrayList<Butaca> getListado_butacas_disponibles() {
        return listado_butacas_disponibles;
    }

    public void setListado_butacas_disponibles(ArrayList<Butaca> listado_butacas_disponibles) {
        this.listado_butacas_disponibles = listado_butacas_disponibles;
    }

    public double getDimension_en_m2() {
        return dimension_en_m2;
    }

    public void setDimension_en_m2(double dimension_en_m2) {
        this.dimension_en_m2 = dimension_en_m2;
    }

    public boolean isAccesibilidad() {
        return accesibilidad;
    }

    public void setAccesibilidad(boolean accesibilidad) {
        this.accesibilidad = accesibilidad;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    Sala(){}

    public Sala(String nombre, int capacidad_maxima, ArrayList<Butaca> listado_butacas_disponibles, double dimension_en_m2, boolean accesibilidad, String caracteristicas, String observaciones) {
        this.nombre = nombre;
        this.capacidad_maxima = capacidad_maxima;
        this.listado_butacas_disponibles = listado_butacas_disponibles;
        this.dimension_en_m2 = dimension_en_m2;
        this.accesibilidad = accesibilidad;
        this.caracteristicas = caracteristicas;
        this.observaciones = observaciones;
    }

    public Sala(String nombre, int capacidad_maxima, double Capacidad, ArrayList<Butaca> misbutacas) {
    }
    public void mostrar_butacas(){
        int contador=0;
        for (Butaca b:listado_butacas_disponibles){
                System.out.println(b.getPosicion());

        }
    }
}
