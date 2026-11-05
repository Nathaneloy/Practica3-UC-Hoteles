package es.unican.ps.domain;


public class Habitacion {
    private int disponibles;
    private double precioPorNoche;
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
