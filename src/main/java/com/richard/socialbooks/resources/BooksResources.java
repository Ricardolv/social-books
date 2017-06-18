package com.richard.socialbooks.resources;

import com.richard.socialbooks.domain.Book;
import com.richard.socialbooks.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BooksResources {

    @Autowired
    private BooksRepository booksRepository;

    @GetMapping
    public List<Book> list() {
        return booksRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody Book book) {
        book = booksRepository.save(book);

        URI uri = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(book.getId())
                    .toUri();

        return ResponseEntity.created(uri).build();

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> search(@PathVariable("id") Long id) {
        Book book = booksRepository.findOne(id);

        if (null == book) {
            return  ResponseEntity.notFound().build();
        }

        return ResponseEntity.status(HttpStatus.OK).body(book);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        booksRepository.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody Book book) {
        booksRepository.save(book);
    }
}
