package frubordeaux.domain.value_object;

import java.util.ArrayList;
import java.util.Optional;

public class ServiceLieuComposite extends ServiceLieu {

    public ServiceLieuComposite(ArrayList<ServiceLieu> child, Optional<Service>  service){
        super( service, child);
    }
 }
