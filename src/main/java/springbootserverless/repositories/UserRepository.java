package springbootserverless.repositories;


import org.springframework.data.repository.CrudRepository;
import springbootserverless.entities.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, Long> {
    UserEntity findByEmail(String email);
}
