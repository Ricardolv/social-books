package com.richard.socialbooks.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@Data
@EqualsAndHashCode(of = "id")
public class Comments {

    private Long id;
    private String text;
    private String user;
    private LocalDate date;

}
