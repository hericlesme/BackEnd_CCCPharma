package cccPharma.service;

import cccPharma.model.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cccPharma.dao.ProductRepository;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	
    public Product getProduct(int id) {
        return productRepository.findById((long)id).get();
    }

    public Product createProduct(Product product) {
    	return productRepository.save(product);
    }


    public Product updateProduct(Product product) {
    	return productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        return (List<Product>) productRepository.findAll();
    }

}
