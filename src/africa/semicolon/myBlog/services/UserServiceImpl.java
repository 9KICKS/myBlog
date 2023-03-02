package africa.semicolon.myBlog.services;

import africa.semicolon.myBlog.data.models.User;
import africa.semicolon.myBlog.data.repositories.UserRepository;
import africa.semicolon.myBlog.data.repositories.UserRepositoryImpl;
import africa.semicolon.myBlog.dtos.requests.RegisterRequest;
import africa.semicolon.myBlog.dtos.responses.FindUserResponse;
import africa.semicolon.myBlog.utils.Mapper;

public class UserServiceImpl implements UserService {
    private static UserRepository userRepository = new UserRepositoryImpl();

    @Override
    public User register(RegisterRequest registerRequest) {
        if (userExist(registerRequest.getUsername())) throw new IllegalArgumentException(registerRequest.getUsername() + "already exist");
        return userRepository.save(Mapper.map(registerRequest));
        //User user = new User();
        //Mapper.map(registerRequest, user);
        //return userRepository.save(user);
    }

    private boolean userExist(String userName) {
        User found = userRepository.findByUserName(userName);
        if (found != null) return true;
        return false;
    }

    @Override
    public FindUserResponse findUser(int id) {
        User foundUser = userRepository.findById(id);
        if (foundUser == null) throw new NullPointerException("User does not exist");
        FindUserResponse response = new FindUserResponse();
        Mapper.map(foundUser, response);
        return response;
    }

    @Override
    public void delete(User user) {
        userRepository.delete(user);
    }

    @Override
    public void delete(int id) {
    }
}