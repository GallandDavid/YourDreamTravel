package frubordeaux.application;

import frubordeaux.domain.agregate.Reservation;
import frubordeaux.domain.entity.FlightTicket;
import frubordeaux.domain.entity.ServicePlace;
import frubordeaux.domain.value_object.*;
import frubordeaux.infrastructure.*;
import frubordeaux.ui.UI;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        UI ui = new UI();
        String resultat;
        while (true) {
            resultat = ui.interfaceUtilisateur();
            if(!resultat.equals("")){
                if(resultat.getBytes()[0] == 'R'){
                    if(resultat.getBytes()[2] == '1'){
                        InMemoryFlyRepository flRepo = new InMemoryFlyRepository();
                        List<Flight> flight = flRepo.loadAll();
                        ui.displayListFlight(flight);
                    }
                    if(resultat.getBytes()[2] == '2'){
                        InMemoryFlyDateRepository flRepo = new InMemoryFlyDateRepository();
                        List<FlyDate> flightdate = flRepo.loadAll();
                        ui.displayListFlightDate(flightdate);
                    }
                    if(resultat.getBytes()[2] == '3'){
                        InMemoryFlyTicketRepository flRepo = new InMemoryFlyTicketRepository();
                        List<FlightTicket> flight = flRepo.loadAll();
                        ui.displayListFlightTicket(flight);
                    }
                    if(resultat.getBytes()[2] == '4'){
                        InMemoryPlaceRepository flRepo = new InMemoryPlaceRepository();
                        List<Location> locations = flRepo.loadAll();
                        ui.displayListPlace(locations);
                    }
                    if(resultat.getBytes()[2] == '5'){
                        InMemoryReservationRepository flRepo = new InMemoryReservationRepository();
                        List<Reservation> flight = flRepo.loadAll();
                        ui.displayListReservation(flight);
                    }
                    if(resultat.getBytes()[2] == '6'){
                        InMemoryServiceRepository flRepo = new InMemoryServiceRepository();
                        List<Service> flight = flRepo.loadAll();
                        ui.displayListService(flight);
                    }
                    if(resultat.getBytes()[2] == '7'){
                        InMemoryServicePlaceRepository flRepo = new InMemoryServicePlaceRepository();
                        List<ServicePlace> flight = flRepo.loadAll();
                        ui.displayListServicePlace(flight);
                    }
                    if(resultat.getBytes()[2] == '8'){
                        InMemoryServicePlaceDateRepository flRepo = new InMemoryServicePlaceDateRepository();
                        List<ServicePlaceDate> flight = flRepo.loadAll();
                        ui.displayListServicePlaceDate(flight);
                    }
                }
            }
        }
    }
}
