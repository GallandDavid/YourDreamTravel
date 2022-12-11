package frubordeaux.domain.iRepository;

import frubordeaux.domain.agregate.Reservation;

import java.util.List;
import java.util.UUID;

public interface ReservationRepository {
    Reservation load(UUID ID);

    int save(Reservation reservation);

    void update(Reservation reservation);

    List<Reservation> loadAll();
}
