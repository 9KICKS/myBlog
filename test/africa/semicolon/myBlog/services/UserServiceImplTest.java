package africa.semicolon.myBlog.services;

import africa.semicolon.myBlog.data.models.User;
import africa.semicolon.myBlog.dtos.requests.RegisterRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UserServiceImplTest {
    private UserService userService;

    private RegisterRequest request;

    @BeforeEach public void setUp() {
        userService = new UserServiceImpl();
        request = new RegisterRequest();
        request.setLastName("Mccall");
        request.setFirstName("Felix");
        request.setUsername("Din");
        request.setPassword("Password");
    }

    @Test public void test_SaveNewUser_IdIsNotZero() {
        User savedUser = userService.register(request);
        assertTrue(savedUser.getId() != 0);
    }

    @Test public void test_duplicateUserNameThrowsException() {
        userService.register(request);
        assertThrows(IllegalArgumentException.class, ()-> userService.register(request));
    }

    @Test public void test_findUserById() {
        userService.register(request);
        assertEquals("Felix Mccall", userService.findUser(1).getFullName());
    }

    @Test public void test_wrongUserIdThrowsException() {
        userService.register(request);
        assertThrows(NullPointerException.class, ()-> userService.findUser(2));
    }
}