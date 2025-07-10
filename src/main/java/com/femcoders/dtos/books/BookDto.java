package com.femcoders.dtos.books;

import lombok.Builder;

import java.util.List;

@Builder
public record BookDto(
        String title,
        List<String> authorNames
) {
}
