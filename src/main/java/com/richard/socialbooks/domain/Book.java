package com.richard.socialbooks.domain;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;


@Data
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@Entity
@Table(name = "book")
public class Book {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String name;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private LocalDate publication;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String publishers;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @OneToMany(mappedBy = "book")
    private List<Comments> comments;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @ManyToOne
    @JoinColumn(name = "AUTHOR_ID")
    private Author author;

}
