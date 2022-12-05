package frubordeaux.domain.value_object;

import java.util.ArrayList;
import java.util.Optional;

public class ServiceComposite implements ServiceComposite {
    private final Place place;
    private Optional<Hotel> hotel;
    private Optional<Car> car;
    private ArrayList<ServiceComposite> child;
 }
