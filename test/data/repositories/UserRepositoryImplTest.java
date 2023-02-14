package data.repositories;

import data.models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class UserRepositoryImplTest {
    private UserRepository userRepository;
    private User user;

    @BeforeEach public void setUp() {
        userRepository = new UserRepositoryImpl();
        user = new User();
        user.setFirstName("Folahan");
        user.setLastName("Omisakin");
        user.setUsername("9KICKS");
        user.setPassword("SHOP9KICKS");
    }

    @Test public void saveOneUser_CountIsOneTest() {
        userRepository.save(user);
        assertEquals(1, userRepository.count());
    }

    @Test public void saveOneUser_IdOfUserIsOneTest() {
        User savedUser = userRepository.save(user);
        assertEquals(1, savedUser.getId());
    }

    @DisplayName("Update User test")
    @Test public void saveTwoUsersWithSameId_CountIsOneTest() {
        User savedUser = userRepository.save(user);
        assertEquals(1, userRepository.count());
        savedUser.setLastName("Omisakin");
        userRepository.save(savedUser);
        assertEquals(1, userRepository.count());
    }

    @Test public void saveOneUser_FindUserByIdTest() {
        User savedUser = userRepository.save(user);
        assertEquals(1, savedUser.getId());
        User foundUser = userRepository.findById(1);
        assertEquals(foundUser, savedUser);
    }

    @Test public void saveOneUser_DeleteOneUser_CountIsZeroTest() {
        userRepository.save(user);
        assertEquals(1, userRepository.count());
        userRepository.deleteById(1);
        assertEquals(0, userRepository.count());
    }
}