package frubordeaux.domain.value_object;

import com.google.gson.annotations.SerializedName;
import frubordeaux.domain.Displayable;

import java.util.UUID;

public class Flight implements Displayable {
    @SerializedName("ID")
    private final UUID ID = UUID.randomUUID();
    @SerializedName("from")
    private final Location from;
    @SerializedName("too")
    private final Location to;

    public Flight(Location from, Location to) {
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
        String str = "Flight n°" + ID + "\n";
        str += "From : " + "\n" + from.displayRead();
        str += "To : " + "\n" + to.displayRead();
        return str;
    }
    @Override
    public boolean equals(Object obj){
        Flight flight = (Flight) obj;
        if(flight.from.equals(from) && flight.to.equals(to)) return true;
        return false;
    }

    public String displayCompact() {
        String str = "";
        str += ("Flight :\n\t- From : " + getFrom().displayCompact() + "\t- Too : " + to.displayCompact());
        return str;
    }
}
