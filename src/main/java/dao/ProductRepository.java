package dao;

import java.util.List;
import model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {

    List<Product> findByName(String name);
}