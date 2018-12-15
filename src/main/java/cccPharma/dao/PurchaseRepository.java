package cccPharma.dao;

import java.util.List;
import cccPharma.model.Purchase;
import org.springframework.data.repository.CrudRepository;

public interface PurchaseRepository extends CrudRepository<Purchase, Long> {

}