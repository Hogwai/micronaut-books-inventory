package com.hogwai.micronaut.service

import com.hogwai.micronaut.model.Book
import com.hogwai.micronaut.repository.BookRepository
import javax.inject.Singleton

@Singleton
class BookService {

    BookRepository bookRepository

    BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository
    }

    List<Book> getAllBooks() {
        bookRepository.findAll()
    }

    Book getBookById(Long id) {
        bookRepository.findById(id).orElse(null)
    }

    Book createBook(String isbn, String name) {
        def book = new Book(isbn: isbn, name: name)
        bookRepository.save(book)
    }

    Book updateBook(Long id, String isbn, String name) {
        def book = bookRepository.findById(id).orElse(null)
        if (book) {
            book.isbn = isbn
            book.name = name
            bookRepository.save(book)
        }
        return book
    }

    void deleteBook(Long id) {
        bookRepository.deleteById(id)
    }
}
