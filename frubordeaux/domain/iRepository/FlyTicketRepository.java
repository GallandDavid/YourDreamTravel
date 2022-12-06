package frubordeaux.domain.iRepository;

import frubordeaux.domain.entity.FlightTicket;

import java.util.List;
import java.util.UUID;

public interface FlyTicketRepository {

    FlightTicket load(UUID ID);

    void save(FlightTicket reservation);

    void update(FlightTicket flyTicket);

    List<FlightTicket> loadAll();
}
