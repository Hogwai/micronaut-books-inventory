package com.hogwai.micronaut.controller

import com.hogwai.micronaut.model.Book
import com.hogwai.micronaut.service.BookService
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Delete
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post
import io.micronaut.http.annotation.Put

@Controller("/books")
class BookController {

    private final BookService bookService

    BookController(BookService bookService) {
        this.bookService = bookService
    }

    @Get("/")
    List<Book> getAllBooks() {
        bookService.getAllBooks()
    }

    @Get("/{id}")
    Book getBookById(Long id) {
        bookService.getBookById(id)
    }

    @Post("/")
    Book createBook(String isbn, String name) {
        bookService.createBook(isbn, name)
    }

    @Put("/{id}")
    Book updateBook(Long id, String isbn, String name) {
        bookService.updateBook(id, isbn, name)
    }

    @Delete("/{id}")
    void deleteBook(Long id) {
        bookService.deleteBook(id)
    }
}
