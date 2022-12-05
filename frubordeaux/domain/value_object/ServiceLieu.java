package frubordeaux.domain.value_object;

import java.util.ArrayList;
import java.util.Optional;

public abstract class ServiceLieu {

    private Optional<Service> service;
    private ArrayList<ServiceLieu> child;

    public ServiceLieu(Optional<Service> service, ArrayList<ServiceLieu> child){
        this.child = child;
        this.service = service;
    }
}
