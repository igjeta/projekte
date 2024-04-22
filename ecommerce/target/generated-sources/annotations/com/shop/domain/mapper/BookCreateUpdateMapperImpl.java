package com.shop.domain.mapper;

import com.shop.domain.dto.book.BookDto;
import com.shop.domain.entity.BookEntity;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-05T13:51:25+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 20.0.1 (Oracle Corporation)"
)
public class BookCreateUpdateMapperImpl implements BookCreateUpdateMapper {

    @Override
    public BookEntity toEntity(BookDto dto) {
        if ( dto == null ) {
            return null;
        }

        BookEntity.BookEntityBuilder bookEntity = BookEntity.builder();

        bookEntity.title( dto.getTitle() );
        bookEntity.author( dto.getAuthor() );
        bookEntity.isbn( dto.getIsbn() );
        bookEntity.publicationYear( dto.getPublicationYear() );
        bookEntity.price( dto.getPrice() );
        bookEntity.quantity( dto.getQuantity() );
        bookEntity.description( dto.getDescription() );

        return bookEntity.build();
    }

    @Override
    public BookDto toDTO(BookEntity entity) {
        if ( entity == null ) {
            return null;
        }

        BookDto.BookDtoBuilder bookDto = BookDto.builder();

        bookDto.title( entity.getTitle() );
        bookDto.author( entity.getAuthor() );
        bookDto.isbn( entity.getIsbn() );
        bookDto.publicationYear( entity.getPublicationYear() );
        bookDto.description( entity.getDescription() );
        bookDto.price( entity.getPrice() );
        bookDto.quantity( entity.getQuantity() );

        return bookDto.build();
    }
}
