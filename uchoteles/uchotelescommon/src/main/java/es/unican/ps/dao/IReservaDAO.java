package es.unican.ps.dao;

import java.util.List;
import es.unican.ps.domain.Reserva;

public interface IReservaDAO {
    
    public List<Reserva> reservas();

    public Reserva reserva(int id);

    public Reserva creaReserva(Reserva h);

    public Reserva eliminaReserva(int id);

    public Reserva actulizaReserva(Reserva h);
}
