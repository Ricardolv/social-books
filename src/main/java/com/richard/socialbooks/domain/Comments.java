package com.richard.socialbooks.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@EqualsAndHashCode(of = "id")
@Entity
public class Comments {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @NotEmpty(message = "O comentario ser vazio.")
    @Size(max = 1500, message = "O comentario nao pode conter mais de 1500 caracteres")
    @JsonProperty("comentario")
    private String text;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String user;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy hh:mm")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Date date;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BOOK_ID")
    private Book book;

}
