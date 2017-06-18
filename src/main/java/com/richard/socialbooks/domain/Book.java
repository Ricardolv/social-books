package com.richard.socialbooks.domain;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Data
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@RequiredArgsConstructor
public class Book {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long id;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @NonNull
    private String name;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private LocalDate publication;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String publishers;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<Comments> comments;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String author;

}
