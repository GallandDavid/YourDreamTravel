package frubordeaux.domain.iRepository;

import frubordeaux.domain.value_object.Place;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

public interface PlaceRepository {

    Place load(UUID ID) throws IOException;

    void save(Place reservation);


    List<Place> loadAll();
}
