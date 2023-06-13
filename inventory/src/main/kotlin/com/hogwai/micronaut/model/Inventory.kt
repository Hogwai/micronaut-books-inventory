package com.hogwai.micronaut.model

import io.micronaut.data.annotation.GeneratedValue
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "inventory")
data class Inventory(
    @Id
    @GeneratedValue
    var id: Long,
    var stock: Int?,
    var isbn: String?
)
