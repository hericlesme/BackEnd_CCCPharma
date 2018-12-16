package cccPharma.service;

import cccPharma.model.Purchase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cccPharma.dao.PurchaseRepository;

import javax.management.InstanceNotFoundException;
import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
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
        productService.purchaseProduct(purchase.getProduct(), purchase.getQuantify());
        return purchaseRepository.save(purchase);
    }

    public Purchase updatePurchase(Purchase purchase) {
    	return purchaseRepository.save(purchase);
    }

    public List<Purchase> getAllPurchases() {
        return (List<Purchase>) purchaseRepository.findAll();
    }

}
