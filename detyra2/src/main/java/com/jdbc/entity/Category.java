package com.jdbc.entity;

import lombok.*;

import java.time.LocalDate;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Category {
    private Integer id;
    private String name;
    private LocalDate dateCreated;
    private LocalDate dateModified;
}
