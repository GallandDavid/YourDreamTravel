package frubordeaux.domain.iRepository;

import frubordeaux.domain.value_object.Flight;

import java.util.List;
import java.util.UUID;

public interface FlyReposittory {
    Flight load(UUID ID);

    void save(Flight reservation);

    void update(Flight flight);

    List<Flight> loadAll();
}
