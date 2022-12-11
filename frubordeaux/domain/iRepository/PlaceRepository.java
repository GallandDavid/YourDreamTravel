package frubordeaux.domain.iRepository;

import frubordeaux.domain.value_object.Location;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

public interface PlaceRepository {

    Location load(UUID ID) throws IOException;

    int save(Location reservation);

    List<Location> loadAll();
}
