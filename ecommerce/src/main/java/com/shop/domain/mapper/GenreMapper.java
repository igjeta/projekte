package com.shop.domain.mapper;

import com.shop.domain.dto.genre.GenreDto;
import com.shop.domain.entity.GenreEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface GenreMapper extends BaseMapper<GenreEntity, GenreDto> {
    GenreMapper GENRE_MAPPER = Mappers.getMapper(GenreMapper.class);

    @Override
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "modifiedAt", ignore = true)
    @Mapping(target = "enabled", ignore = true)
    @Mapping(target = "id", ignore = true)
    GenreEntity toEntity(GenreDto genreDto);
}
