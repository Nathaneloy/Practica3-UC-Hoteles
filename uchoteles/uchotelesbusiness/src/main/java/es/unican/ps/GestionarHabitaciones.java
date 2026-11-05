package es.unican.ps;

import es.unican.ps.business.IGestionarHabitaciones;
import es.unican.ps.domain.TipoHabitacion;

public class GestionarHabitaciones implements IGestionarHabitaciones{

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
