package com.hogwai.micronaut.repository

import com.hogwai.micronaut.model.Book
import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository
import javax.inject.Singleton

@Repository
interface BookRepository extends JpaRepository<Book, Long> {

}

