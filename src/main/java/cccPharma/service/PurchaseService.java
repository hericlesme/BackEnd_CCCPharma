package cccPharma.service;

import cccPharma.model.Purchase;

import java.util.List;

public interface PurchaseService {

    Purchase getPurchase(int id);

    Purchase createPurchase(Purchase product);

    Purchase updatePurchase(Purchase product);

    List<Purchase> getAllPurchases();
}
