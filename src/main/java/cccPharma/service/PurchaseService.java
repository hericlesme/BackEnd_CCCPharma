package cccPharma.service;

import cccPharma.model.Purchase;

import javax.persistence.EntityNotFoundException;
import java.util.List;

public interface PurchaseService {

    Purchase getPurchase(int id);

    Purchase createPurchase(Purchase product) throws EntityNotFoundException;

    Purchase updatePurchase(Purchase product);

    List<Purchase> getAllPurchases();
   
    List<String> getReport();
}
