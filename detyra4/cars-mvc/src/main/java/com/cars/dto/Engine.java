package com.cars.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class Engine {
    private Integer id;
    private Integer power;
    private String type;
}
