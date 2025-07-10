package com.femcoders.dtos.users;

import lombok.Builder;

@Builder
public record UserResponse(
        String name,
        String myEmail
) {
}
