package frubordeaux.ui;

import frubordeaux.domain.agregate.Reservation;
import frubordeaux.domain.entity.FlightTicket;
import frubordeaux.domain.entity.ServicePlace;
import frubordeaux.domain.value_object.*;

import java.util.List;
import java.util.Scanner;

public class UI {

    private Integer menuIndice;

    public UI(){
        menuIndice = 0;
    }

    public String interfaceUtilisateur(){
        clearConsole();
        displayGoodInformation();
        String result = applyGoodAction();
        if(!result.equals("")) return result;
        return "";
    }

    private String applyGoodAction() {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Make your choice :");
        String input = myObj.nextLine();
        if(menuIndice == 0){
            if(input.equals("1")) {
                menuIndice = 1;
            }else if(input.equals("2")) {
                menuIndice = 2;
            }else if(input.equals("3")) {
                menuIndice = 3;
            }
        }else if(menuIndice == 2){
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
            else if(input.equals("2")) return "w 2";
            else if(input.equals("3")) return "w 3";
            else if(input.equals("4")) return "W 4";
            else if(input.equals("5")) return "W 5";
            else if(input.equals("6")) return "W 6";
            else if(input.equals("7")) return "W 7";
            else if(input.equals("8")) return "W 8 ";
        }
        return "";
    }

    private void displayGoodInformation() {
        if(menuIndice == 0){
            chooseMainAction();
        }else if(menuIndice == 1){

        }else if(menuIndice == 10){

        }else if(menuIndice == 2){
            chooseActionData();
        }else if(menuIndice == 21){
            chooseData();
        }else if(menuIndice == 22){
            chooseData();
        }else if(menuIndice == 3){

        }
    }
    private void chooseData() {
        System.out.println("0) Back ");
        System.out.println("1) Flight ");
        System.out.println("2) Flight Date");
        System.out.println("3) Tickets");
        System.out.println("4) Places");
        System.out.println("5) Reservation");
        System.out.println("6) Service");
        System.out.println("7) Service at Place");
        System.out.println("8) Service Date at Place ");
    }

    private void chooseMainAction() {
        System.out.println("1) Reservation");
        System.out.println("2) Data");
    }

    private void chooseActionData(){
        System.out.println("0) Back ");
        System.out.println("1) Read");
        System.out.println("2) Write");
    }

    //trouver un truc qui marche sur IDE
    public final static void clearConsole() { }

    /*
    * A faire pour assembler les 8 fonction suivante en 1
    *

    public void displayList(List<Displayable> flight) {}

    */

    public void displayListFlight(List<Flight> flight) {
        for(Flight fly : flight){
            System.out.println(fly.displayRead());
        }
    }

    public void displayListPlace(List<Location> locations){
        for(Location location : locations){
            System.out.println(location.displayRead());
        }
    }

    public void displayListFlightDate(List<FlyDate> flightDate) {
        for(FlyDate flyDate : flightDate){
            System.out.println(flyDate.displayRead());
        }
    }

    public void displayListFlightTicket(List<FlightTicket> flightTickets) {
        for(FlightTicket flightTicket : flightTickets){
            System.out.println(flightTicket.displayRead());
        }
    }

    public void displayListReservation(List<Reservation> reservations) {
        for(Reservation reservation : reservations){
            System.out.println(reservation.displayRead());
        }
    }

    public void displayListService(List<Service> services) {
        for(Service service : services){
            System.out.println(service.displayRead());
        }
    }

    public void displayListServicePlace(List<ServicePlace> servicesPlace) {
        for(ServicePlace servicePlace : servicesPlace){
            System.out.println(servicePlace.displayRead());
        }
    }

    public void displayListServicePlaceDate(List<ServicePlaceDate> servicesPlaceDate) {
        for(ServicePlaceDate servicePlaceDate : servicesPlaceDate){
            System.out.println(servicePlaceDate.displayRead());
        }
    }

    public Flight writeFlight(List<Location> locations) {
        Location from = null;
        Location to = null;
        Integer from_index = -1;
        String input;
        Integer imput_int;
        Scanner myObj = new Scanner(System.in);
        System.out.println("Add a new Flight on data base :");
        boolean running = true;
        while(running) {
            System.out.println("Choose a departure location by a number:");
            for (Integer i = 0; i < locations.size(); i++) {
                System.out.println();
                System.out.println("\t" + (i + 1) + ") " + locations.get(i).displayCompact());
            }
            input = myObj.nextLine();
            imput_int = Integer.parseInt(input);
            if (imput_int >= 1 && imput_int <= locations.size()) {
                from = locations.get(imput_int - 1);
                from_index = imput_int - 1;
                running = false;
            }
        }
        running = true;
        while(running) {
            System.out.println("Choose a place of arrival by a number:");
            for (Integer i = 0; i < locations.size(); i++) {
                if(!(from_index == i)) {
                    System.out.println();
                    System.out.println("\t" + (i + 1) + ") " + locations.get(i).displayCompact());
                }
            }
            input = myObj.nextLine();
            imput_int = Integer.parseInt(input);
            if (imput_int >= 1 && imput_int <= locations.size()){
                to = locations.get(imput_int - 1);
                running = false;
            }
        }
        return new Flight(from,to);
    }

    public void writeFlightDate() {
    }

    public void writeTicket() {
    }

    public void writePlace() {
    }

    public void writeReservation() {
    }

    public void writeService() {
    }

    public void writeServicePlace() {
    }

    public void writeServiceDatePlace() {
    }

    public void flightAlreadyExist() {
        System.out.println("Sorry, this flight already exist. Try again");

    }
}
