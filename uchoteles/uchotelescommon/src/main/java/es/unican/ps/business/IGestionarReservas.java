package es.unican.ps.business;

import java.time.LocalDate;
import java.util.List;

import es.unican.ps.domain.DatosClientes;
import es.unican.ps.domain.DatosPago;
import es.unican.ps.domain.Habitacion;
import es.unican.ps.domain.Reserva;

public interface IGestionarReservas {

    public List<Habitacion> consultarDisponibilidad(String nombreHotel, LocalDate fechaEntrada, LocalDate fechaSalida);

    public Boolean bloquearReserva(Reserva reserva);

    public int confirmarReserva(Reserva reserva, DatosClientes cliente, DatosPago pago);

    public Reserva cancelarReserva(int idReserva);
    

}
