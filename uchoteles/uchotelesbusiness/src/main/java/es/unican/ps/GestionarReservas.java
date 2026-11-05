package es.unican.ps;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import es.unican.ps.business.IGestionarReservasLocal;
import es.unican.ps.business.IGestionarReservasRemote;
import es.unican.ps.business.IInformacionReservasLocal;
import es.unican.ps.business.IInformacionReservasRemote;
import es.unican.ps.dao.IHotelDAOLocal;
import es.unican.ps.dao.IReservaDAOLocal;
import es.unican.ps.domain.DatosClientes;
import es.unican.ps.domain.DatosPago;
import es.unican.ps.domain.Habitacion;
import es.unican.ps.domain.Hotel;
import es.unican.ps.domain.Reserva;
import es.unican.ps.exceptions.ReservaNoAccesible;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;

@Stateless
public class GestionarReservas implements IGestionarReservasLocal, IInformacionReservasLocal, IGestionarReservasRemote, IInformacionReservasRemote {

    @EJB
    private IHotelDAOLocal hotelDAO;

    @EJB
    private IReservaDAOLocal reservaDAO;

    @Override
    public Hotel buscarHotelPorNombre(String nombre) {
        return hotelDAO.hotelPorNombre(nombre);
    }

    @Override
    public List<Hotel> buscarHotelPorLocalidad(String localidad) {
        List<Hotel> hotelesPorLocalidad = new ArrayList<>();
        List<Hotel> hoteles = hotelDAO.hoteles();

        for (Hotel h : hoteles) {
            if (h.getLocalidad() == localidad) hotelesPorLocalidad.add(h);
        }
        return hotelesPorLocalidad;
    }

    @Override
    public Reserva consultarReserva(int idReserva, String dni) {
        Reserva reserva = reservaDAO.reserva(idReserva);
        if (reserva == null) return null;
        if (reserva.getClientes().getDni() == dni) return reserva;
        throw new ReservaNoAccesible();
    }

    @Override
    public List<Reserva> consultarReservasHotel(String nombreHotel) {
        List<Reserva> reservas = reservaDAO.reservas();
        if (reservas.isEmpty()) return null;
        return reservas;
    }

    @Override
    public List<Habitacion> consultarDisponibilidad(String nombreHotel, Date fechaEntrada, Date fechaSalida) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'consultarDisponibilidad'");
    }

    @Override
    public Boolean bloquearReserva(Reserva reserva) {
        reserva.setBloqueada(true);
        return null != reservaDAO.creaReserva(reserva);
    }

    @Override
    public int confirmarReserva(Reserva reserva, DatosClientes cliente, DatosPago pago) {
        reserva.setClientes(cliente);
        reserva.setDatos(pago);
        return null != reservaDAO.actulizaReserva(reserva);
    }

    @Override
    public Reserva cancelarReserva(int idReserva, String dni) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'cancelarReserva'");
    }

}
