package frubordeaux.domain.agregate;

import frubordeaux.domain.entity.FlyTicket;
import frubordeaux.domain.value_object.Fly;
import frubordeaux.domain.value_object.Product;

import java.util.ArrayList;
import java.util.Map;
import java.util.UUID;

public class Reservation {
    private final UUID ID = UUID.randomUUID();
    private ArrayList<FlyTicket> flys = new ArrayList<>();
    //private Service
    private Double price = 0.0;

    public Reservation(){}

    public Double getPrice(){
        double price = 0;
        for (FlyTicket fly : flys ) {
            price += fly.getPrice();
        }
        return price;
    }

    public UUID getID() {
        return ID;
    }

    public void addFly(FlyTicket fly){
        if(flys.contains(fly.getID())){
            boolean find = false;
            for (FlyTicket flyTicket : flys) {
                if(flyTicket.getID().equals(fly.getID())){
                    flyTicket.addQuantity(fly.getPlace());
                    price = getPrice();
                }
            }
            if(!find){
                flys.add(fly);
                price = getPrice();
            }
        }
    }

    //recalculer prix
    public void deleteFly(Product ref){
        boolean find = false;
        for(FlyTicket fly : flys){
            if(fly.getID().equals(ref)){
                flys.remove(fly);
                price = getPrice();
                find = true;
                break;
            }
        }
        if(!find) { /*ERROR MESSAGE*/}
    }

    public void addCommandeLineQuantity(Product ref, Integer quantity){
        boolean find = false;
        for(FlyTicket fly : flys){
            if(fly.getID().equals(ref)){
                fly.addQuantity(quantity);
                price = getPrice();
                find = true;
                break;
            }
        }
        if(!find) { /*ERROR MESSAGE*/}
    }

    public void removeCommandeLineQuantity(Product ref, Integer quantity){
        boolean find = false;
        for(FlyTicket fly : flys){
            if(fly.getID().equals(ref)){
                fly.removeQuantity(quantity);
                price = getPrice();
                find = true;
                break;
            }
        }
        if(!find) { /*ERROR MESSAGE*/}
    }
}
