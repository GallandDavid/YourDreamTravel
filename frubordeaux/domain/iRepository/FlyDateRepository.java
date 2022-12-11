package frubordeaux.domain.iRepository;

import frubordeaux.domain.value_object.Flight;
import frubordeaux.domain.value_object.FlyDate;

import java.util.List;
import java.util.UUID;

public interface FlyDateRepository {
    FlyDate load(UUID ID);

    List<FlyDate> load(Flight flight);

    int save(FlyDate reservation);

    void update(FlyDate flyDate);

    List<FlyDate> loadAll();
}
