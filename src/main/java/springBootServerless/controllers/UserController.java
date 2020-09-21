package springBootServerless.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import springBootServerless.dto.UserDto;
import springBootServerless.entities.UserEntity;
import springBootServerless.services.UserService;

import java.util.List;

@RestController()
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping()
    public List<UserEntity> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping(
            consumes = {"application/json"}
    )
    public void provisionNewUser(
            @RequestBody @Validated UserDto userDto
    ) {
        userService.saveUser(userDto);
    }

}
