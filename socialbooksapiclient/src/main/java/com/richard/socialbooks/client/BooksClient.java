package com.richard.socialbooks.client;


import com.richard.socialbooks.client.domain.Book;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

public class BooksClient {

    private static final String AUTHORIZATION = "Authorization";
    private static final String URN_BASE = "/books";
    private String URI_BASE;
    private String credential;
    private RestTemplate restTemplate;

    public BooksClient(String url, String user, String password) {

        this.restTemplate = new RestTemplate();
        this.URI_BASE = url.concat(URN_BASE);
        String credentialAux = user + ":" + password;
        this.credential = "Basic " + Base64.getEncoder().encodeToString(credentialAux.getBytes());
    }

    public List<Book> list() {
        RequestEntity<Void> request = RequestEntity.get(URI.create(this.URI_BASE))
                                      .header(AUTHORIZATION, this.credential).build();

        ResponseEntity<Book[]> response = this.restTemplate.exchange(request, Book[].class);

        return Arrays.asList(response.getBody());
    }

    public String save(Book book) {
        RequestEntity<Book> request = RequestEntity.post(URI.create(this.URI_BASE))
                                      .header(AUTHORIZATION, this.credential).body(book);

        ResponseEntity<Void> response = this.restTemplate.exchange(request, Void.class);

        return response.getHeaders().getLocation().toString();
    }

    public Book search(String uri) {
        RequestEntity<Void> request = RequestEntity.get(URI.create(uri))
                                      .header(AUTHORIZATION, this.credential).build();

        ResponseEntity<Book> response = this.restTemplate.exchange(request, Book.class);

        return response.getBody();
    }
}
