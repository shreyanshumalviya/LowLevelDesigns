package RideSharingSystem;

import java.util.List;

public class User {
    public void requestRide(Location start, Location end){
        var ride = new Ride(this, start, end);
    }

    public List<Rider> getNearByRiders(){
        //todo
        return null;
    }
}
