package com.femcoders.dtos.books;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/books")
public class BookController {
    BookService BOOK_SERVICE;

    public BookController (BookService bookService){
        this.BOOK_SERVICE = bookService;
    }

    @PostMapping("")
    public ResponseEntity<Book> saveBook(@RequestBody BookDto bookDto){
        return new ResponseEntity<>(BOOK_SERVICE.saveBook(bookDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDto> getBookById(@PathVariable Long id){
        return new ResponseEntity<>(BOOK_SERVICE.getBookById(id), HttpStatus.OK);
    }

}
