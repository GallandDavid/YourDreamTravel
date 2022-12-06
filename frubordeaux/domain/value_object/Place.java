package frubordeaux.domain.value_object;

import com.google.gson.annotations.SerializedName;
import frubordeaux.infrastructure.InMemoryFlyRepository;
import frubordeaux.infrastructure.InMemoryServicePlaceRepository;

import java.util.UUID;

public class Place {

    @SerializedName("ID")
    public UUID ID = UUID.randomUUID();
    @SerializedName("name")
    private final String name;
    @SerializedName("country")
    private final String country;

    public InMemoryServicePlaceRepository getServiceRepository() {
        return serviceRepository;
    }

    public InMemoryFlyRepository getRepository() {
        return repository;
    }

    @SerializedName("service_repo")
    private final InMemoryServicePlaceRepository serviceRepository = new InMemoryServicePlaceRepository();
    @SerializedName("fly_repo")
    private final InMemoryFlyRepository repository = new InMemoryFlyRepository();

    public Place(String name, String country){
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
