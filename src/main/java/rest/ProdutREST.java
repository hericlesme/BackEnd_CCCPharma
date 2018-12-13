package rest;


import model.Product;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("product")
public class ProdutREST {

    @RequestMapping(method = RequestMethod.GET, path = "/products")
    public Product getProducts() {
        return new Product();
    }

}
