package frubordeaux.domain.iRepository;

import frubordeaux.domain.entity.FlyTicket;
import frubordeaux.domain.value_object.Fly;

import java.util.List;
import java.util.UUID;

public interface FlyTicketRepository {

    FlyTicket load(UUID ID);

    void save(FlyTicket reservation);

    void update(FlyTicket flyTicket);

    List<FlyTicket> loadAll();
}
