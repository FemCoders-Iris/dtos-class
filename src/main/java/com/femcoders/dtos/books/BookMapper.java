package com.femcoders.dtos.books;

import java.util.List;

public class BookMapper {
    public static Book toEntity(BookDto bookDto, List<Author> authors){
        return Book.builder()
                .title(bookDto.title())
                .authors(authors)
                .build();
    }

    public  static BookDto toDto(Book book){
        return BookDto.builder()
                .title(book.getTitle())
                .authorNames(book.authors
                        .stream()
                        .map(Author::getName)
                        .toList())
                .build();
    }
}
