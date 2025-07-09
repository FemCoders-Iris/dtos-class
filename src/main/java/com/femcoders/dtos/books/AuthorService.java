package com.femcoders.dtos.books;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthorService {
    AuthorRepository AUTHOR_REPOSITORY;

    public AuthorService(AuthorRepository authorRepository){
    this.AUTHOR_REPOSITORY = authorRepository;}
    
    public Optional<Author> findByName(String name){
        return this.AUTHOR_REPOSITORY.findByName(name);
//                .orElseThrow(() -> new IllegalArgumentException(String.format("Author with name %s not found", name)));
    }

    public Author saveAuthor(Author author){
        return this.AUTHOR_REPOSITORY.save(author);
    }
}
