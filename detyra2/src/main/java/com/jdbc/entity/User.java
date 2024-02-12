package com.jdbc.entity;

import lombok.*;

import java.time.LocalDate;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
    private Integer id;
    private String username;
    private String email;
    private String password;
    private LocalDate dateCreated;
    private LocalDate dateModified;

}
