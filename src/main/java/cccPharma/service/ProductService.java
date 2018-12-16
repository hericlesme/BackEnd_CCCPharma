package cccPharma.service;

import cccPharma.model.Product;

import javax.persistence.EntityNotFoundException;
import java.util.List;

public interface ProductService {

    Product getProduct(long id) throws EntityNotFoundException;

    Product createProduct(Product product);

    Product updateProduct(Product product);

    List<Product> getAllProducts();

    Product purchaseProduct(Product product, int quantify) throws EntityNotFoundException;
}
