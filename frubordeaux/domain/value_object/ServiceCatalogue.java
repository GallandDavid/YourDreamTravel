package frubordeaux.domain.value_object;

import java.util.ArrayList;

public class ServiceCatalogue {
    private final Place place;
    private final ArrayList<Hotel> hotels;
    private final ArrayList<Car> cars;

    public ServiceCatalogue(Place place, ArrayList<Hotel> hotels, ArrayList<Car> cars){
        this.place = place;
        this.hotels = hotels;
        this.cars = cars;
    }
}
