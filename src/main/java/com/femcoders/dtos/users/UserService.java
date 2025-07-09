package com.femcoders.dtos.users;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    UserRepository USER_REPOSITORY;

    public UserService(UserRepository userRepository){
        this.USER_REPOSITORY = userRepository;
    }

    public User getUserById(Long id){
        return USER_REPOSITORY.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(String.format("User with id %d not found", id)));
    }

    public User saveUser(User user){
        return USER_REPOSITORY.save(user);
    }
}
