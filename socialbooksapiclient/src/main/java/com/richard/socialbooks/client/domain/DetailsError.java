package com.richard.socialbooks.client.domain;

import lombok.Data;

@Data
public class DetailsError {

    private String title;
    private Long status;
    private Long timesTamp;
    private String messageDev;

}
