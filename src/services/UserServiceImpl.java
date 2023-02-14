package services;

import data.models.User;
import data.repositories.UserRepository;
import data.repositories.UserRepositoryImpl;
import dtos.requests.RegisterRequest;
import dtos.responses.FindUserResponse;
import utils.Mapper;

import java.time.format.DateTimeFormatter;

public class UserServiceImpl implements  UserService {

    private UserRepository userRepository = new UserRepositoryImpl();

    @Override
    public User register(RegisterRequest registerRequest) {
        if(userExist(registerRequest.getUsername())) throw new IllegalArgumentException(registerRequest.getUsername() + " already exist");
        User user = new User();
        //return userRepository.save(Mapper.map(registerRequest));
        Mapper.map(registerRequest, user);
        return userRepository.save(user);
    }

    private boolean userExist(String username) {
        User foundUser = userRepository.findByUsername(username);
        if(foundUser != null) return true;
        return false;
    }

    @Override
    public FindUserResponse findUser(int id) {
        User foundUser = userRepository.findById(id);
        FindUserResponse response = new FindUserResponse();
        Mapper.map(foundUser, response);
        return response;
    }
}
