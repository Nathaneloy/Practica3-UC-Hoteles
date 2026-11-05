package es.unican.ps;

import es.unican.ps.business.IGestionarHabitacionesLocal;
import es.unican.ps.business.IGestionarHabitacionesRemote;
import es.unican.ps.dao.IHotelDAOLocal;
import es.unican.ps.domain.Habitacion;
import es.unican.ps.domain.Hotel;
import es.unican.ps.domain.TipoHabitacion;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;

@Stateless
public class GestionarHabitaciones implements IGestionarHabitacionesLocal, IGestionarHabitacionesRemote{

    @EJB
    private IHotelDAOLocal hotelDAO;

    @Override
    public Boolean modificarTipoHabitacion(String nombreHotel, TipoHabitacion tipo, Double nuevoPrecio,
            int nuevasDisponibles) {
        Hotel hotel = hotelDAO.hotelPorNombre(nombreHotel);
        Habitacion habitacion = hotel.getHabitaciones().get(tipo);
        habitacion.setPrecioPorNoche(nuevoPrecio);
        habitacion.setDisponibles(nuevasDisponibles);
        hotel.getHabitaciones().put(tipo, habitacion);

        return hotel == hotelDAO.actulizaHotel(hotel);
    }

    @Override
    public Boolean anhadirTipoHabitacion(String nombreHotel, TipoHabitacion tipo, Double precioPorNoche,
            int disponibles) {
        Habitacion habitacion = new Habitacion(disponibles, precioPorNoche, tipo);
        Hotel hotel = hotelDAO.hotelPorNombre(nombreHotel);
        hotel.getHabitaciones().put(tipo, habitacion);

        return hotel == hotelDAO.actulizaHotel(hotel);
    }

    @Override
    public Boolean eliminarTipoHabitacion(String nombreHotel, TipoHabitacion tipo) {
       Hotel hotel = hotelDAO.hotelPorNombre(nombreHotel);
       hotel.getHabitaciones().remove(tipo);
       return hotel == hotelDAO.actulizaHotel(hotel);
    }

}
