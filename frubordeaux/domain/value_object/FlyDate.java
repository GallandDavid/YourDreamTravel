package frubordeaux.domain.value_object;

import com.google.gson.annotations.SerializedName;
import frubordeaux.domain.Displayable;

import java.util.Date;
import java.util.UUID;

//modification du value object pour permettre de savoir combien de ticket il reste
public class FlyDate  implements Displayable {
    @SerializedName("ID")
    private final UUID ID = UUID.randomUUID();
    @SerializedName("flight")
    private final Flight flight;
    @SerializedName("date")
    private final Date date;
    @SerializedName("price")
    private final Double price;
    @SerializedName("nbTickets")
    private final Integer nbTickets;
    @SerializedName("nbFirstTickets")
    private Integer nbFirstTickets;
    @SerializedName("nbReducedTickets")
    private Integer nbReducedTickets;

    public FlyDate(Flight flight, Date date, Integer nbTickets, Integer nbFirstTickets, Integer nbReducedTickets, Double price){
        this.flight = flight;
        this.price = price;
        this.date = date;
        this.nbTickets = nbTickets;
        this.nbFirstTickets = nbFirstTickets;
        this.nbReducedTickets = nbReducedTickets;
    }

    /* GETTER */

    public Flight getFly() {
        return flight;
    }

    public Date getDate() {
        return date;
    }

    public Integer getNbTickets() {
        return nbTickets;
    }

    public Integer getNbFirstTickets() {
        return nbFirstTickets;
    }

    public Integer getNbReducedTickets() {
        return nbReducedTickets;
    }
    public UUID getID() {
        return ID;
    }

    @Override
    public String displayRead() {
        String str = flight.displayRead();
        str += "Who taking of the " + date + "\n";
        str += "Have the n°" + ID + "\n";
        str += "It remains " + nbTickets +" :\n";
        str += "\t- " + nbReducedTickets + " reduced tickets\n\t- " + nbFirstTickets + " first class tickets\n";
        return str;
    }
}
