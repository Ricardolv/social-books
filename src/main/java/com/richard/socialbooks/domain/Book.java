package com.richard.socialbooks.domain;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
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

    @NotEmpty(message = "O campo nome nao pode ser vazio.")
    private String name;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy hh:mm")
    @NotNull(message = "Campo publicacao e obrigatorio.")
    private Date publication;

    @NotEmpty(message = "O campo editora nao pode ser vazio.")
    private String publishers;


    @OneToMany(mappedBy = "book")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @Size(max = 1500, message = "O resumo nao pode conter mais de 1500 caracteres")
    private List<Comments> comments;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @ManyToOne
    @JoinColumn(name = "AUTHOR_ID")
    private Author author;

}
