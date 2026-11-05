package es.unican.ps.business;

import es.unican.ps.domain.TipoHabitacion;

public interface IGestionarHabitaciones {

    public Boolean modificarTipoHabitacion(String nombreHotel, TipoHabitacion tipo, Double nuevoPrecio, int nuevasDisponibles);

    public Boolean anhadirTipoHabitacion(String nombreHotel, TipoHabitacion tipo, Double precioPorNoche, int disponibles);

    public Boolean eliminarTipoHabitacion(String nombreHotel, TipoHabitacion tipo);
}
