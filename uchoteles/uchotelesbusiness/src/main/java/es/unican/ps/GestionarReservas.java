package es.unican.ps;

import java.sql.Date;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

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
import es.unican.ps.domain.ReservaTipoHabitacion;
import es.unican.ps.domain.TipoHabitacion;
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

    //Se llama desde dentro de consulta hotel asi que nombreHotel siempre va a existir
    @Override
    public List<Reserva> consultarReservasHotel(String nombreHotel) {
        List<Reserva> reservas = hotelDAO.hotelPorNombre(nombreHotel).getReservas();
        reservas.sort(Comparator.comparing(Reserva::getFechaEntrada));
        return reservas;
    }



// Precondicion: nombreHotel != null && fechaEntrada != null && fechaSalida != null
// Precondicion: fechaEntrada.isBefore(fechaSalida)
// Se llama desde dentro de buscar hotel asi que nombreHotel siempre va a existir
@Override
public List<Habitacion> consultarDisponibilidad(String nombreHotel, LocalDate fechaEntrada, LocalDate fechaSalida) {

    Hotel hotel = hotelDAO.hotelPorNombre(nombreHotel);


    Map<TipoHabitacion, Habitacion> habitaciones = hotel.getHabitaciones();
    boolean hayAlgunaDisponible = false;

    for (Habitacion hab : habitaciones.values()) {
        int ocupadas = 0;

        for (Reserva r : hotel.getReservas()) {
            if (fechaEntrada.isBefore(r.getFechaSalida()) && fechaSalida.isAfter(r.getFechaEntrada())) {
                for (ReservaTipoHabitacion linea : r.getLineasReservas()) {
                    if (linea.getHabitacion().getTipo() == hab.getTipo()) {
                        ocupadas += linea.getNumHabitaciones();
                    }
                }
            }
        }

        int libres = hab.getDisponibles() - ocupadas;
        
        if (libres > 0) {
            hayAlgunaDisponible = true;
        } else libres = 0;

        hab.setDisponibles(libres);
    }

    if (!hayAlgunaDisponible) {
        return null;
    }

    return new ArrayList<>(habitaciones.values());
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
        reserva.setBloqueada(false);
        reserva = reservaDAO.actulizaReserva(reserva);
        return reserva.getId();
    }

    //No hace falta comprobar si el usuario es el dueño porque ya se llama desde consulta reserva
    //devuelve null si faltan menos de 2 días para la fecha de entrada
    @Override
    public Reserva cancelarReserva(int idReserva) {
        Reserva reserva = reservaDAO.reserva(idReserva);
        if (ChronoUnit.DAYS.between(LocalDate.now(), reserva.getFechaEntrada()) < 2) return null;
        return reservaDAO.eliminaReserva(idReserva);
    }

}
