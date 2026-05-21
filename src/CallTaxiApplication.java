import java.util.*;
public class CallTaxiApplication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TaxiBookingEngine engine = new TaxiBookingEngine(4);
        while(true) {
            System.out.println("Call Taxi Application: ");
            System.out.println("1. Book Taxi");
            System.out.println("2. Taxi Details");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice;
            try{
                choice = Integer.parseInt(sc.nextLine());
            }catch(NumberFormatException e){
                System.out.println("Please enter a number");
                continue;
            }
            switch(choice) {
                case 1:
                    try{
                        System.out.println("Enter Customer ID: ");
                        int customerId = Integer.parseInt(sc.nextLine());
                        System.out.println("Enter PickUp Point (A,B,C,D,E,F): ");
                        Location pickup = Location.valueOf(sc.nextLine().trim().toUpperCase());
                        System.out.println("Enter Drop point (A,B,C,D,E,F): ");
                        Location drop = Location.valueOf(sc.nextLine().trim().toUpperCase());
                        System.out.println("Enter Pickup Time (in Hrs)");
                        int pickUptime = Integer.parseInt(sc.nextLine());

                        engine.bookTaxi(customerId,pickup,drop,pickUptime);
                    }catch(IllegalArgumentException e){
                        System.out.println("Invalid Input");
                    }
                    break;
                case 2:
                    engine.displayAllTaxiDetails();
                    break;
                case 3:
                    System.out.println("Thank you for using Taxi Application");
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}