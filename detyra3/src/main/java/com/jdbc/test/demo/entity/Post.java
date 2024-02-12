package com.jdbc.test.demo.entity;

import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Post {
    private Integer id;
    private String title;
    private String body;
    private User user;
    private LocalDateTime dateCreated;
    private LocalDateTime dateModified;
}
