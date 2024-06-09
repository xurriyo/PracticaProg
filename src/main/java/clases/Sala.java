package clases;

import java.util.ArrayList;

public class Sala {
    private String nombre;
    private int capacidad_maxima;
    private ArrayList<Butaca> listado_butacas_disponibles=new ArrayList<>();
    private  double dimension_en_m2;
    private boolean accesibilidad;
    private String caracteristicas;
    private String observaciones;

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
}
