package cccPharma.dao;

import java.util.List;
import cccPharma.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findByLogin(String login);
}