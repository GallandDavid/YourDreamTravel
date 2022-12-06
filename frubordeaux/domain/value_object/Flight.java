package frubordeaux.domain.value_object;

import com.google.gson.annotations.SerializedName;
import frubordeaux.domain.Displayable;

import java.util.UUID;

public class Flight extends Product implements Displayable {
    @SerializedName("ID")
    private final UUID ID = UUID.randomUUID();
    @SerializedName("from")
    private final Place from;
    @SerializedName("too")
    private final Place to;

    public Flight(String ref, String name, String description, Double price, Place from, Place to) {
        super(ref, name, description, price);
        this.from = from;
        this.to = to;
    }

    /* GETTERS */

    public Place getFrom() {
        return from;
    }
    public Place getTo() {
        return to;
    }

    public UUID getID() {
        return ID;
    }

    @Override
    public String displayRead() {
        return null;
    }
}
