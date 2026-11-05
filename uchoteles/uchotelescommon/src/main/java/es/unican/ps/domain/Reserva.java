package es.unican.ps.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@NoArgsConstructor 
@Entity
@Table(name = "Reserva")
public class Reserva implements Serializable {
    @Id 
    @GeneratedValue 
    private int id;
    @Column(nullable = false)
    private Date fechaEntrada;
    @Column(nullable = false)
    private Date fechaSalida;
    @Column(nullable = false)
    private Boolean bloqueada;
    private DatosPago datos;
    private DatosClientes clientes;
    @OneToMany 
    @JoinColumn(name="Reserva_FK")
    private List<ReservaTipoHabitacion> lineasReservas;

    

    public Reserva(int id, Date fechaEntrada, Date fechaSalida, Boolean bloqueada, DatosPago datos,
            DatosClientes clientes) {
        this.id = id;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.bloqueada = bloqueada;
        this.datos = datos;
        this.clientes = clientes;
        lineasReservas = new ArrayList<>();
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Date getFechaEntrada() {
        return fechaEntrada;
    }
    public void setFechaEntrada(Date fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }
    public Date getFechaSalida() {
        return fechaSalida;
    }
    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }
    public Boolean getBloqueada() {
        return bloqueada;
    }
    public void setBloqueada(Boolean bloqueada) {
        this.bloqueada = bloqueada;
    }
    public Double getImporte() {
        Double importe = 0d;
        for (ReservaTipoHabitacion r : lineasReservas) {
            importe += r.getPrecioPorNoche();
        }
        return importe;
    }
    public DatosPago getDatos() {
        return datos;
    }
    public void setDatos(DatosPago datos) {
        this.datos = datos;
    }
    public DatosClientes getClientes() {
        return clientes;
    }
    public void setClientes(DatosClientes clientes) {
        this.clientes = clientes;
    }
    public List<ReservaTipoHabitacion> getLineasReservas() {
        return lineasReservas;
    }
    public void setLineasReservas(List<ReservaTipoHabitacion> lineasReservas) {
        this.lineasReservas = lineasReservas;
    }

    
}
