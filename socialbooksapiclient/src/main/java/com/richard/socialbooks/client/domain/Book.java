package com.richard.socialbooks.client.domain;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
public class Book {

    private Long id;
    private String name;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy hh:mm")
    private Date publication;
    private String publishers;
    private List<Comments> comments;
    private Author author;

}
