package cccPharma.rest;

import cccPharma.model.User;
import cccPharma.model.UserLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import cccPharma.service.UserService;

import javax.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/users")
@CrossOrigin
public class UserREST {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity <Object> getProduct(@RequestBody UserLogin userLogin){
        try {
            User user = userService.getUserName(userLogin.getLogin());
            if (user.getPassword().equals(userLogin.getPassword())) {
            	return new ResponseEntity<Object>("Usuario logado com sucesso!", HttpStatus.OK);
            }else {
            	return new ResponseEntity<Object>("Senha errada!", HttpStatus.BAD_REQUEST);
            }

        } catch (EntityNotFoundException e){
            return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity <Object> createUser(@RequestBody User user){
        try {
            User createdUser = userService.createUser(user);
            return new ResponseEntity<Object>(createdUser, HttpStatus.CREATED);

        } catch (Exception e){ 
            return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity <Object> updateProduct(@RequestBody User user){
        try {
            User createdUser = userService.updateUser(user);
            return new ResponseEntity<Object>(createdUser, HttpStatus.OK);

        } catch (Exception e){
            return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
