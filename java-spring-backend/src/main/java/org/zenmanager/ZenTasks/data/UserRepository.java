package org.zenmanager.ZenTasks.data;


import org.springframework.data.repository.CrudRepository;
import org.zenmanager.ZenTasks.models.User;

public interface UserRepository extends CrudRepository<User, Integer> {

    User findByUsername(String username);

}
