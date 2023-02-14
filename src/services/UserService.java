package services;

import data.models.User;
import dtos.requests.RegisterRequest;
import dtos.responses.FindUserResponse;

public interface UserService { ;

    User register(RegisterRequest request);
    FindUserResponse findUser(int id);
}
