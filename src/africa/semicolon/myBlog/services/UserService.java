package africa.semicolon.myBlog.services;

import africa.semicolon.myBlog.data.models.User;
import africa.semicolon.myBlog.dtos.requests.RegisterRequest;
import africa.semicolon.myBlog.dtos.responses.FindUserResponse;

import java.util.List;

public interface UserService {
    User register(RegisterRequest request);

    FindUserResponse findUser(int id);

    //List<FindUserResponse> findAll();

    void delete(User user);

    void delete(int id);

//  void deleteAll();

//  FindUserResponse findByUsername();

//  User findId(int id);
}