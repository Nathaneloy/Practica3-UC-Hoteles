package es.unican.ps.domain;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@NoArgsConstructor 
@Entity
@Table(name = "ReservaTipoHabitacion")
public class ReservaTipoHabitacion implements Serializable {
    private int numHabitaciones;
    private double precioPorNoche;
    private Habitacion habitacion;

    

    public ReservaTipoHabitacion(int numHabitaciones, double precioPorNoche, Habitacion habitacion) {
        this.numHabitaciones = numHabitaciones;
        this.precioPorNoche = precioPorNoche;
        this.habitacion = habitacion;
    }

    public int getNumHabitaciones() {
        return numHabitaciones;
    }
    public void setNumHabitaciones(int numHabitaciones) {
        this.numHabitaciones = numHabitaciones;
    }
    public double getPrecioPorNoche() {
        return precioPorNoche;
    }
    public void setPrecioPorNoche(double precioPorNoche) {
        this.precioPorNoche = precioPorNoche;
    }
    public Habitacion getHabitacion() {
        return habitacion;
    }
    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

    
}
