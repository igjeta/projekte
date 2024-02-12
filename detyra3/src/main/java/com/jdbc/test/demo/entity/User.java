package com.jdbc.test.demo.entity;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class User {
    private Integer id;
    private String username;
    private String email;
    private String password;
    private LocalDateTime dateCreated;
    private LocalDateTime dateModified;
}
