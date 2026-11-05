package es.unican.ps.dao;

import java.util.List;

import es.unican.ps.domain.Hotel;

public interface IHotelDAO {

    public List<Hotel> hoteles();

    public Hotel hotel(int id);

    public Hotel creaHotel(Hotel h);

    public Hotel eliminaHotel(int id);

    public Hotel actulizaHotel(Hotel h);

    public  Hotel hotelPorNombre(String nombre);
}
