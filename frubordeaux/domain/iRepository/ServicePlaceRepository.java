package frubordeaux.domain.iRepository;

import frubordeaux.domain.entity.ServicePlace;

import java.util.List;
import java.util.UUID;

public interface ServicePlaceRepository {

    ServicePlace load(UUID ID);

    void save(ServicePlace reservation);

    void update(ServicePlace servicePlace);

    List<ServicePlace> loadAll();
}
