package seminars.third.tdd;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    private List<User> data = new ArrayList<>();

    public void addUser(User user) {
        if (user != null && authenticateUser(user)) {
            data.add(user);
        }
    }

    public boolean findByName(String username) {
        for (User user : data) {
            if (user.getName().equals(username)) {
                return true;
            }
        }
        return false;
    }

    private boolean authenticateUser(User user) {
        return user.getPassword().equals("validPassword");
    }

    public void logoutNonAdminUsers() {
        data.removeIf(user -> !user.isAdmin());
    }
}


