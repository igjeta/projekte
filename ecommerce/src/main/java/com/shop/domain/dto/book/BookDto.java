package com.shop.domain.dto.book;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {

    @NotBlank(message = "{validations.books.title}")
    @Size(max = 255, message = "{validations.books.title}")
    private String title;

    @NotBlank(message = "{validations.books.author}")
    @Size(max = 255, message = "{validations.books.author}")
    private String author;

    @NotBlank(message = "{validations.books.isbn}")
    @Size(max = 20, message = "{validations.books.isbn}")
    private String isbn;

    @NotNull(message = "{validations.books.publicationYear}")
    private Integer publicationYear;
    @NotNull(message = "{validations.books.description}")
    private String description;

    @NotNull(message = "{validations.books.genreId}")
    private Integer genreId;

    @NotNull(message = "{validations.books.price}")
    @Positive(message = "{validations.books.price}")
    private BigDecimal price;

    @NotNull(message = "{validations.books.quantity}")
    @Positive(message = "{validations.books.quantity}")
    private Integer quantity;
}