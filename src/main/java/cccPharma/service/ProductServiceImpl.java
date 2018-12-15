package cccPharma.service;

import cccPharma.model.Product;
import cccPharma.model.Category;
import cccPharma.model.Discount;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cccPharma.dao.ProductRepository;
import cccPharma.dao.CategoryRepository;
import cccPharma.dao.DiscountRepository;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
	private ProductRepository productRepository;

    @Autowired
    private CategoryService categoryService;
    
    public Product getProduct(int id) {
        return productRepository.findById((long)id).get();
    }
    
    public Product createProduct(Product product) {
        categoryService.SaveOrUpdate(product.getCategory());
    	return productRepository.save(product);
    }

    public Product updateProduct(Product product) {
        categoryService.SaveOrUpdate(product.getCategory());
        return productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        return (List<Product>) productRepository.findAll();
    }

}
