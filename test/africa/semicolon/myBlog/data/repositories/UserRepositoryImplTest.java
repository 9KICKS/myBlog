package africa.semicolon.myBlog.data.repositories;

import africa.semicolon.myBlog.data.models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryImplTest {
    private UserRepository userRepository;

    private User user;

    @BeforeEach public void setUp() {
        user = new User();
        user.setFirstName("Felix");
        user.setLastName("Scott");
        user.setUserName("Username");
        user.setPassword("Password");
        userRepository = new UserRepositoryImpl();
    }

    @Test public void saveOneUser_CountIsOneTest() {
        User user = new User();
        userRepository.save(user);
        assertEquals(1, userRepository.count());
    }

    @Test public void saveOneUser_idOfUserIsOneTest() {
        User savedUser = userRepository.save(user);
        assertEquals(1, savedUser.getId());
    }

    @Test public void saveTwoUsersWithSameId_countIsOneTest() {
        User savedUser = userRepository.save(user);
        assertEquals(1, savedUser.getId());
        savedUser.setLastName("Mccall");
        userRepository.save(savedUser);
        assertEquals(1, userRepository.count());
    }

    @Test public void saveOneUser_findUserByIdTest() {
        User savedUser = userRepository.save(user);
        assertEquals(1, savedUser.getId());
        User foundUser = userRepository.findById(1);
        assertEquals(foundUser, savedUser);
    }

    @Test public void saveOneUser_deleteOneUserTest_CountIsZeroTest() {
        User savedUser = userRepository.save(user);
        assertEquals(1, userRepository.count());
        userRepository.delete(1);
        assertEquals(0, userRepository.count());
    }
}