package dao;

import java.util.List;
import model.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {

    List<Category> findByName(String name);
}