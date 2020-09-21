package springbootserverless.services;

import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import springbootserverless.dto.UserDto;
import springbootserverless.entities.UserEntity;
import springbootserverless.repositories.UserRepository;

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
        System.out.println("total users = " + users.size());
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

    public UserEntity updateUserInfo(Integer ordId, String name, String email) {
        if (Strings.isBlank(name) && null == ordId) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "either org_id or email should be supplied as request param");
        }

        UserEntity entity = userRepository.findByEmail(email);
        if (null == entity) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "no such user exist.");
        }
        if (null != ordId) {
            entity.setOrg_id(ordId);
        }
        if (!Strings.isBlank(name)) {
            entity.setName(name);
        }
        entity.setCreated_at(Instant.now());
        return userRepository.save(entity);
    }

    public void deleteUser(String email) {
        UserEntity entity = userRepository.findByEmail(email);
        if (null == entity) {
            throw new HttpClientErrorException(
                    HttpStatus.BAD_REQUEST,
                    "no such user exist.");
        }
        userRepository.deleteById(Long.valueOf(entity.getUser_id()));
    }
}
