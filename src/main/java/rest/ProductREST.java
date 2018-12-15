package rest;

import model.Product;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductREST {

    @RequestMapping(value = "/product", method = RequestMethod.GET)
    public Product getProduct(){
        // Ainda não está convertendo direito pra JSON
        return new Product("Pasta", 3.50, "/assets/pasta", "Melhor pasta de dente", 0L);
    }
}
