package frubordeaux.domain.value_object;

import com.google.gson.annotations.SerializedName;
import frubordeaux.infrastructure.InMemoryFlyRepository;
import frubordeaux.infrastructure.InMemoryServicePlaceRepository;

import java.util.UUID;

public class Location {

    @SerializedName("ID")
    public UUID ID = UUID.randomUUID();

    @SerializedName("name")
    private final String name;

    @SerializedName("country")
    private final String country;

    @SerializedName("service_repo")
    private final InMemoryServicePlaceRepository serviceRepository;

    @SerializedName("fly_repo")
    private final InMemoryFlyRepository repository;

    public InMemoryServicePlaceRepository getServiceRepository() {
        return serviceRepository;
    }

    public InMemoryFlyRepository getRepository() {
        return repository;
    }


    public Location(String name, String country){
        serviceRepository = new InMemoryServicePlaceRepository();
        repository = new InMemoryFlyRepository();

        this.name = name;
        this.country = country;
    }

    public UUID getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }
}
