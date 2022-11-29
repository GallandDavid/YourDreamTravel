package frubordeaux.domain.value_object;

import java.util.ArrayList;
import java.util.Date;

public class Fly extends Product{


    private final String from;
    private final String to;

    public Fly(String ref, String name, String description, Double price, String from, String to) {
        super(ref, name, description, price);
        this.from = from;
        this.to = to;
    }
    public String getFrom() {
        return from;
    }
    public String getTo() {
        return to;
    }
}
