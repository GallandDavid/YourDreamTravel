package frubordeaux.infrastructure;

import frubordeaux.domain.agregate.Reservation;
import frubordeaux.domain.iRepository.BasketRepository;

import java.util.UUID;

public class InMemoryBasketRepository implements BasketRepository {


    @Override
    public Reservation load(UUID ID) {
        return null;
    }

    @Override
    public void save(Reservation reservation) {

    }

    @Override
    public Reservation update() {
        return null;
    }
}
