package frubordeaux.domain.entity;

import frubordeaux.domain.value_object.Service;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

public abstract class ServicePlace {



    public final UUID ID = UUID.randomUUID();
    private Optional<Service> service;
    private ArrayList<ServicePlace> child;

    public ServicePlace(Optional<Service> service, ArrayList<ServicePlace> child){
        this.child = child;
        this.service = service;
    }

    public UUID getID() {
        return ID;
    }

    public Optional<Service> getService() {
        return service;
    }

    public ArrayList<ServicePlace> getChild() {
        return child;
    }
}
