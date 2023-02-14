package services;

import data.models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceImplTest {

    private UserService userService;

    @BeforeEach
    public void setUp() {
        userService = new UserServiceImpl();
    }

    @Test public void test_saveNewUser_IdIsNotZero() {
        User savedUser = userService.register("Folahan", "Omisakin", "9KICKS", "2001");
        assertTrue(savedUser.getId()!=0);
    }

    @Test public void test_duplicateUserNameThrowsException() {
        userService.register("Folahan", "Omisakin", "9KICKS", "2001");
        userService.register("Folahan", "Omisakin", "9KICKS.", "2001");
        assertThrows(IllegalArgumentException.class, ()-> userService.register("Folahan", "Omisakin", "9KICKS.", "2001"));
    }

    @Test public void test_findUserById() {
        userService.register("Folahan", "Omisakin", "9KICKS.", "2001");
        assertEquals("Folahan", userService.findUser(1).getFirstName());
    }

    @Test public void test_throwsExceptionWhenUserIdIsWrong() {
        userService.register("Folahan", "Omisakin", "9KICKS", "2001");
     //   assertThrows(IllegalArgumentException.class, ()-> userService.findUser(1).getId()"Folahan", "Omisakin", "9KICKS", "2001"));
    }
}