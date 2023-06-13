package com.hogwai.micronaut.model

import io.micronaut.data.annotation.GeneratedValue
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "book")
data class Book(
    @Id
    @GeneratedValue
    var id: Long?,
    var isbn: String?,
    var name: String?
)

