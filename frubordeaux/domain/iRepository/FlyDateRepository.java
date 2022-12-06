package frubordeaux.domain.iRepository;

import frubordeaux.domain.agregate.Reservation;
import frubordeaux.domain.value_object.FlyDate;

import java.util.List;
import java.util.UUID;

public interface FlyDateRepository {
    FlyDate load(UUID ID);

    void save(FlyDate reservation);

    void update(FlyDate flyDate);

    List<FlyDate> loadAll();
}
