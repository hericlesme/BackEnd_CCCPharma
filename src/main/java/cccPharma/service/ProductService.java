package cccPharma.service;

import cccPharma.model.Product;

import java.util.List;

public interface ProductService {

    Product getProduct(int id);

    Product createProduct(Product product);

    Product updateProduct(Product product);

    List<Product> getAllProducts();
}
