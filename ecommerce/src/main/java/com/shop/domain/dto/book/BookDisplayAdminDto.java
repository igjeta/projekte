package com.shop.domain.dto.book;


import com.shop.domain.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookDisplayAdminDto {

    private Integer id;


    private String title;


    private String author;


    private String isbn;


    private Integer publicationYear;


    private Integer genreId;


    private BigDecimal price;

    private Integer quantity;


    private String description;


    private LocalDateTime createdAt;


    private LocalDateTime modifiedAt;

    private boolean enabled;


    private Integer createdBy;

    private Integer modifiedBy;
}
