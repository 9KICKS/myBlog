package utils;

import data.models.User;
import dtos.requests.RegisterRequest;
import dtos.responses.FindUserResponse;

import java.time.format.DateTimeFormatter;

public class Mapper {

    public static User map(RegisterRequest registerRequest) {
        User user = new User();
        user.setUsername(registerRequest.getUsername());
        user.setPassword(registerRequest.getPassword());
        user.setFirstName(registerRequest.getFirstName());
        user.setLastName(registerRequest.getLastName());
        return user;
    }

    public static void map(RegisterRequest registerRequest, User user) {
        user.setUsername(registerRequest.getUsername());
        user.setPassword(registerRequest.getPassword());
        user.setFirstName(registerRequest.getFirstName());
        user.setLastName(registerRequest.getLastName());
    }

    public static void map(User foundUser, FindUserResponse response) {
        response.setFullName(foundUser.getFirstName() + " " + foundUser.getLastName());
        response.setUserId(foundUser.getId());
        response.setUsername(foundUser.getUsername());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("E, dd/MM/yyyy, hh:mm a");
        response.setDateRegistered(formatter.format(foundUser.getDateRegistered()));
    }
}
