package com.hogwai.micronaut.controller

import com.hogwai.micronaut.model.Book
import com.hogwai.micronaut.service.BookService
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.*

@Controller("/books")
class InventoryController(private val bookService: BookService) {

    @Get("/{id}")
    fun getBookById(@PathVariable id: Long): HttpResponse<Book> {
        val book = bookService.getBookById(id)
        return if (book != null) {
            HttpResponse.ok(book)
        } else {
            HttpResponse.notFound()
        }
    }

    @Post("/")
    fun createBook(@Body book: Book): HttpResponse<Book> {
        val createdBook = bookService.createBook(book)
        return HttpResponse.created(createdBook)
    }

    @Put("/{id}")
    fun updateBook(@PathVariable id: Long, @Body book: Book): HttpResponse<Book> {
        val existingBook = bookService.getBookById(id)
        return if (existingBook != null) {
            val updatedBook = book.copy(id = existingBook.id)
            val result = bookService.updateBook(updatedBook)
            HttpResponse.ok(result)
        } else {
            HttpResponse.notFound()
        }
    }

    @Delete("/{id}")
    fun deleteBook(@PathVariable id: Long): HttpResponse<Any> {
        val existingBook = bookService.getBookById(id)
        return if (existingBook != null) {
            bookService.deleteBook(id)
            HttpResponse.noContent()
        } else {
            HttpResponse.notFound()
        }
    }
}
