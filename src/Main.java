
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {

    static Scanner scan = new Scanner(System.in);

    static ArrayList<Band> listOfBands = new ArrayList<>();
    static ArrayList<Event> listOfEvents = new ArrayList<>();
    static ArrayList<Contract> listOfContracts = new ArrayList<>();

//==Test running examples for band objects, event objects, and contract objects ======

    static Band iDontSteal = new Band("I Don't Steal", 2, 3000);
    static Band kashmir = new Band("Kashmir", 4, 125000);
    static Band radiohead = new Band("Radiohead", 5, 600000);

    static Event amagerBio = new Event("Rock'n'Amager", "Øresundsvej 6, 2300 Kbh S", "3. august 2020");
    static Event børneteateret = new Event("Songs at heart", "Christiania","23. january 2021");

    static Contract contract = new Contract(kashmir, amagerBio, 125000, 1.5, "They want three bottles of whiskey");

    static void addToLists(){

        listOfBands.add(kashmir);
        listOfBands.add(radiohead);
        listOfBands.add(iDontSteal);

        listOfEvents.add(amagerBio);
        listOfEvents.add(børneteateret);

        listOfContracts.add(contract);
    }

//=====================================================================================



    static void printListOfEvents(){
        for (int i = 0; i < listOfEvents.size(); i++) {
            System.out.println((i + 1) + ". " + listOfEvents.get(i).getEventName());
        }
    }

    static void printListOfBands(){
        for (int i = 0; i < listOfBands.size(); i++) {
            System.out.println((i + 1) + ". " + listOfBands.get(i).getBandName());
        }
    }

    static void printListOfContracts(){
        String bandName = "";
        for (int i = 0; i < listOfContracts.size(); i++) {
            bandName = listOfContracts.get(i).getBand().getBandName();
            System.out.println((i + 1) + ". Contract for " + bandName);

            for (int j = 0; j < listOfEvents.size(); j++) {

                if (bandName.equals(listOfEvents.get(j).getBandFromPlayingBand(i))) {
                    System.out.println(("Playing at the " + listOfEvents.get(j).getEventName()));
                }
            }
        }
    }

    static void viewContractForBand(Band band){
        System.out.println(band.getBandContract());
    }

    static void createBandContract(){

        Contract bandContract;

        System.out.println();
        System.out.println("===================================");
        System.out.println("     B A N D   C O N T R A C T     ");
        System.out.println("===================================");
        System.out.println();

        System.out.println("1)\tCreate Band contract");
        System.out.println("2)\tBack to main menu");
        System.out.println();

        int choice = validateUserIntInput(1, 4);
        switch (choice){

            case 1:
                System.out.println("Insert these informations to create a new Band Contract");

                System.out.println("- What band to create a contract for:");
                printListOfBands();
                int bandName = validateUserIntInput(1, listOfBands.size());
                Band band = listOfBands.get(bandName - 1);

                System.out.println("- What Event are the band playing at:");
                printListOfEvents();
                int eventName = validateUserIntInput(1, listOfBands.size());
                Event event = listOfEvents.get(bandName - 1);

                System.out.println("- What is the settled Band price for this event: ");
                int price = validateUserIntInput(0, 999999999);

                System.out.println("- What is the duration of the concert: ");
                int duration = validateUserIntInput(0, 999999999);

                System.out.println("- What is the bands conditions: ");
                String conditions = scan.next() + scan.nextLine();

                bandContract = new Contract(band, event, price, duration, conditions);
                listOfContracts.add(bandContract);
                break;

            case 2:
                mainMenu();
                break;
        }
    }

    static  void createBand(){
        Band newBand;
        Contract bandContract;

        System.out.println();
        System.out.println("===================================");
        System.out.println("      B A N D   C R E A T O R      ");
        System.out.println("===================================");
        System.out.println();
        System.out.println("1)\tCreate Band");
        System.out.println("2)\tBack to main menu");
        System.out.println();

        int choice = validateUserIntInput(1, 4);
        switch (choice){

            case 1:
                System.out.println("Insert these informations to create a new Band");
                System.out.println("- Band Name: ");
                String bandName = scan.next() + scan.nextLine();
                System.out.println("- Number of bandmembers: ");
                int numOfMembers = validateUserIntInput(1, 100);
                System.out.println("- Band booking price: ");
                int bookingPrice = validateUserIntInput(0, 999999999);
                newBand = new Band(bandName, numOfMembers, bookingPrice);
                listOfBands.add(newBand);
                break;

            case 2:
                mainMenu();
                break;
        }
    }

    static void createEvent(){
        Event newEvent;
        boolean run = true;
        System.out.println();
        System.out.println("===================================");
        System.out.println("     E V E N T   C R E A T O R     ");
        System.out.println("===================================");

        while (run) {
            System.out.println();
            System.out.println("1)\tCreate event");
            System.out.println("2)\tAdd bands to event");
            System.out.println("3)\tBack to main menu");
            System.out.println();

            int choice = validateUserIntInput(1, 4);
            switch (choice) {

                case 1:
                    System.out.println("Insert these informations to create a new Event");
                    System.out.println("- Event Name: ");
                    String eventName = scan.next() + scan.nextLine();
                    System.out.println("- Event location: ");
                    String eventLocation = scan.next() + scan.nextLine();
                    System.out.println("- Event date: ");
                    String eventDate = scan.next() + scan.nextLine();
                    newEvent = new Event(eventName, eventLocation, eventDate);
                    listOfEvents.add(newEvent);
                    System.out.println("===================================");
                    System.out.println("W H A T   N O W ?");
                    break;

                case 2:
                    System.out.println("What event ");
                    printListOfEvents();
                    int event = validateUserIntInput(1, listOfEvents.size());
                    System.out.println("Add bands to " + listOfEvents.get(event - 1).getEventName());
                    printListOfBands();
                    int bandIndex = validateUserIntInput(1, listOfBands.size());
                    Band band = listOfBands.get(bandIndex - 1);
                    listOfEvents.get(event).setPlayingBands(band);
                    System.out.println("===================================");
                    System.out.println("W H A T   N O W ?");
                    break;
                case 3:
                    run = false;
                    break;
            }
        }
        mainMenu();
    }

    static void mainMenu(){
        System.out.println();
        System.out.println("===================================");
        System.out.println("         M A I N   M E N U         ");
        System.out.println("===================================");
        System.out.println();
        System.out.println("1)\tCreate new Event");
        System.out.println("2)\tCreate new band");
        System.out.println("3)\tCreate band contracts");
        System.out.println("4)\tExit");
        System.out.println();

        int choice = validateUserIntInput(1, 4);

        switch (choice){
            case 1:
                createEvent();
                break;
            case 2:
                createBand();
                break;
            case 3:
                createBandContract();
                break;
            case 4:
                System.out.println("Bye bye now!");
                break;
        }
    }

    static int validateUserIntInput(int minValue, int maxValue){
        int returnNum = 0;
        boolean run = true;
        while (run) {
            try {
                returnNum = scan.nextInt();
                if (returnNum >= minValue && returnNum <= maxValue){
                    run = false;
                }
                else {
                    System.out.println("The number has to be between " + (minValue) + " and " + (maxValue));
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! try a number");
                scan.next();
            }
        }
        return returnNum;
    }

    public static void main(String[] args) {

        addToLists();

        mainMenu();

        // for testing==================================
        amagerBio.setPlayingBands(iDontSteal);
        amagerBio.setPlayingBands(kashmir);
        amagerBio.setPlayingBands(radiohead);

        børneteateret.setPlayingBands(radiohead);
        børneteateret.setPlayingBands(kashmir);
        børneteateret.setPlayingBands(iDontSteal);

        System.out.println(amagerBio.toString());
        System.out.println(børneteateret.toString());
        System.out.println("Number of events: " + Event.numberOfEvents);



        printListOfEvents();
        printListOfBands();
        printListOfContracts();

        System.out.println();
        System.out.println(iDontSteal.toString());
        System.out.println(kashmir.toString());
        System.out.println(radiohead.toString());







    }
}
