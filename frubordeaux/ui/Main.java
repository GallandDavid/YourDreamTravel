package frubordeaux.ui;

import frubordeaux.domain.value_object.Place;

import java.util.List;

public class Main {

    private Integer menuIndice = 0;

    public void interfaceUtilisateur(){
        clearConsole();
        displayGoodInformation();
        applyGoodAction();

    }

    private void applyGoodAction() {
        //input
        if(input == '2'){
            menuIndice = 2;
        }
    }

    private void displayGoodInformation() {
        if(menuIndice == 0){
            chooseMainAction();
        }else if(menuIndice == 1){

        }else if(menuIndice == 2){

        }
    }

    private void chooseMainAction() {
        System.out.println("1) Reservation");
        System.out.println("2) Data");
        System.out.println("3) Retrieve Reservation");
    }

    public void showPlace(List<Place> places){
        System.out.println("List of place that can be a start/end travel :");
        for(Place place : places){
            System.out.println("\t- " + place.getName() + ", " + place.getCountry());
            System.out.println("\t  " + place.getID());
            System.out.println("\t  " + place.getRepository());
            System.out.println("\t  " + place.getServiceRepository());
            System.out.println();
        }

    }

    public final static void clearConsole()
    {
        try
        {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows"))
            {
                Runtime.getRuntime().exec("cls");
            }
            else
            {
                Runtime.getRuntime().exec("clear");
            }
        }
        catch (final Exception e)
        {
            //  Handle any exceptions.
        }
    }
}
