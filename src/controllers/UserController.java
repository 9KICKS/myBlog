package controllers;

import dtos.requests.RegisterRequest;
import services.UserService;
import services.UserServiceImpl;

public class UserController {

    private UserService userService = new UserServiceImpl();

    public Object register(RegisterRequest request) {
        try {
            return userService.register(request);
        }
        catch (IllegalArgumentException error) {
            return error.getMessage();
        }
    }

    public Object findUserById(int id) {
        return userService.findUser(id);
    }
}
