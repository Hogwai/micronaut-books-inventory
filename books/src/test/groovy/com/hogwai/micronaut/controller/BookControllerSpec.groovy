package com.hogwai.micronaut.controller

import com.hogwai.micronaut.model.Book
import io.micronaut.context.ApplicationContext
import io.micronaut.core.type.Argument
import io.micronaut.http.HttpRequest
import io.micronaut.http.client.HttpClient
import io.micronaut.runtime.server.EmbeddedServer
import spock.lang.AutoCleanup
import spock.lang.Shared
import spock.lang.Specification

class BookControllerSpec extends Specification {

    @Shared
    @AutoCleanup
    EmbeddedServer embeddedServer = ApplicationContext.run(EmbeddedServer)

    @Shared @AutoCleanup HttpClient client = embeddedServer.applicationContext.createBean(HttpClient, embeddedServer.getURL())

    void "test books retrieve"() {
        when:
        HttpRequest request = HttpRequest.GET('/api/books')
        List<Book> books = client.toBlocking().retrieve(request, Argument.of(List, Book))

        then:
        books.size() == 0
    }
}