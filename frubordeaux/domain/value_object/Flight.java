package frubordeaux.domain.value_object;

import com.google.gson.annotations.SerializedName;
import frubordeaux.domain.Displayable;

import java.util.UUID;

public class Flight extends Product implements Displayable {
    @SerializedName("ID")
    private final UUID ID = UUID.randomUUID();
    @SerializedName("from")
    private final Location from;
    @SerializedName("too")
    private final Location to;

    public Flight(String ref, String name, String description, Double price, Location from, Location to) {
        super(ref, name, description, price);
        this.from = from;
        this.to = to;
    }

    /* GETTERS */

    public Location getFrom() {
        return from;
    }
    public Location getTo() {
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
