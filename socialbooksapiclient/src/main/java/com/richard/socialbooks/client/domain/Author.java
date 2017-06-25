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
public class Author {

    private Long id;
    private String name;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date birthDate;
    private String nationality;
    private List<Book> books;

}
