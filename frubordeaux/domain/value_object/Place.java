package frubordeaux.domain.value_object;

import frubordeaux.infrastructure.InMemoryLieuRepository;

public class Place {
    public double price = 0.0;
    private final String name;
    private final String country;
    private final InMemoryLieuRepository repository = new InMemoryLieuRepository();

    public Place(String name, String country){
        this.name = name;
        this.country = country;
    }
}
