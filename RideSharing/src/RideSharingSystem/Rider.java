package RideSharingSystem;

import java.util.ArrayList;
import java.util.List;

public class Rider {
    List<Notification> rideNotifications;

    public Rider() {
        rideNotifications = new ArrayList<>();
        BroadcastSystem.getInstance().subscribe(this);
    }

    public void addNotification(Notification rideNotification){
        rideNotifications.add(rideNotification);
    }

    public List<Notification> getRides() {
        return rideNotifications;
    }

    public void acceptRide(Notification notification){
        notification.getRide().startRide(this);
    }

    public void removeNotification(Notification notification){
        rideNotifications.remove(notification);
    }
}
