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
                if(resultat.getBytes()[0] == 'r'){
                    Reservation reservation = new Reservation();
                    boolean running = true;
                    while(running) {
                        ui.displayFlightReservation();
                        Location from = ui.chooseADepartureLocation(getLocations(), 1).get(0);
                        if (from == null) {
                            running = false;
                            continue;
                        }
                        ui.displayFlightSelection();
                        Flight flight = ui.chooseAFlight(new InMemoryFlyRepository().load(from));
                        ui.displayFlightDateSelection();
                        if (flight == null) {
                            running = false;
                            continue;
                        }
                        FlyDate fd = ui.chooseAFlightDate(new InMemoryFlyDateRepository().load(flight));
                        ui.displayTicketType();
                        Integer percentageRed = ui.chooseTicketType(fd.getPrice(), fd.getNbTickets(), fd.getNbReducedTickets(), fd.getNbFirstTickets());
                        if (percentageRed == null) {
                            running = false;
                            continue;
                        }
                        ui.displayNbTicket();
                        Integer quantity = null;
                        if (percentageRed == 0) quantity = ui.chooseNbTickets(0, fd.getNbTickets() - fd.getNbReducedTickets() - fd.getNbFirstTickets());
                        if (percentageRed == -20) quantity = ui.chooseNbTickets(1, fd.getNbReducedTickets());
                        if (percentageRed == 30) quantity = ui.chooseNbTickets(2, fd.getNbFirstTickets());
                        if (quantity == null) {
                            running = false;
                            continue;
                        }
                        FlightTicket flightTicket = new FlightTicket(flight, fd.getDate(), quantity, fd.getPrice(), percentageRed);
                        ui.displayTicket(flightTicket);
                        ui.displayAddBasket();
                        if(ui.chooseYesNo()){
                            reservation.addFlight(flightTicket);
                        }
                        ui.displayNewTicket();
                        if(!ui.chooseYesNo()) {
                            ui.displayValidate();
                            if(ui.chooseYesNo()){
                                if(new InMemoryReservationRepository().save(reservation) == -1) ui.AlreadyExist();
                                for (FlightTicket ft : reservation.getFlightTicket()) {
                                    if (new InMemoryFlyTicketRepository().save(ft) == -1) ui.AlreadyExist();
                                }
                                ui.displayReservationValidation(reservation);
                                reservation = new Reservation();
                                running = false;
                            }else running = false;
                        }
                    }
                    ui.reset();
                } else if(resultat.getBytes()[0] == 'R'){
                    if(resultat.getBytes()[2] == '1') ui.displayListFlight(getFlights());
                    if(resultat.getBytes()[2] == '2') ui.displayListFlightDate(getFlightsDate());
                    if(resultat.getBytes()[2] == '3') ui.displayListFlightTicket(getTickets());
                    if(resultat.getBytes()[2] == '4') ui.displayListPlace(getLocations());
                    if(resultat.getBytes()[2] == '5') ui.displayListReservation(getReservations());
                    if(resultat.getBytes()[2] == '6') ui.displayListService(getServices());
                    if(resultat.getBytes()[2] == '7') ui.displayListServicePlace(getServicesPlace());
                    if(resultat.getBytes()[2] == '8') ui.displayListServicePlaceDate(getServicesPlaceDate());
                } else if(resultat.getBytes()[0] == 'W') {
                    if(resultat.getBytes()[2] == '1') if(new InMemoryFlyRepository().save(ui.writeFlight(getLocations())) == -1) ui.AlreadyExist();
                    if(resultat.getBytes()[2] == '2') if(new InMemoryFlyDateRepository().save(ui.writeFlightDate(getFlights())) == -1) ui.AlreadyExist();
                    if(resultat.getBytes()[2] == '3');
                    if(resultat.getBytes()[2] == '4') if(new InMemoryPlaceRepository().save(ui.writePlace()) == -1) ui.AlreadyExist();
                    if(resultat.getBytes()[2] == '5');
                    if(resultat.getBytes()[2] == '6');
                    if(resultat.getBytes()[2] == '7');
                    if(resultat.getBytes()[2] == '8');
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
