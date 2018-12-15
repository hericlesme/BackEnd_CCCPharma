package cccPharma.service;

import cccPharma.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    public Product getProduct(int id) {
        return new Product("testeGet");
    }

    public Product createProduct(Product product) {
        return new Product("testePost");
    }


    public Product updateProduct(Product product) {
        return new Product("testeUpdate");
    }

    public List<Product> getAllProducts() {
        return new ArrayList<>();
    }

}
