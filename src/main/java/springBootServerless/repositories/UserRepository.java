package springBootServerless.repositories;


import org.springframework.data.repository.CrudRepository;
import springBootServerless.entities.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, Long> {
    UserEntity findByEmail(String email);
}
