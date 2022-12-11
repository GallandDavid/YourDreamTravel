package frubordeaux.domain.agregate;

import com.google.gson.annotations.SerializedName;
import frubordeaux.domain.Displayable;
import frubordeaux.domain.entity.FlightTicket;
import frubordeaux.domain.value_object.Product;

import java.util.ArrayList;
import java.util.UUID;

public class Reservation  implements Displayable {
    @SerializedName("ID")
    private final UUID ID;
    @SerializedName("flights")
    private ArrayList<FlightTicket> flights;/*
    @SerializedName("services")
    private Map<FlightTicket, ServicePlace> services;*/
    @SerializedName("price")
    private Double price;


    public Reservation(){
        flights = new ArrayList<>();
        ID = UUID.randomUUID();/*
        services = new HashMap<>();*/
        price = 0.0;
    }


    /*
    * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    *  APPLIQUER REDUCTION DE CHAQUE VOL A LEUR PRIX
    * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    * */
    /**
     * Calculate the total price of the reservation
     *
     * nb : if there is a change in the reservation, the price must be recalculated.
     * nb : There is no need to multiply the quantity by the price, this is already
     * done in `FlightTicket`
     * @return reservation price
     */
    public Double getPrice(){
        double price = 0;
        for (FlightTicket fly : flights ) {
            price += fly.getPrice();
        }
        return price;
    }

    public UUID getID() {
        return ID;
    }

    /**
     * Add an airline ticket for the reservation.
     * If there is at least one similar air ticket, then its quantity is incremented,and
     * its price is automatically recalculated.
     *
     * @param fly
     */
    public void addFlight(FlightTicket fly){
        if(!flights.contains(fly.getID())){
            boolean find = false;
            for (FlightTicket flyTicket : flights) {
                if(flyTicket.getID().equals(fly.getID())){
                    flyTicket.addQuantity(fly.getQuantity());
                    price = getPrice();
                    find = true;
                }
            }
            if(!find){
                flights.add(fly);
                price = getPrice();
            }
        }
    }

    /**
     * remove a flight from the reservation. If there was more than one ticket
     * for a certain flight, they are all deleted.
     * @param ref
     */
    public void deleteFlight(Product ref){
        boolean find = false;
        for(FlightTicket fly : flights){
            if(fly.getID().equals(ref)){
                flights.remove(fly);
                price = getPrice();
                find = true;
                break;
            }
        }
        if(!find) { /*ERROR MESSAGE*/}
    }

    /**
     * Adds a quantity of ticket for a certain flight
     * @param ref the flight
     * @param quantity
     */
    public void addCommandeLineQuantity(Product ref, Integer quantity){
        boolean find = false;
        for(FlightTicket fly : flights){
            if(fly.getID().equals(ref)){
                fly.addQuantity(quantity);
                price = getPrice();
                find = true;
                break;
            }
        }
        if(!find) { /*ERROR MESSAGE*/}
    }

    /**
     * Remove a quantity of ticket for a certain flight
     * @param ref the flight
     * @param quantity
     */
    public void removeCommandeLineQuantity(Product ref, Integer quantity){
        boolean find = false;
        for(FlightTicket fly : flights){
            if(fly.getID().equals(ref)){
                fly.removeQuantity(quantity);
                price = getPrice();
                find = true;
                break;
            }
        }
        if(!find) { /*ERROR MESSAGE*/}
    }

    @Override
    public String displayRead() {
        String str = "This is the reservation n°" + ID + "\n";
        str += "Contains flights : " + "\n";
        for(FlightTicket flt : flights) str += flt.displayRead();
        str += "This travel cost : " + price + "€" + "\n";
        return str;
    }

    public void displayValidate() {
    }

    public ArrayList<FlightTicket> getFlightTicket() {
        return flights;
    }
}
