package es.unican.ps;

import es.unican.ps.business.IGestionarHabitacionesLocal;
import es.unican.ps.business.IGestionarHabitacionesRemote;
import es.unican.ps.dao.IHotelDAOLocal;
import es.unican.ps.domain.TipoHabitacion;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;

@Stateless
public class GestionarHabitaciones implements IGestionarHabitacionesLocal, IGestionarHabitacionesRemote{

    @EJB
    private IHotelDAOLocal hotelDAO;

    @Override
    public int modificarTipoHabitacion(String nombreHotel, TipoHabitacion tipo, Double nuevoPrecio,
            int nuevasDisponibles) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'modificarTipoHabitacion'");
    }

    @Override
    public Boolean anhadirTipoHabitacion(String nombreHotel, TipoHabitacion tipo, Double precioPorNoche,
            int disponibles) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'anhadirTipoHabitacion'");
    }

    @Override
    public Boolean eliminarTipoHabitacion(String nombreHotel, TipoHabitacion tipo) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eliminarTipoHabitacion'");
    }

}
