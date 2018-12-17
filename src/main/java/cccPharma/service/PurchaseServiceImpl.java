package cccPharma.service;

import cccPharma.model.Product;
import cccPharma.model.Purchase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cccPharma.dao.PurchaseRepository;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class PurchaseServiceImpl implements PurchaseService {

    @Autowired
	private PurchaseRepository purchaseRepository;

    @Autowired
    private ProductService productService;

    public Purchase getPurchase(int id) {
        return purchaseRepository.findById((long)id).get();
    }

    @Transactional
    public Purchase createPurchase(Purchase purchase) throws EntityNotFoundException {
        Product productAtualizado = productService.purchaseProduct(purchase.getProduct(), purchase.getQuantity());
        purchase = new Purchase(productAtualizado, purchase.getQuantity());
        return purchaseRepository.save(purchase);
    }

    public Purchase updatePurchase(Purchase purchase) {
    	return purchaseRepository.save(purchase);
    }

    public List<Purchase> getAllPurchases() {
        return (List<Purchase>) purchaseRepository.findAll();
    }

    public List<String> getReport() {
    	List<String> ret = new ArrayList<String>();
    	double totalCost = 0;
    	for(Purchase p : purchaseRepository.findAll()) {
    		ret.add(p.toString());
    		totalCost += p.getTotalCost();
    	}
    	ret.add("Receita total: R$" + String.format("%.2f", totalCost));
    	return ret;
    }
}
