package ru.bgpu.demoorder.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.bgpu.demoorder.models.User;

@Repository
public interface UserRepository  extends CrudRepository<User, Long> {

    public User findOneByLogin(String login);
}
