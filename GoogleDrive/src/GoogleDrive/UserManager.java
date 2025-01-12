package GoogleDrive;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class UserManager {

    private static UserManager userManager;
    Map<String, User> userMap = new ConcurrentHashMap<>();

    public static UserManager getInstance() {
        if (userManager == null) userManager = new UserManager();
        return userManager;
    }

    public User getUserByName(String username) {
        return userMap.get(username);
    }

    public void addNewUser(User user) {
        this.userMap.put(user.getUsername(), user);
    }

}

