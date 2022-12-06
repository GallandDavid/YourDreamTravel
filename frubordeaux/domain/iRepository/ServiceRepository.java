package frubordeaux.domain.iRepository;
import frubordeaux.domain.value_object.Service;

import java.util.List;
import java.util.UUID;

public interface ServiceRepository {

    Service load(UUID ID);

    void save(Service reservation);

    void update(Service service);

    List<Service> loadAll();
}
