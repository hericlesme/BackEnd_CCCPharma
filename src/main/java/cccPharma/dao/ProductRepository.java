package cccPharma.dao;

import java.util.List;
import cccPharma.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {

    List<Product> findByName(String name);
}