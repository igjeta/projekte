package com.shop.domain.mapper;

import com.shop.domain.dto.genre.GenreDto;
import com.shop.domain.entity.GenreEntity;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-05T13:51:25+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 20.0.1 (Oracle Corporation)"
)
public class GenreMapperImpl implements GenreMapper {

    @Override
    public GenreDto toDTO(GenreEntity entity) {
        if ( entity == null ) {
            return null;
        }

        GenreDto.GenreDtoBuilder genreDto = GenreDto.builder();

        genreDto.name( entity.getName() );

        return genreDto.build();
    }

    @Override
    public GenreEntity toEntity(GenreDto genreDto) {
        if ( genreDto == null ) {
            return null;
        }

        GenreEntity.GenreEntityBuilder genreEntity = GenreEntity.builder();

        genreEntity.name( genreDto.getName() );

        return genreEntity.build();
    }
}
