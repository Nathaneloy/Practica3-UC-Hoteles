package es.unican.ps.domain;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@NoArgsConstructor 
@Entity
@Table(name = "Habitacion")
public class Habitacion implements Serializable {
    @Column(nullable = false)
    private int disponibles;
    @Column(nullable = false)
    private double precioPorNoche;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoHabitacion tipo;

    

    public Habitacion(int disponibles, double precioPorNoche, TipoHabitacion tipo) {
        this.disponibles = disponibles;
        this.precioPorNoche = precioPorNoche;
        this.tipo = tipo;
    }

    public int getDisponibles() {
        return disponibles;
    }
    public void setDisponibles(int disponibles) {
        this.disponibles = disponibles;
    }
    public double getPrecioPorNoche() {
        return precioPorNoche;
    }
    public void setPrecioPorNoche(double precioPorNoche) {
        this.precioPorNoche = precioPorNoche;
    }
    public TipoHabitacion getTipo() {
        return tipo;
    }
    public void setTipo(TipoHabitacion tipo) {
        this.tipo = tipo;
    }

}
