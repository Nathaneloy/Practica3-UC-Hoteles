package es.unican.ps.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Reserva {
    private int id;
    private Date fechaEntrada;
    private Date fechaSalida;
    private Boolean bloqueada;
    private DatosPago datos;
    private DatosClientes clientes;
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
