package RideSharingSystem;

import java.util.ArrayList;
import java.util.List;

public class BroadcastSystem {

    static BroadcastSystem broadcastSystem;

    static BroadcastSystem getInstance() {
        if (broadcastSystem == null)
            broadcastSystem = new BroadcastSystem();
        return broadcastSystem;
    }

    private BroadcastSystem() {
        this.riders = new ArrayList<>();
    }

    List<Rider> riders;

    void notify(Notification notification) {
        for (var rider :
                riders) {
            rider.addNotification(notification);
        }
    }

    void expireNotification(Notification notification){
        for (var rider :
                riders) {
            rider.removeNotification(notification);
        }
    }

    void subscribe(Rider rider) {
        riders.add(rider);
    }

    void unSubscribe(Rider rider) {
        riders.remove(rider);
    }
}
