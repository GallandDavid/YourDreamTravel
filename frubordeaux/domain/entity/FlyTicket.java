package frubordeaux.domain.entity;

import frubordeaux.domain.value_object.Fly;
import frubordeaux.domain.value_object.Product;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

public class FlyTicket {
    private final UUID ID = UUID.randomUUID();
    private final Fly fly;
    private Date date;
    private Integer place;
    private Double price = 0.0;
    private Integer percentageReduction;

    public FlyTicket(Fly fly, Date date, Integer place, Integer percentageReduction){
        this.fly = fly;
        this.date =date;
        this.place = place;
        this.price = fly.getPrice() * place.doubleValue();
        this.percentageReduction = percentageReduction;
    }
    public Integer getPercentageReduction() {
        return percentageReduction;
    }
    public UUID getID() {
        return ID;
    }
    public Fly getFly() {
        return fly;
    }
    public Date getDate() {
        return date;
    }
    public Integer getPlace() {
        return place;
    }
    public Double getPrice() {
        return price;
    }

    public void changePlace(Integer place){
        this.place = place;
        this.price = getFly().getPrice() * getPlace().doubleValue();
    }

    public void addQuantity(Integer quantity){
        this.place = this.place + quantity;
        this.price = getFly().getPrice() * getPlace().doubleValue();
    }

    public void removeQuantity(Integer quantity){
        this.place = this.place - quantity;
        if(this.place < 0) this.place = 0;
        this.price = getFly().getPrice() * getPlace().doubleValue();
    }
}
