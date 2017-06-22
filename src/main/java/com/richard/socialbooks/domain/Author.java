package com.richard.socialbooks.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Data
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@Entity
@Table(name = "author")
public class Author {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "O campo nome nao pode ser vazio.")
    private String name;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @NotNull(message = "Data nascimento e obrigatorio.")
    private Date birthDate;

    @NotNull(message = "Nacionalidade e obrigatorio.")
    private String nationality;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnore
    @OneToMany(mappedBy = "author")
    private List<Book> books;

}
