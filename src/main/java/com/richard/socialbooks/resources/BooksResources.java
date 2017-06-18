package com.richard.socialbooks.resources;

import com.richard.socialbooks.domain.Book;
import com.richard.socialbooks.service.BooksService;
import com.richard.socialbooks.service.exceptions.BookFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BooksResources {

    @Autowired
    private BooksService booksService;

    @GetMapping
    public ResponseEntity<List<Book>> list() {
        return ResponseEntity.ok(booksService.findAll());
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody Book book) {
        book = booksService.save(book);

        URI uri = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(book.getId())
                    .toUri();

        return ResponseEntity.created(uri).build();

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> search(@PathVariable("id") Long id) {
        Book book = booksService.search(id);
        return ResponseEntity.ok(book);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        booksService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody Book book) {
        booksService.update(book);
        return ResponseEntity.noContent().build();
    }
}
