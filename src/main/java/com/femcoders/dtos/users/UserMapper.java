package com.femcoders.dtos.users;

public class UserMapper {
    public static UserResponse toDto(User user){
        return UserResponse.builder()
                .name(user.getUsername())
                .myEmail(user.getEmail())
                .build();
    }
}
