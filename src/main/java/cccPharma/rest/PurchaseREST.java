package cccPharma.rest;

import cccPharma.model.Product;
import cccPharma.model.Purchase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import cccPharma.service.PurchaseService;

import java.util.List;

import javax.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/purchase")
@CrossOrigin
public class PurchaseREST {

    @Autowired
    private PurchaseService purchaseService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity <Object> createUser(@RequestBody Purchase purchase){
        try {
            Purchase createdPurchase = purchaseService.createPurchase(purchase);
            return new ResponseEntity<Object>(createdPurchase, HttpStatus.CREATED);

        } catch (Exception e){
            return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Object> getAllProducts() {
        List<Purchase> purchases = purchaseService.getAllPurchases();
        return new ResponseEntity<Object>(purchases, HttpStatus.OK);
    }
}
