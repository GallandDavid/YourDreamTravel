package frubordeaux.domain.value_object;

import frubordeaux.domain.entity.ServicePlace;

import java.util.ArrayList;
import java.util.Optional;

public class ServicePlaceComposite extends ServicePlace {

    public ServicePlaceComposite(ArrayList<ServicePlace> child, Optional<Service>  service){
        super( service, child);
    }
 }
