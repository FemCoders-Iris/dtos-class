package com.femcoders.dtos.books;

import org.springframework.stereotype.Service;

@Service
public class AuthorService {
    AuthorRepository AUTHOR_REPOSITORY;

    public AuthorService(AuthorRepository authorRepository){
    this.AUTHOR_REPOSITORY = authorRepository;}
}
