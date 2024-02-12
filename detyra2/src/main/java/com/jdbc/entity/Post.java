package com.jdbc.entity;

import lombok.*;

import java.time.LocalDate;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Post {
    private Integer id;
    private String title;
    private String body;
    private Integer userId;
    private LocalDate dateCreated;
    private LocalDate dateModified;
}
