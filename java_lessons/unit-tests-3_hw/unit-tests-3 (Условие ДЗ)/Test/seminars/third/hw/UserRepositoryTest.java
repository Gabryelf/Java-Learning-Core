package seminars.third.hw;

import org.junit.jupiter.api.Test;
import seminars.third.tdd.User;
import seminars.third.tdd.UserRepository;

import static org.junit.jupiter.api.Assertions.*;

public class UserRepositoryTest {

    @Test
    public void testLogoutNonAdminUsers() {
        UserRepository userRepository = new UserRepository();

        User adminUser = new User("admin", "adminPassword", true);
        User nonAdminUser = new User("user", "userPassword", false);

        userRepository.addUser(adminUser);
        userRepository.addUser(nonAdminUser);

        assertTrue(userRepository.findByName("admin"));
        assertTrue(userRepository.findByName("user"));

        userRepository.logoutNonAdminUsers();

        assertTrue(userRepository.findByName("admin"));
        assertFalse(userRepository.findByName("user"));
    }
}

