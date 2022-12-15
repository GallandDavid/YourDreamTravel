package frubordeaux.domain.iRepository;

import frubordeaux.domain.value_object.Flight;
import frubordeaux.domain.value_object.FlightDate;

import java.util.List;
import java.util.UUID;

public interface FlyDateRepository {
    FlightDate load(UUID ID);

    List<FlightDate> load(Flight flight);

    int save(FlightDate reservation);

    void update(FlightDate flightDate);

    List<FlightDate> loadAll();
}
