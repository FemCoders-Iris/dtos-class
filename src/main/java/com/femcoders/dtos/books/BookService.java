package com.femcoders.dtos.books;

import org.springframework.stereotype.Service;

@Service
public class BookService {
    BookRepository BOOK_REPOSITORY;
    
    public BookService(BookRepository bookRepository){
        this.BOOK_REPOSITORY = bookRepository;
    }

    public Book getBookById(Long id){
        return BOOK_REPOSITORY.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(String.format("Book with id %d not found", id)));
    }

    public Book saveBook(Book book){
        return BOOK_REPOSITORY.save(book);
    }
}
