package net.sovliv.jsontestapp.repository;

import net.sovliv.jsontestapp.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

}
