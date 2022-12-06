package frubordeaux.domain.entity;

import frubordeaux.domain.value_object.Flight;
import frubordeaux.domain.value_object.FlyDate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* A flight with a departure and an arrival, takes place on several available dates.*/

public class FlightListDate {
    public Map<Flight, ArrayList<FlyDate>> flights;

    public FlightListDate(){
        flights = new HashMap();
        /*
        * Get all the flights on the repository
        * */
    }
}
