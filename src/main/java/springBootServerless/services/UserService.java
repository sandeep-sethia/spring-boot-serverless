package springBootServerless.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springBootServerless.dto.UserDto;
import springBootServerless.entities.UserEntity;
import springBootServerless.repositories.UserRepository;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<UserEntity> getAllUsers() {
        List<UserEntity> users = new ArrayList<>();
        userRepository.findAll().forEach(user -> users.add(user));
        System.out.println("total users = " +users.size());
        return users;
    }

    public void saveUser(UserDto userDto) {
        UserEntity entity = UserEntity.builder()
                .org_id(1)
                .name(userDto.getName())
                .email(userDto.getEmail())
                .created_at(Instant.now())
                .build();
        userRepository.save(entity);
    }
}
