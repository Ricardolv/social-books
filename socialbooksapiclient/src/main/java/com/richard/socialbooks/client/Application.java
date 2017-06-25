package com.richard.socialbooks.client;


import com.richard.socialbooks.client.domain.Book;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

public class Application {

    public static final String URI_BOOKS = "http://localhost:8080/books";

    public static void main(String[] args) {

        RestTemplate restTemplate = new RestTemplate();

        RequestEntity<Void> request = RequestEntity.get(URI.create(URI_BOOKS))
                        .header("Authorization", "Basic cmljaGFyZDpzZW5oYQ==").build();


        ResponseEntity<Book[]> response = restTemplate.exchange(request, Book[].class);

        for (Book book : response.getBody()) {
            System.out.println("livro: " + book.getName());
        }

    }

}
