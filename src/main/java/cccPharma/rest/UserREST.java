package cccPharma.rest;

import cccPharma.model.ClientUser;
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
            ClientUser clientUser = userService.getUserName(userLogin.getLogin());
            if (clientUser.getPassword().equals(userLogin.getPassword())) {
            	return new ResponseEntity<Object>("Usuario logado com sucesso!", HttpStatus.OK);
            }else {
            	return new ResponseEntity<Object>("Senha errada!", HttpStatus.BAD_REQUEST);
            }

        } catch (EntityNotFoundException e){
            return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity <Object> createUser(@RequestBody ClientUser clientUser){
        try {
            ClientUser createdClientUser = userService.createUser(clientUser);
            return new ResponseEntity<Object>(createdClientUser, HttpStatus.CREATED);

        } catch (Exception e){ 
            return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity <Object> updateProduct(@RequestBody ClientUser clientUser){
        try {
            ClientUser createdClientUser = userService.updateUser(clientUser);
            return new ResponseEntity<Object>(createdClientUser, HttpStatus.OK);

        } catch (Exception e){
            return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
