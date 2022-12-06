package frubordeaux.domain.iRepository;

import frubordeaux.domain.agregate.Reservation;
import frubordeaux.domain.value_object.Fly;
import frubordeaux.domain.value_object.FlyDate;

import java.util.List;
import java.util.UUID;

public interface FlyReposittory {
    Fly load(UUID ID);

    void save(Fly reservation);

    void update(Fly fly);

    List<Fly> loadAll();
}
