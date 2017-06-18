package com.richard.socialbooks.domain;


import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Data
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@RequiredArgsConstructor
public class Book {

    private Long id;

    @NonNull
    private String name;
    private LocalDate publication;
    private String publishers;
    private List<Comments> comments;
    private String author;

}
