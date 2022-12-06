package frubordeaux.domain.iRepository;
import frubordeaux.domain.value_object.Service;

import java.util.UUID;

public interface ServiceRepository {

    Service load(UUID ID);

    void save(Service reservation);

    Service update();
}
