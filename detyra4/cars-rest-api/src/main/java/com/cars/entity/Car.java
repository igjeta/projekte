package com.cars.entity;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class Car {
    private Integer id;
    private String name;
    private String fromYear;
    private String toYear;
    private String type;
    private Wheels wheels;
    private Engine engine;
}
