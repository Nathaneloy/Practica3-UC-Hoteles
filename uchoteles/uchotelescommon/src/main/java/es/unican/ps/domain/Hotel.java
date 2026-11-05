package es.unican.ps.domain;

import java.util.ArrayList;
import java.util.List;

public class Hotel {

    private String nombre;
    private String direccion;
    private String localidad;
    private int id;
    private List<Habitacion> habitaciones;
    private Categoria categoria;


    
    public Hotel(String nombre, String direccion, String localidad, int id, Categoria categoria) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.localidad = localidad;
        this.id = id;
        this.categoria = categoria;

        habitaciones = new ArrayList<>();
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getLocalidad() {
        return localidad;
    }
    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public List<Habitacion> getHabitaciones() {
        return habitaciones;
    }
    public Categoria getCategoria() {
        return categoria;
    }
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }


}
