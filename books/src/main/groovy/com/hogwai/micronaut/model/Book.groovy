package com.hogwai.micronaut.model

import groovy.transform.CompileStatic
import groovy.transform.TupleConstructor
import io.micronaut.data.annotation.GeneratedValue

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@CompileStatic
@TupleConstructor
@Entity
@Table(name = "book")
class Book {
    @Id
    @GeneratedValue
    Long id
    String isbn
    String name
}