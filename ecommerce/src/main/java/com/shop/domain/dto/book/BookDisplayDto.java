package com.shop.domain.dto.book;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookDisplayDto {
    private Integer id;

    private String title;

    private String author;

    private String isbn;

    private Integer publicationYear;

    private String description;

    private BigDecimal price;

    private String genre;

    private Integer genreId;
}