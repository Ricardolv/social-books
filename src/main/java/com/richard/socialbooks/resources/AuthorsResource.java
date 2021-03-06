package com.richard.socialbooks.resources;

import com.richard.socialbooks.domain.Author;
import com.richard.socialbooks.service.AuthorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorsResource {

    @Autowired
    private AuthorsService authorsService;

    @GetMapping(produces = {
            MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE
    })
    public ResponseEntity<List<Author>> list() {
        return ResponseEntity.ok(authorsService.list());
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody Author author) {
        author = authorsService.save(author);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(author.getId()).toUri();

        return ResponseEntity.created(uri).build();

    }

    @GetMapping("/{id}")
    public ResponseEntity<Author> search(@PathVariable("id") Long id) {
        return ResponseEntity.ok(authorsService.search(id));
    }
}
