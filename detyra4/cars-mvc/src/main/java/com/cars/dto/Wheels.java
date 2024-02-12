package com.cars.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class Wheels {
    private Integer id;
    private String size;
    private String type;
}
