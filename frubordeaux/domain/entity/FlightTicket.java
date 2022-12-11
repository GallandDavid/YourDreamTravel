package frubordeaux.domain.entity;

import com.google.gson.annotations.SerializedName;
import frubordeaux.domain.Displayable;
import frubordeaux.domain.value_object.Date;
import frubordeaux.domain.value_object.Flight;


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
        this.percentageReduction = percentageReduction;
        this.price = getPrice();

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
        if(percentageReduction == 0) return ticket_price * quantity;
        return ((ticket_price + (ticket_price * percentageReduction /100)) * quantity);
    }

    @Override
    public String displayRead() {
        String str = "Flight ticket n°" + ID + "\n";
        str = str + "The " + date.dateFormat() + "\n";
        str = str + "For the flight : " + "\n" + flight.displayRead();
        str = str + "For " + quantity + " people" + "\n";
        str = str + "With " + percentageReduction + "%" + "\n";
        str = str + "Cost : " + price + "€" + "\n";
        return str;
    }
}
