package cccPharma.service;

import cccPharma.model.Product;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    public Product getProduct(int id) {
        return new Product("Testget", 3.50, "/assets/pasta", "Melhor pasta de dente", 0L, LocalDate.now(), 0);
    }

    public Product createProduct(Product product) {
        return new Product("Testget", 3.50, "/assets/pasta", "Melhor pasta de dente", 0L, LocalDate.now(), 0);
    }


    public Product updateProduct(Product product) {
        return new Product("Testget", 3.50, "/assets/pasta", "Melhor pasta de dente", 0L, LocalDate.now(), 0);
    }

    public List<Product> getAllProducts() {
        return new ArrayList<>();
    }

}
