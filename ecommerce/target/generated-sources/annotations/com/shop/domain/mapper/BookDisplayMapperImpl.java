package com.shop.domain.mapper;

import com.shop.domain.dto.book.BookDisplayAdminDto;
import com.shop.domain.dto.book.BookDisplayDto;
import com.shop.domain.entity.BookEntity;
import com.shop.domain.entity.GenreEntity;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-05T13:51:25+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 20.0.1 (Oracle Corporation)"
)
public class BookDisplayMapperImpl implements BookDisplayMapper {

    @Override
    public BookDisplayDto toDTO(BookEntity entity) {
        if ( entity == null ) {
            return null;
        }

        BookDisplayDto.BookDisplayDtoBuilder bookDisplayDto = BookDisplayDto.builder();

        bookDisplayDto.genre( entityGenreName( entity ) );
        bookDisplayDto.genreId( entityGenreId( entity ) );
        bookDisplayDto.id( entity.getId() );
        bookDisplayDto.title( entity.getTitle() );
        bookDisplayDto.author( entity.getAuthor() );
        bookDisplayDto.isbn( entity.getIsbn() );
        bookDisplayDto.publicationYear( entity.getPublicationYear() );
        bookDisplayDto.description( entity.getDescription() );
        bookDisplayDto.price( entity.getPrice() );

        return bookDisplayDto.build();
    }

    @Override
    public BookDisplayAdminDto toDtoAdmin(BookEntity bookEntity) {
        if ( bookEntity == null ) {
            return null;
        }

        BookDisplayAdminDto.BookDisplayAdminDtoBuilder bookDisplayAdminDto = BookDisplayAdminDto.builder();

        bookDisplayAdminDto.id( bookEntity.getId() );
        bookDisplayAdminDto.title( bookEntity.getTitle() );
        bookDisplayAdminDto.author( bookEntity.getAuthor() );
        bookDisplayAdminDto.isbn( bookEntity.getIsbn() );
        bookDisplayAdminDto.publicationYear( bookEntity.getPublicationYear() );
        bookDisplayAdminDto.price( bookEntity.getPrice() );
        bookDisplayAdminDto.quantity( bookEntity.getQuantity() );
        bookDisplayAdminDto.description( bookEntity.getDescription() );
        bookDisplayAdminDto.createdAt( bookEntity.getCreatedAt() );
        bookDisplayAdminDto.modifiedAt( bookEntity.getModifiedAt() );
        bookDisplayAdminDto.enabled( bookEntity.isEnabled() );

        return bookDisplayAdminDto.build();
    }

    private String entityGenreName(BookEntity bookEntity) {
        if ( bookEntity == null ) {
            return null;
        }
        GenreEntity genre = bookEntity.getGenre();
        if ( genre == null ) {
            return null;
        }
        String name = genre.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }

    private Integer entityGenreId(BookEntity bookEntity) {
        if ( bookEntity == null ) {
            return null;
        }
        GenreEntity genre = bookEntity.getGenre();
        if ( genre == null ) {
            return null;
        }
        Integer id = genre.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
