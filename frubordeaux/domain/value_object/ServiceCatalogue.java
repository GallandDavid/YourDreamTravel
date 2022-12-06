package frubordeaux.domain.value_object;

import java.util.ArrayList;

public class ServiceCatalogue {
    private final Location location;
    private final ArrayList<Hotel> hotels;
    private final ArrayList<Car> cars;

    public ServiceCatalogue(Location location, ArrayList<Hotel> hotels, ArrayList<Car> cars){
        this.location = location;
        this.hotels = hotels;
        this.cars = cars;
    }
}
