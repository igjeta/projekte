package com.shop.domain.mapper;

import com.shop.domain.dto.book.*;
import com.shop.domain.entity.BookEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BookCreateUpdateMapper extends BaseMapper<BookEntity,BookDto>{
    BookCreateUpdateMapper BOOK_CREATE_UPDATE_MAPPER = Mappers.getMapper(BookCreateUpdateMapper.class);
    @Override
    @Mapping(target = "id", ignore = true)
    BookEntity toEntity(BookDto dto);

    @Override
    BookDto toDTO(BookEntity entity);
}
