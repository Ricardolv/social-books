package com.richard.socialbooks.client;


import com.richard.socialbooks.client.domain.Book;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

public class BooksClient {

    public static final String URI_HOST = "http://localhost:8080/";
    public static final String URI_BOOKS = URI_HOST.concat("books");

    public List<Book> list() {
        RestTemplate restTemplate = new RestTemplate();

        RequestEntity<Void> request = RequestEntity.get(URI.create(URI_BOOKS))
                .header("Authorization", "Basic cmljaGFyZDpzZW5oYQ==").build();

        ResponseEntity<Book[]> response = restTemplate.exchange(request, Book[].class);

        return Arrays.asList(response.getBody());
    }

    public String save(Book book) {
        RestTemplate restTemplate = new RestTemplate();

        RequestEntity<Book> request = RequestEntity.post(URI.create(URI_BOOKS))
                .header("Authorization", "Basic cmljaGFyZDpzZW5oYQ==")
                .body(book);

        ResponseEntity<Void> response = restTemplate.exchange(request, Void.class);

        return response.getHeaders().getLocation().toString();
    }
}
