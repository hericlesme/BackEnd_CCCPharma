package cccPharma.service;

import cccPharma.model.Product;
import cccPharma.model.Category;
import cccPharma.model.Discount;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cccPharma.dao.ProductRepository;
import cccPharma.dao.CategoryRepository;
import cccPharma.dao.DiscountRepository;

import javax.management.InstanceNotFoundException;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.security.InvalidParameterException;
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
    public void purchaseProduct(Product product, int quantify) throws EntityNotFoundException {
        Product purchasedProduct = this.getProduct(product.getId());
        this.validateProductPurchase(purchasedProduct, quantify);
        int productStock = purchasedProduct.getStock();

        productStock -= quantify;
        purchasedProduct.setStock(productStock);
        this.updateProduct(purchasedProduct);
    }

    private void validateProductPurchase(Product purchasedProduct, int quantify) throws InvalidParameterException {
        if (purchasedProduct.getStock() < quantify){
            throw new InvalidParameterException(OUT_OF_STOCK_ERROR_MESSAGE);
        }
    }
}
