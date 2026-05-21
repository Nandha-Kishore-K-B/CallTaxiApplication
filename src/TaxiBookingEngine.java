import java.util.ArrayList;
import java.util.List;
public class TaxiBookingEngine {
    private final List<Taxi> taxis;

    public TaxiBookingEngine(int NoOfTaxis) {
        taxis = new ArrayList<>();
        for (int i = 1; i <= NoOfTaxis; i++) {
            taxis.add(new Taxi(i));
        }
    }
    public void bookTaxi(int customerId, Location pickUp, Location drop, int pickUpTime) {
        if(pickUp==drop){
            System.out.println("PickUp and drop can't be the same");
            return;
        }
        List<Taxi> availableTaxis = new ArrayList<>();
        for (Taxi taxi : taxis) {
            if(taxi.getFreeTime() <= pickUpTime){
                availableTaxis.add(taxi);
            }
        }
        if(availableTaxis.isEmpty()){
            System.out.println("Taxi not found");
            return;
        }
        availableTaxis.sort((t1,t2) -> {
            int dist1 = t1.getCurrentLocation().distanceTo(pickUp);
            int dist2 = t2.getCurrentLocation().distanceTo(pickUp);
            if(dist1!=dist2){
                return Integer.compare(dist1,dist2);
            }
            return Double.compare(t1.getTotalEarnings(),t2.getTotalEarnings());
        });
        Taxi allocatedTaxi = availableTaxis.getFirst();

        int distance = pickUp.distanceTo(drop);
        double fare = calculateFare(distance);
        int dropTime = pickUpTime + pickUp.hoursTo(drop);

        Booking newBooking = new Booking(customerId, pickUp, drop, pickUpTime, dropTime, fare);
        allocatedTaxi.assignTrip(newBooking,drop,dropTime,fare);
        System.out.println("Taxi " + allocatedTaxi.getId() + " is allocated for Customer " + customerId);
    }
    private double calculateFare(int distance) {
        if (distance <= 5) {
            return 100.0;
        }
        return 100.0 + ((distance - 5) * 10.0);
    }
    public void displayAllTaxiDetails() {
        for (Taxi taxi : taxis) {
            taxi.printTaxiDetails();
        }
    }
}
