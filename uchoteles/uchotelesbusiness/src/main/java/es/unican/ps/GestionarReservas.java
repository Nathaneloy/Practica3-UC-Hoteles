package es.unican.ps;

import java.sql.Date;
import java.util.List;

import es.unican.ps.business.IGestionarReservas;
import es.unican.ps.business.IInformacionReservas;
import es.unican.ps.domain.DatosClientes;
import es.unican.ps.domain.DatosPago;
import es.unican.ps.domain.Habitacion;
import es.unican.ps.domain.Hotel;
import es.unican.ps.domain.Reserva;

public class GestionarReservas implements IGestionarReservas, IInformacionReservas {

    @Override
    public Hotel buscarHotelPorNombre(String nombre) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarHotelPorNombre'");
    }

    @Override
    public List<Hotel> buscarHotelPorLocalidad(String localidad) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarHotelPorLocalidad'");
    }

    @Override
    public Reserva consultarReserva(int idReserva, String dni) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'consultarReserva'");
    }

    @Override
    public List<Reserva> consultarReservasHotel(String nombreHotel) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'consultarReservasHotel'");
    }

    @Override
    public List<Habitacion> consultarDisponibilidad(String nombreHotel, Date fechaEntrada, Date fechaSalida) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'consultarDisponibilidad'");
    }

    @Override
    public Boolean bloquearReserva(Reserva reserva) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'bloquearReserva'");
    }

    @Override
    public int confirmarReserva(Reserva reserva, DatosClientes cliente, DatosPago pago) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'confirmarReserva'");
    }

    @Override
    public Reserva cancelarReserva(int idReserva, String dni) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'cancelarReserva'");
    }

}
