

public class Booking {
    private static int idGenerator = 1;
    private final int bookingId;
    private final int customerId;
    private final Location pickUp;
    private final Location drop;
    private final int pickUpTime;
    private final int dropTime;
    private final double fare;

    public Booking(int customerId, Location pickUp, Location drop, int pickUpTime, int dropTime, double fare) {
        this.bookingId = idGenerator++;
        this.customerId = customerId;
        this.pickUp = pickUp;
        this.drop = drop;
        this.pickUpTime = pickUpTime;
        this.dropTime = dropTime;
        this.fare = fare;
    }
    public void printDetails() {
        System.out.printf("%-12d %-12d %-10s %-10s %-12d %-12d Rs. %-10.2f\n",
                bookingId, customerId, pickUp, drop, pickUpTime, dropTime, fare);
    }
}
