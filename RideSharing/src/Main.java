import RideSharingSystem.Location;
import RideSharingSystem.Rider;
import RideSharingSystem.User;

public class Main {
    public static void main(String[] args) {
        User u1 = new User();
        User u2 = new User();

        Rider r1 = new Rider();
        Rider r2 = new Rider();

        u1.requestRide(new Location(), new Location());
        u2.requestRide(new Location(), new Location());

        r1.getRides().stream().map(a->a.getRide()+" ").forEach(System.out::print);
        System.out.println();
        r1.acceptRide(r1.getRides().get(1));

        r2.getRides().stream().map(a->a.getRide()+" ").forEach(System.out::print);
    }
}