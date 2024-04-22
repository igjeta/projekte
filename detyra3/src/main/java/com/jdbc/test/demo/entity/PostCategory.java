package com.jdbc.test.demo.entity;

import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class PostCategory {
    private Integer id;
    private Post post;
    private Category category;
    private LocalDateTime dateCreated;
    private LocalDateTime dateModified;
}
