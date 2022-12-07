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
                    if(resultat.getBytes()[2] == '1') ui.displayListFlight(getFlights());
                    if(resultat.getBytes()[2] == '2') ui.displayListFlightDate(getFlightsDate());
                    if(resultat.getBytes()[2] == '3') ui.displayListFlightTicket(getTickets());
                    if(resultat.getBytes()[2] == '4') ui.displayListPlace(getLocations());
                    if(resultat.getBytes()[2] == '5') ui.displayListReservation(getReservations());
                    if(resultat.getBytes()[2] == '6') ui.displayListService(getServices());
                    if(resultat.getBytes()[2] == '7') ui.displayListServicePlace(getServicesPlace());
                    if(resultat.getBytes()[2] == '8') ui.displayListServicePlaceDate(getServicesPlaceDate());
                } else if(resultat.getBytes()[0] == 'W') {
                    if(resultat.getBytes()[2] == '1') if(new InMemoryFlyRepository().save(ui.writeFlight(getLocations())) == -1) ui.flightAlreadyExist();
                    if(resultat.getBytes()[2] == '2') ui.writeFlightDate();
                    if(resultat.getBytes()[2] == '3') ui.writeTicket();
                    if(resultat.getBytes()[2] == '4') ui.writePlace();
                    if(resultat.getBytes()[2] == '5') ui.writeReservation();
                    if(resultat.getBytes()[2] == '6') ui.writeService();
                    if(resultat.getBytes()[2] == '7') ui.writeServicePlace();
                    if(resultat.getBytes()[2] == '8') ui.writeServiceDatePlace();
                }
            }
        }
    }

    private static List<ServicePlaceDate> getServicesPlaceDate() {
        InMemoryServicePlaceDateRepository flRepo = new InMemoryServicePlaceDateRepository();
        return flRepo.loadAll();
    }

    private static List<ServicePlace> getServicesPlace() {
        InMemoryServicePlaceRepository flRepo = new InMemoryServicePlaceRepository();
        return flRepo.loadAll();
    }

    private static List<Service> getServices() {
        InMemoryServiceRepository flRepo = new InMemoryServiceRepository();
        return flRepo.loadAll();
    }

    private static List<Reservation> getReservations() {
        InMemoryReservationRepository flRepo = new InMemoryReservationRepository();
        return flRepo.loadAll();
    }

    private static List<Location> getLocations() {
        InMemoryPlaceRepository flRepo = new InMemoryPlaceRepository();
        return flRepo.loadAll();
    }

    private static List<FlightTicket> getTickets() {
        InMemoryFlyTicketRepository flRepo = new InMemoryFlyTicketRepository();
        return flRepo.loadAll();
    }

    private static List<FlyDate> getFlightsDate() {
        InMemoryFlyDateRepository flRepo = new InMemoryFlyDateRepository();
        return flRepo.loadAll();
    }

    private static List<Flight> getFlights() {
        InMemoryFlyRepository flRepo = new InMemoryFlyRepository();
        return flRepo.loadAll();
    }
}
