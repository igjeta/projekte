package com.jdbc.entity;

import lombok.*;

import java.time.LocalDate;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PostCategory {
    private Integer id;
    private Integer postId;
    private Integer categoryId;
    private LocalDate dateCreated;
    private LocalDate dateModified;
}
