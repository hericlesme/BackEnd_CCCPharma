package cccPharma.service;

import cccPharma.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cccPharma.dao.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
    public User getUser(int id) {
    	return userRepository.findById((long)id).get();
    }

    public User getUserName(String login) {
    	return userRepository.findByLogin(login).get(0);
    }

    public User createUser(User user) {
    	if(userRepository.findByLogin(user.getLogin()).isEmpty()) {
    		return userRepository.save(user);
    	}else {
    		throw new UnsupportedOperationException("Já existe o login.");
    	}
    }
    
    public User updateUser(User user) {
    	if(userRepository.findById(user.getId()).isPresent()){
    		return userRepository.save(user);
    	}else {
    		throw new UnsupportedOperationException("Usuario nao encontrado.");
    	}
    }

}
