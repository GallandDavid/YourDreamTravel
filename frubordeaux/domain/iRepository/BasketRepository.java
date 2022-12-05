package frubordeaux.domain.iRepository;

import frubordeaux.domain.agregate.Reservation;

import java.util.UUID;

public interface BasketRepository {

    public Reservation load(UUID ID);

    public void save(Reservation reservation);

    public Reservation update()
}
