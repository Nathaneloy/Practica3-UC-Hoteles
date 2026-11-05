package es.unican.ps.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@NoArgsConstructor 
@Entity
@Table(name = "Hotel")
public class Hotel implements Serializable{

    @Column(nullable = false, unique = true)
    private String nombre;
    @Column(nullable = false)
    private String direccion;
    @Column(nullable = false)
    private String localidad;
    @Id 
    @GeneratedValue 
    private int id;
    @OneToMany 
    @JoinColumn(name="Hotel_FK")
    private Map<TipoHabitacion, Habitacion> habitaciones;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Categoria categoria;


    
    public Hotel(String nombre, String direccion, String localidad, int id, Categoria categoria) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.localidad = localidad;
        this.id = id;
        this.categoria = categoria;

        habitaciones = new HashMap<>();
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
    public Map<TipoHabitacion, Habitacion> getHabitaciones() {
        return habitaciones;
    }
    public void setHabitaciones(Map<TipoHabitacion, Habitacion> habitaciones) {
        this.habitaciones = habitaciones;
    }
    public Categoria getCategoria() {
        return categoria;
    }
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Hotel other = (Hotel) obj;
        if (nombre == null) {
            if (other.nombre != null)
                return false;
        } else if (!nombre.equals(other.nombre))
            return false;
        if (direccion == null) {
            if (other.direccion != null)
                return false;
        } else if (!direccion.equals(other.direccion))
            return false;
        if (localidad == null) {
            if (other.localidad != null)
                return false;
        } else if (!localidad.equals(other.localidad))
            return false;
        if (id != other.id)
            return false;
        if (habitaciones == null) {
            if (other.habitaciones != null)
                return false;
        } else if (!habitaciones.equals(other.habitaciones))
            return false;
        if (categoria != other.categoria)
            return false;
        return true;
    }


}
