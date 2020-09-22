package springbootserverless.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import springbootserverless.dto.UserDto;
import springbootserverless.entities.UserEntity;
import springbootserverless.services.UserService;

import java.util.List;

@RestController()
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping()
    public List<UserEntity> getAllUsers() {
        System.out.println("request for getting user information");
        return userService.getAllUsers();
    }

    @PostMapping(
            consumes = {"application/json"}
    )
    public void provisionNewUser(
            @RequestBody @Validated UserDto userDto
    ) {
        System.out.println("request for provisioning a new user");
        userService.saveUser(userDto);
    }

    @PatchMapping(
            path = "/{email}"
    )
    public UserEntity updateUserInfo(
            @RequestParam(value = "orgId", required = false) Integer ordId,
            @RequestParam(value = "name", required = false) String name,
            @PathVariable(value = "email", required = true) String email
    ) {
        System.out.println("request for updating user information");
        return userService.updateUserInfo(ordId, name, email);
    }

    @DeleteMapping(
            path = "/{email}"
    )
    public void deleteUser(
            @PathVariable(value = "email", required = true) String email
    ) {
        System.out.println("request for deleting user");
        userService.deleteUser(email);
    }
}
