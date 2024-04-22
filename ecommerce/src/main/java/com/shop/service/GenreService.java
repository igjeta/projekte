package com.shop.service;

import com.shop.domain.dto.genre.GenreDto;
import com.shop.domain.entity.GenreEntity;

import java.util.List;

public interface GenreService {

    List<GenreEntity> allGenres();
    void createGenre(GenreDto genre);
    void updateGenre(GenreDto genreDto,Integer genreId);
    void genreAction(Integer genreId,Boolean enabled);
}
