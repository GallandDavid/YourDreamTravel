package frubordeaux.domain.iRepository;

import frubordeaux.domain.value_object.ServicePlaceDate;

import java.util.List;
import java.util.UUID;

public interface ServicePlaceDateRepository {

    ServicePlaceDate load(UUID ID);

    void save(ServicePlaceDate servicePlaceDate);

    void update(ServicePlaceDate servicePlaceDate);

    List<ServicePlaceDate> loadAll();
}
