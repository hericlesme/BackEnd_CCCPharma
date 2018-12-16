package cccPharma.rest;

import cccPharma.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import cccPharma.service.ProductService;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/products")
@CrossOrigin
public class ProductREST {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity <Object> getProduct(@PathVariable("id") int id){
        try {
            Product product = productService.getProduct(id);
            return new ResponseEntity<Object>(product, HttpStatus.OK);

        } catch (EntityNotFoundException e){
            return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity <Object> createProduct(@RequestBody Product product){
        try {
            Product createdProduct = productService.createProduct(product);
            return new ResponseEntity<Object>(createdProduct, HttpStatus.CREATED);

        } catch (Exception e){
            return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity <Object> updateProduct(@RequestBody Product product){
        try {
            Product createdProduct = productService.updateProduct(product);
            return new ResponseEntity<Object>(createdProduct, HttpStatus.OK);

        } catch (Exception e){
            return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Object> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return new ResponseEntity<Object>(products, HttpStatus.OK);
    }

}
