package frubordeaux.ui;

import frubordeaux.domain.agregate.Reservation;
import frubordeaux.domain.entity.FlightTicket;
import frubordeaux.domain.entity.ServicePlace;
import frubordeaux.domain.value_object.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UI {

    private MenuIndice menuIndice;

    public UI() {
        menuIndice = MenuIndice.HOME;
    }


    /**
     * Set up the main user interface :
     * - Display the interface
     * - Wait for a response from the user
     * - Returns a code that distinguishes which action the user wants to do
     *
     * @return action code
     */
    public String interfaceUtilisateur() {
        clearConsole();
        displayGoodInformation();
        System.out.println(menuIndice);
        String result = applyGoodAction();
        if (!result.equals("")) return result;
        return "";
    }

    /**
     * Get the action chosen by the user, depending on where the user is located.
     *
     * @return action code
     */
    private String applyGoodAction() {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Make your choice :");
        String input = myObj.nextLine();

        // Back to Home
        if (input.equals("0")) menuIndice = MenuIndice.HOME;
            // Do some actions
        else {
            switch (menuIndice) {
                case HOME:
                    if (input.equals("1")) {
                        menuIndice = MenuIndice.RESERVATION;
                    } else if (input.equals("2")) {
                        menuIndice = MenuIndice.DATA;
                    }
                    break;
                case RESERVATION:
                    if (input.equals("1")) {
                        menuIndice = MenuIndice.RESERVATION_CHOICE;
                        return "r 1";
                    } else if (input.equals("2")) {
                        menuIndice = MenuIndice.RESERVATION_CREATION;
                        return "r 2";
                    }
                    break;
                case DATA:
                    if (input.equals("1")) menuIndice = MenuIndice.DATA_READ;
                    else if (input.equals("2")) menuIndice = MenuIndice.DATA_WRITE;
                    break;
                case RESERVATION_CHOICE:
                case RESERVATION_CREATION:
                case DATA_READ:
                    try {
                        if (Integer.parseInt(input) >= 1 && Integer.parseInt(input) <= 8)
                            return "R " + input;
                    } catch (Exception e) {
                        // Do nothing, just catch the exception, and start again thanks to UI
                    }
                    break;
                case DATA_WRITE:
                    try {
                        if (Integer.parseInt(input) >= 1 && Integer.parseInt(input) <= 8)
                            return "W " + input;
                    } catch (Exception e) {
                        // Do nothing, just catch the exception, and start again thanks to UI
                    }
                    break;
                default:
            }
        }
        return "";

        // Which action depending on the menu


        /*
        if(menuIndice == 0){
            if(input.equals("1")) {
                menuIndice = 1;
            }else if(input.equals("2")) {
                menuIndice = 2;
            }
        }

        else if(menuIndice == 1){
            if(input.equals("0")) menuIndice = 0;
            else if(input.equals("1")){
                menuIndice = 11;
                return "r 1";
            }
            else if(input.equals("2")){
                menuIndice = 12;
                return "r 2";
            }
        }

        else if(menuIndice == 11){
        }

        else if(menuIndice == 12){
        }

        else if(menuIndice == 2){
            if(input.equals("0")) menuIndice = 0;
            else if(input.equals("1")) menuIndice = 21;
            else if(input.equals("2")) menuIndice = 22;
        }else if(menuIndice == 21){
            if(input.equals("0")) menuIndice = 0;
            else if(input.equals("1")) return "R 1";
            else if(input.equals("2")) return "R 2";
            else if(input.equals("3")) return "R 3";
            else if(input.equals("4")) return "R 4";
            else if(input.equals("5")) return "R 5";
            else if(input.equals("6")) return "R 6";
            else if(input.equals("7")) return "R 7";
            else if(input.equals("8")) return "R 8";
        }else if(menuIndice == 22){
            if(input.equals("0")) menuIndice = 0;
            else if(input.equals("1")) return "W 1";
            else if(input.equals("2")) return "W 2";
            else if(input.equals("3")) return "W 3";
            else if(input.equals("4")) return "W 4";
            else if(input.equals("5")) return "W 5";
            else if(input.equals("6")) return "W 6";
            else if(input.equals("7")) return "W 7";
            else if(input.equals("8")) return "W 8 ";
        }
        return "";*/
    }

    /**
     * Displays the correct interface depending on where the user is located
     */
    private void displayGoodInformation() {
        switch (menuIndice) {
            case HOME:
                chooseMainAction();
                break;
            case RESERVATION:
                displayReservationAction();
                break;
            case DATA:
                chooseActionData();
                break;
            case RESERVATION_CHOICE:
                break;
            case RESERVATION_CREATION:
                break;
            case DATA_READ:
            case DATA_WRITE:
                chooseData();
                break;
            default:
        }
/*
        if (menuIndice == 0) {
            chooseMainAction();
        } else if (menuIndice == 1) {
            displayReservationAction();
        } else if (menuIndice == 10) {

        } else if (menuIndice == 2) {
            chooseActionData();
        } else if (menuIndice == 21) {
            chooseData();
        } else if (menuIndice == 22) {
            chooseData();
        } else if (menuIndice == 3) {

        }*/
    }

    /**
     * Displays the user interface from reservation page
     */
    private void displayReservationAction() {
        System.out.println("0) Back ");
        System.out.println("1) Choose Flights ");
        System.out.println("2) Create a travel");
    }

    /**
     * Displays the user interface from data page
     */
    private void chooseData() {
        System.out.println("0) Back \n" +
                "1) Flight \n" +
                "2) Flight Date\n" +
                "3) Tickets\n" +
                "4) Places\n" +
                "5) Reservation\n" +
                "6) Service\n" +
                "7) Service at Place\n" +
                "8) Service Date at Place\n");
    }

    /**
     * Displays the user interface from Home page
     */
    private void chooseMainAction() {
        System.out.println("1) Reservation\n" +
                "2) Data");
    }

    /**
     * Displays the user interface from data Home page
     */
    private void chooseActionData() {
        System.out.println("0) Back\n" +
                "1) Read\n" +
                "2) Write");
    }

    //trouver un truc qui marche sur IDE
    public final static void clearConsole() {
    }

    /*
    * A faire pour assembler les 8 fonction suivante en 1
    *

    public void displayList(List<Displayable> flight) {}

    */

    public void displayListFlight(List<Flight> flight) {
        for (Flight fly : flight) {
            System.out.println(fly.displayRead());
        }
    }

    public void displayListPlace(List<Location> locations) {
        for (Location location : locations) {
            System.out.println(location.displayRead());
        }
    }

    public void displayListFlightDate(List<FlightDate> flightDate) {
        for (FlightDate flyDate : flightDate) {
            System.out.println(flyDate.displayRead());
        }
    }

    public void displayListFlightTicket(List<FlightTicket> flightTickets) {
        for (FlightTicket flightTicket : flightTickets) {
            System.out.println(flightTicket.displayRead());
        }
    }

    public void displayListReservation(List<Reservation> reservations) {
        for (Reservation reservation : reservations) {
            System.out.println(reservation.displayRead());
        }
    }

    public void displayListService(List<Service> services) {
        for (Service service : services) {
            System.out.println(service.displayRead());
        }
    }

    public void displayListServicePlace(List<ServicePlace> servicesPlace) {
        for (ServicePlace servicePlace : servicesPlace) {
            System.out.println(servicePlace.displayRead());
        }
    }

    public void displayListServicePlaceDate(List<ServicePlaceDate> servicesPlaceDate) {
        for (ServicePlaceDate servicePlaceDate : servicesPlaceDate) {
            System.out.println(servicePlaceDate.displayRead());
        }
    }

    public Flight chooseAFlight(List<Flight> flights) {
        Integer input_int;
        String input;
        Scanner myObj = new Scanner(System.in);
        while (true) {
            System.out.println("Choose a Flight by a number:");
            for (Integer i = 0; i < flights.size(); i++) {
                System.out.println();
                System.out.println("\t" + (i + 1) + ") " + flights.get(i).displayCompact());
            }
            input = myObj.nextLine();
            input_int = Integer.parseInt(input);
            if (input_int >= 1 && input_int <= flights.size()) {
                return flights.get(input_int - 1);
            }
        }
    }

    public FlightDate chooseAFlightDate(List<FlightDate> flightDates) {
        Integer input_int;
        String input;
        Scanner myObj = new Scanner(System.in);
        if (!flightDates.isEmpty()) System.out.println(flightDates.get(0).getFly().displayCompact());
        while (true) {
            System.out.println("Choose a date by a number:");
            for (Integer i = 0; i < flightDates.size(); i++) {
                System.out.println();
                System.out.println("\t" + (i + 1) + ") " + flightDates.get(i).displayCompact());
            }
            input = myObj.nextLine();
            input_int = Integer.parseInt(input);
            if (input_int >= 1 && input_int <= flightDates.size()) {
                return flightDates.get(input_int - 1);
            }
        }
    }

    public List<Location> chooseADepartureLocation(List<Location> locations, Integer nbLocation) {
        String input;
        Integer input_int;
        Integer curLocation = 0;
        Scanner myObj = new Scanner(System.in);
        List<Location> locations_res = new ArrayList<>();
        List<Integer> alreadySelected = new ArrayList<>();
        boolean running = true;
        while (running) {
            if (curLocation == 1) System.out.println("Choose an arrival location by a number:");
            if (curLocation == 0) System.out.println("Choose a departure location by a number:");
            for (Integer i = 0; i < locations.size(); i++) {
                System.out.println();
                System.out.println("\t" + (i + 1) + ") " + locations.get(i).displayCompact());
            }
            input = myObj.nextLine();
            input_int = Integer.parseInt(input);
            if (input_int >= 1 && input_int <= locations.size()) {
                locations_res.add(locations.get(input_int - 1));
                alreadySelected.add(input_int - 1);
                curLocation++;
            } else System.out.println("Bad arguments, try again");
            if (nbLocation == curLocation) running = false;
        }
        return locations_res;
    }

    public Flight writeFlight(List<Location> locations) {
        Location from = null;
        Location to = null;
        Integer from_index = -1;
        String input;
        Integer input_int;
        Scanner myObj = new Scanner(System.in);
        System.out.println("Add a new Flight on data base :");
        List<Location> loc = chooseADepartureLocation(locations, 2);
        return new Flight(loc.get(0), loc.get(1));
    }

    public FlightDate writeFlightDate(List<Flight> flights) {
        Integer year, month, day, hour, minutes, nbTickets, nbFirstTickets, nbReducedTickets, input_int = 0;
        Flight flight = null;
        LocalDateTime date = null;
        Double price, input_double = 0.0;
        String input;
        Scanner myObj = new Scanner(System.in);
        System.out.println("Add a new Date for a Flight on data base :");
        flight = chooseAFlight(flights);
        System.out.println("Choose a Date for the departure : ");
        System.out.println("Choose the Year : ");
        input = myObj.nextLine();
        year = Integer.parseInt(input);
        System.out.println("Choose the Month : ");
        input = myObj.nextLine();
        month = Integer.parseInt(input);
        System.out.println("Choose the Day : ");
        input = myObj.nextLine();
        day = Integer.parseInt(input);
        System.out.println("Choose the Hour : ");
        input = myObj.nextLine();
        hour = Integer.parseInt(input);
        System.out.println("Choose the Minute : ");
        input = myObj.nextLine();
        minutes = Integer.parseInt(input);
        date = LocalDateTime.of(year, month, day, hour, minutes, 0);

        System.out.println("Enter a Price for 1 regular tickets \"x.x\" : ");
        input = myObj.nextLine();
        input_double = Double.parseDouble(input);
        price = input_double;

        System.out.println("Enter the total number of tickets : ");
        input = myObj.nextLine();
        input_int = Integer.parseInt(input);
        nbTickets = input_int;

        System.out.println("Enter the number of First tickets : ");
        input = myObj.nextLine();
        input_int = Integer.parseInt(input);
        nbFirstTickets = input_int;

        System.out.println("Enter the number of Reduced tickets : ");
        input = myObj.nextLine();
        input_int = Integer.parseInt(input);
        nbReducedTickets = input_int;

        return new FlightDate(flight, new Date(date), nbTickets, nbFirstTickets, nbReducedTickets, price);
    }

    public void writeTicket() {
    }

    public Location writePlace() {
        String city, country;
        Scanner myObj = new Scanner(System.in);
        System.out.println("Add a new Place into data base :");
        System.out.println("Choose the city name : ");
        city = myObj.nextLine();
        System.out.println("Choose the country name : ");
        country = myObj.nextLine();
        return new Location(city, country);
    }

    public void writeReservation() {
    }

    public void writeService() {
    }

    public void writeServicePlace() {
    }

    public void writeServiceDatePlace() {
    }

    public void AlreadyExist() {
        System.out.println("Sorry, this data already exist. Try again");
    }

    public void displayFlightReservation() {
        System.out.println("This is if you want to purchase a flight and you just know where it leave");
    }

    public void displayFlightDateSelection() {
        System.out.println("Select a date for the departure");
    }

    public void displayFlightSelection() {
        System.out.println("Select a flight for this departure location");
    }

    public void displayTicketType() {
        System.out.println("Select a reduction for your ticket");
    }

    public Integer chooseTicketType(Double ticketPrice, Integer nbTickets, Integer nbReducedTickets, Integer nbFirstTickets) {
        Scanner myObj = new Scanner(System.in);
        boolean find = true;
        Integer res = -1;
        while (find) {
            System.out.println("Select the kind of ticket you want :");
            System.out.println("Total ticket : " + nbTickets);
            System.out.println("1) Reduced ticket : " + nbTickets + ", " + (ticketPrice - (ticketPrice * 20 / 100)) + "€");
            System.out.println("2) Regular ticket : " + nbTickets + ", " + ticketPrice + "€");
            System.out.println("3) First class ticket : " + nbTickets + ", " + (ticketPrice + (ticketPrice * 30 / 100)) + "€");
            res = Integer.parseInt(myObj.nextLine());
            if (res == 1) return -20;
            if (res == 2) return 0;
            if (res == 3) return 30;
        }
        return -1;
    }

    public void displayNbTicket() {
        System.out.println("Select how many sit you want take");
    }

    public Integer chooseNbTickets(int i, Integer nbTickets) {
        Scanner myObj = new Scanner(System.in);
        boolean find = true;
        Integer res = -1;
        while (find) {
            if (i == 0) System.out.println("Regular ticket remains : " + nbTickets);
            if (i == 1) System.out.println("Reduced ticket remains : " + nbTickets);
            if (i == 2) System.out.println("First class ticket remains : " + nbTickets);
            res = Integer.parseInt(myObj.nextLine());
            if (res > 0 && res <= nbTickets) return res;
        }
        return -1;
    }

    public void displayTicket(FlightTicket flightTicket) {
        System.out.println("Your ticket :");
        System.out.println(flightTicket.displayRead());
    }

    public void displayNewTicket() {
        System.out.println("Want to Add a new travel? :");
    }

    public boolean chooseYesNo() {
        Scanner myObj = new Scanner(System.in);
        boolean find = true;
        Integer res = -1;
        while (find) {
            System.out.println("1) Yes");
            System.out.println("2) No");
            try {
                res = Integer.parseInt(myObj.nextLine());
            } catch (NumberFormatException e) {

            }
            if (res == 1) return true;
            if (res == 2) return false;
        }
        return false;
    }

    public void displayValidate() {
        System.out.println("Want to validate your reservation ? :");
    }

    public void displayAddBasket() {
        System.out.println("Want to add the ticket to your basket ? :");
    }

    public void displayReservationValidation(Reservation reservation) {
        System.out.println("Great, your command is send to our service.");
        reservation.displayValidate();
        System.out.println("We will send you buy's information for finalised the operation");
    }

    public void reset() {
        menuIndice = MenuIndice.HOME;
    }
}

