package RideSharingSystem;

import java.util.Calendar;
import java.util.Date;

public class Ride {
    User user;
    Rider rider;
    Location startLocation;
    Location endLocation;
    Date startTime;
    Date endTime;
    Double fare;
    Date rideRequestedAt;
    Notification notification;

    public Ride(User user, Location startLocation, Location endLocation) {
        // if startLocation or endLocation is null then error
        this.user = user;
        this.startLocation = startLocation;
        this.endLocation = endLocation;
        this.rideRequestedAt = Calendar.getInstance().getTime();
        this.notification = new Notification(this);
        BroadcastSystem.getInstance().notify(notification);
    }

    void startRide(Rider rider){
        // if already a rider throw error
        this.rider = rider;
        BroadcastSystem.getInstance().expireNotification(notification);
        startTime = Calendar.getInstance().getTime();
    }

    void endRide(){
        endTime = Calendar.getInstance().getTime();
    }

    private Double calculateFare(){
        // todo implement
        return 10d;
    }
}
