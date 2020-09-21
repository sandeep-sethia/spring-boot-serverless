package springBootServerless.repositories;

import org.springframework.data.repository.CrudRepository;
import springBootServerless.entities.UserEntity;
import java.util.List;

public interface UserRepository extends CrudRepository<UserEntity, Long> {
    List<UserEntity> findByEmail(String email);


}
