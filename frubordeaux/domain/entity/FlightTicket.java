package frubordeaux.domain.entity;

import com.google.gson.annotations.SerializedName;
import frubordeaux.domain.Displayable;
import frubordeaux.domain.value_object.Flight;

import java.util.Date;
import java.util.UUID;

public class FlightTicket implements Displayable {
    @SerializedName("ID")
    private final UUID ID;
    @SerializedName("flight")
    private final Flight flight;
    @SerializedName("date")
    private Date date;
    @SerializedName("quantity")
    private Integer quantity;
    @SerializedName("ticket_price")
    private Double ticket_price;
    @SerializedName("price")
    private Double price;
    @SerializedName("percentageReduction")
    private Integer percentageReduction;

    public FlightTicket(Flight flight, Date date, Integer quantity, Double ticket_price, Integer percentageReduction){
        this.ID  = UUID.randomUUID();
        this.flight = flight;
        this.date = date;
        this.quantity = quantity;
        this.ticket_price = ticket_price;
        this.price = getPrice();
        this.percentageReduction = percentageReduction;
    }

    /**
     * Modify the quantity of the air ticket
     * @param quantity
     */
    public void changeQuantity(Integer quantity){
        this.quantity = quantity;
        this.price = ticket_price * getQuantity().doubleValue();
    }

    /**
     * add a quantity to the number of air tickets
     * @param quantity
     */
    public void addQuantity(Integer quantity){
        this.quantity = this.quantity + quantity;
        this.price = price + ticket_price * getQuantity().doubleValue();
    }

    /**
     * remove a quantity to the number of air tickets
     * @param quantity
     */
    public void removeQuantity(Integer quantity){
        this.quantity = this.quantity - quantity;
        if(this.quantity < 0) this.quantity = 0;
        this.price = price - ticket_price * getQuantity().doubleValue();
    }


    /** GETTERS **/

    public Integer getPercentageReduction() {
        return percentageReduction;
    }
    public UUID getID() {
        return ID;
    }
    public Flight getFly() {
        return flight;
    }
    public Date getDate() {
        return date;
    }
    public Integer getQuantity() {
        return quantity;
    }
    public Double getPrice() {
        return price;
    }

    @Override
    public String displayRead() {
        String str = "Flight ticket n°" + ID + "\n";
        str += "The " + date + "\n";
        str += "For the flight : " + "\n" + flight.displayRead();
        str += "For " + quantity + " people" + "\n";
        str += "With " + percentageReduction + "%" + "\n";
        str += "Cost : " + price + "€" + "\n";
        return str;
    }
}
