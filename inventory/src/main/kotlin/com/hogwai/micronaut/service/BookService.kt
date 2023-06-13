package com.hogwai.micronaut.service

import com.hogwai.micronaut.model.Book
import com.hogwai.micronaut.repository.BookRepository

import javax.inject.Singleton
import javax.transaction.Transactional

@Singleton
open class BookService(private val bookRepository: BookRepository) {

    @Transactional
    open fun createBook(book: Book): Book {
        return bookRepository.save(book)
    }

    open fun getBookById(id: Long): Book? {
        return bookRepository.findById(id).orElse(null)
    }

    @Transactional
    open fun updateBook(book: Book): Book {
        return bookRepository.update(book)
    }

    @Transactional
    open fun deleteBook(id: Long) {
        bookRepository.deleteById(id)
    }
}
