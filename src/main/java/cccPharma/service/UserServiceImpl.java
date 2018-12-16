package cccPharma.service;

import cccPharma.model.ClientUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cccPharma.dao.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
    public ClientUser getUser(int id) {
    	return userRepository.findById((long)id).get();
    }

    public ClientUser getUserName(String login) {
    	return userRepository.findByLogin(login).get(0);
    }

    public ClientUser createUser(ClientUser clientUser) {
    	if(userRepository.findByLogin(clientUser.getLogin()).isEmpty()) {
    		return userRepository.save(clientUser);
    	}else {
    		throw new UnsupportedOperationException("Já existe o login.");
    	}
    }
    
    public ClientUser updateUser(ClientUser clientUser) {
    	if(userRepository.findById(clientUser.getId()).isPresent()){
    		return userRepository.save(clientUser);
    	}else {
    		throw new UnsupportedOperationException("Usuario nao encontrado.");
    	}
    }

}
