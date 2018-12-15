package cccPharma.service;

import cccPharma.model.User;

public interface UserService {

    User getUser(int id);

    User getUserName(String login);

    User createUser(User user);
    
    User updateUser(User user);

}
