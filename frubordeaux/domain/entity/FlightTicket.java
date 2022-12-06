package frubordeaux.domain.entity;

import frubordeaux.domain.value_object.Flight;

import java.util.Date;
import java.util.UUID;

public class FlightTicket {
    private final UUID ID;
    private final Flight flight;
    private Date date;
    private Integer quantity;
    private Double price;
    private Integer percentageReduction;

    public FlightTicket(Flight flight, Date date, Integer quantity, Integer percentageReduction){
        this.ID  = UUID.randomUUID();
        this.flight = flight;
        this.date = date;
        this.quantity = quantity;
        this.price = flight.getPrice() * quantity.doubleValue();
        this.percentageReduction = percentageReduction;
    }

    public void changeQuantity(Integer place){
        this.quantity = place;
        this.price = getFly().getPrice() * getQuantity().doubleValue();
    }

    public void addQuantity(Integer quantity){
        this.quantity = this.quantity + quantity;
        this.price = getFly().getPrice() * getQuantity().doubleValue();
    }

    public void removeQuantity(Integer quantity){
        this.quantity = this.quantity - quantity;
        if(this.quantity < 0) this.quantity = 0;
        this.price = getFly().getPrice() * getQuantity().doubleValue();
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
}
