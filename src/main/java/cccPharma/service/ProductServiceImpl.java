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
    private CategoryRepository categoryRepository;
    @Autowired
    private DiscountRepository discountRepository;
    
    
    public Product getProduct(int id) {
        return productRepository.findById((long)id).get();
    }

    private Product updateOrCreate(Product product) {
    	
    	for(Discount d : discountRepository.findAll()) {
    		if(d.equals(product.getCategory().getDiscount())) {
    			product.getCategory().setDiscount(d);
    		}
    	}
    	
    	for(Category a : categoryRepository.findAll()) {
    		if(a.equals(product.getCategory())) {
    			product.setCategoryId(a);
    		}
    	}
    	return product;
    }
    
    public Product createProduct(Product product) {
    	return productRepository.save(updateOrCreate(product));
    }

    public Product updateProduct(Product product) {
    	return productRepository.save(updateOrCreate(product));
    }

    public List<Product> getAllProducts() {
        return (List<Product>) productRepository.findAll();
    }

}
