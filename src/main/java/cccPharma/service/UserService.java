package cccPharma.service;

import cccPharma.model.ClientUser;

public interface UserService {

    ClientUser getUser(int id);

    ClientUser getUserName(String login);

    ClientUser createUser(ClientUser clientUser);
    
    ClientUser updateUser(ClientUser clientUser);

}
