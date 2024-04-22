package com.jdbc.test.demo.entity;

import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Category {
    private Integer id;
    private String name;
    private LocalDateTime dateCreated;
    private LocalDateTime dateModified;
}
