package frubordeaux.domain.iRepository;

import frubordeaux.domain.value_object.Flight;
import frubordeaux.domain.value_object.Location;

import java.util.List;
import java.util.UUID;

public interface FlyReposittory {
    Flight load(UUID ID);
    Integer save(Flight reservation);
    List<Flight> loadAll();
    List<Flight> load(Location from);
}
