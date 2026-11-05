package es.unican.ps.business;

import java.util.List;

import es.unican.ps.domain.Hotel;
import es.unican.ps.domain.Reserva;

public interface IInformacionReservas {

    public Hotel buscarHotelPorNombre(String nombre);

    public List<Hotel> buscarHotelPorLocalidad(String localidad);

    public Reserva consultarReserva(int idReserva, String dni);

    public List<Reserva> consultarReservasHotel(String nombreHotel);
}
