package com.femcoders.dtos.users;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    UserService USER_SERVICE;

    public UserController (UserService userService){
        this.USER_SERVICE = userService;
    }

    @PostMapping("")
    public ResponseEntity<User> saveUser(@RequestBody User user){
        return new ResponseEntity<>(USER_SERVICE.saveUser(user), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable Long id){
        return new ResponseEntity<>(USER_SERVICE.getUserById(id), HttpStatus.OK);
    }

}
