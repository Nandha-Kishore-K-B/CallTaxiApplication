import java.util.List;
import java.util.ArrayList;
public class Taxi {
    private final int id;
    private Location currentLocation;
    private int freeTime;
    private double totalEarnings;
    private final List<Booking> tripHistory;

    public Taxi(int id) {
        this.id = id;
        this.currentLocation = Location.A; // All taxis start at point A
        this.freeTime = 0;
        this.totalEarnings = 0.0;
        this.tripHistory = new ArrayList<>();
    }
    public int getId() { return id; }
    public Location getCurrentLocation() { return currentLocation; }
    public int getFreeTime() { return freeTime; }
    public double getTotalEarnings() { return totalEarnings; }

    public void assignTrip(Booking booking, Location newLocation, int newFreeTime, double fare) {
        this.tripHistory.add(booking);
        this.currentLocation = newLocation;
        this.freeTime = newFreeTime;
        this.totalEarnings += fare;
    }
    public void printTaxiDetails() {
        System.out.println("\nTaxi ID: " + id + " | Total Earnings: Rs. " + totalEarnings);
        if (tripHistory.isEmpty()) {
            System.out.println("No trips completed yet.");
            return;
        }
        System.out.printf("%-12s %-12s %-10s %-10s %-12s %-12s %-10s\n",
                "BookingID", "CustomerID", "From", "To", "PickupTime", "DropTime", "Amount");
        for (Booking b : tripHistory) {
            b.printDetails();
        }
    }
}
