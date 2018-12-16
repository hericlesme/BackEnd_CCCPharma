package cccPharma.service;

import cccPharma.model.Purchase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cccPharma.dao.PurchaseRepository;
import java.util.List;

@Service
public class PurchaseServiceImpl implements PurchaseService {

    @Autowired
	private PurchaseRepository purchaseRepository;
    
    public Purchase getPurchase(int id) {
        return purchaseRepository.findById((long)id).get();
    }
    
    public Purchase createPurchase(Purchase purchase) {
    	return purchaseRepository.save(purchase);
    }

    public Purchase updatePurchase(Purchase purchase) {
    	return purchaseRepository.save(purchase);
    }

    public List<Purchase> getAllPurchases() {
        return (List<Purchase>) purchaseRepository.findAll();
    }

}
