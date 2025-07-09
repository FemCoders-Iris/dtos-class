package com.femcoders.dtos.books;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    BookRepository BOOK_REPOSITORY;
    AuthorService AUTHOR_SERVICE;
    
    public BookService(BookRepository bookRepository, AuthorService authorService){
        this.BOOK_REPOSITORY = bookRepository;
        this.AUTHOR_SERVICE = authorService;
    }

    public BookDto getBookById(Long id){
        Book book = BOOK_REPOSITORY.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(String.format("Book with id %d not found", id)));
        return BookMapper.toDto(book);
    }

    public Book saveBook(BookDto bookDto) {
        List<Author> authorList = bookDto.authorNames().stream()
                .map(name -> {
                    Optional<Author> authorOpt = AUTHOR_SERVICE.findByName(name);
                    return authorOpt.orElseGet(() -> {
                        Author newAuthor = new Author();
                        newAuthor.setName(name);
                        return newAuthor;
//                        return AUTHOR_SERVICE.saveAuthor(newAuthor);
                    });
                })
                .toList();

        Book book = BookMapper.toEntity(bookDto, authorList);
        return BOOK_REPOSITORY.save(book);
    }
}
