package RideSharingSystem;

public class Notification {
    private final Ride ride;

    public Notification(Ride ride) {
        this.ride = ride;
    }

    public Ride getRide() {
        return ride;
    }

}
