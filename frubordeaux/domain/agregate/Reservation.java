package frubordeaux.domain.agregate;

import frubordeaux.domain.entity.FlightTicket;
import frubordeaux.domain.value_object.Product;
import frubordeaux.domain.entity.ServicePlace;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Reservation {
    private final UUID ID;
    private ArrayList<FlightTicket> flights;

    private Map<FlightTicket, ServicePlace> services;
    //private Service.java
    private Double price;


    public Reservation(){
        flights = new ArrayList<>();
        ID = UUID.randomUUID();
        services = new HashMap<>();
        price = 0.0;
    }

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
        if(flights.contains(fly.getID())){
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
}
