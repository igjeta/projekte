package com.shop.domain.mapper;

import com.shop.domain.dto.book.BookDisplayAdminDto;
import com.shop.domain.dto.book.BookDisplayDto;
import com.shop.domain.entity.BookEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BookDisplayMapper{
    BookDisplayMapper BOOK_DISPLAY_MAPPER = Mappers.getMapper(BookDisplayMapper.class);

    @Mapping(target = "genre",source = "entity.genre.name")
    @Mapping(target = "genreId",source = "entity.genre.id")
    BookDisplayDto toDTO(BookEntity entity);


    @Mapping(target = "genreId", ignore = true )
    @Mapping(target = "createdBy", ignore = true )
    @Mapping(target = "modifiedBy", ignore = true )
    BookDisplayAdminDto toDtoAdmin(BookEntity bookEntity);

}
