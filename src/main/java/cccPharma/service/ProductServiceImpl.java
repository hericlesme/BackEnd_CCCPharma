package cccPharma.service;

import cccPharma.model.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cccPharma.dao.ProductRepository;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ProductServiceImpl implements ProductService {

    private String GET_ERROR_MENSAGE = "Produto procurado não existe.";
    private String OUT_OF_STOCK_ERROR_MESSAGE = "Produto fora de stock.";

    @Autowired
	private ProductRepository productRepository;

    @Autowired
    private CategoryService categoryService;
    
    public Product getProduct(long id) throws EntityNotFoundException{
        try {
            return productRepository.findById(id).get();

        } catch (NoSuchElementException e){
            throw new EntityExistsException(GET_ERROR_MENSAGE);
        }
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

    @Override
    public Product purchaseProduct(Product product, int quantity) throws EntityNotFoundException {
        Product purchasedProduct = this.getProduct(product.getId());
        this.validateProductPurchase(purchasedProduct, quantity);
        int productStock = purchasedProduct.getStock();

        productStock -= quantity;
        purchasedProduct.setStock(productStock);
        return this.updateProduct(purchasedProduct);
    }

    private void validateProductPurchase(Product purchasedProduct, int quantity) throws InvalidParameterException {
        if (purchasedProduct.getStock() < quantity){
            throw new InvalidParameterException(OUT_OF_STOCK_ERROR_MESSAGE);
        }
    }
    
    public List<String> getAllProductsDescriptions(){
    	List<String> ret = new ArrayList<String>();
    	for(Product p : getAllProducts()) {
    		ret.add(p.toString());
    	}
    	return ret;
    }
}
