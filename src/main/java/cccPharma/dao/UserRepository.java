package cccPharma.dao;

import java.util.List;

import cccPharma.model.ClientUser;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<ClientUser, Long> {

    List<ClientUser> findByLogin(String login);
}