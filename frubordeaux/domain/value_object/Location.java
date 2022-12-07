package frubordeaux.domain.value_object;

import com.google.gson.annotations.SerializedName;
import frubordeaux.domain.Displayable;
import frubordeaux.infrastructure.InMemoryFlyRepository;
import frubordeaux.infrastructure.InMemoryServicePlaceRepository;

import java.util.UUID;

public class Location  implements Displayable {

    @SerializedName("ID")
    public UUID ID = UUID.randomUUID();
    @SerializedName("name")
    private final String name;
    @SerializedName("country")
    private final String country;
    @SerializedName("service_repo")
    private final InMemoryServicePlaceRepository serviceRepository = new InMemoryServicePlaceRepository();
    @SerializedName("fly_repo")
    private final InMemoryFlyRepository repository = new InMemoryFlyRepository();

    public Location(String name, String country){
        this.name = name;
        this.country = country;
    }

    public InMemoryServicePlaceRepository getServiceRepository() {
        return serviceRepository;
    }

    public InMemoryFlyRepository getRepository() {
        return repository;
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

    @Override
    public String displayRead() {
        String str = "";
        str += ("Place : " + name + " in " + country + "\n");
        str += ("ID : " + ID + "\n");
        str += ("fly_repo : " + repository + "\n");
        str += ("service_repo : " + serviceRepository + "\n");
        return str;
    }

    public String displayCompact() {
        String str = "";
        str += ("Place : " + name + " in " + country + "\n");
        return str;
    }

    @Override
    public boolean equals(Object obj){
        Location location = (Location) obj;
        if(location.name.equals(name) && location.country.equals(country)) return true;
        return false;
    }
}
