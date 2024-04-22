package com.shop.service.impl;

import com.shop.domain.dto.genre.GenreDto;
import com.shop.domain.entity.GenreEntity;
import com.shop.domain.exceptions.ClassicModelException;
import com.shop.repository.GenreRepository;
import com.shop.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static com.shop.domain.mapper.GenreMapper.GENRE_MAPPER;

@Service
public class GenreServiceImpl implements GenreService {

    @Autowired
    private GenreRepository genreRepository;

    @Override
    public List<GenreEntity> allGenres() {
        return genreRepository.findAll();
    }

    @Override
    public void createGenre(GenreDto genreDto) {
        Optional<GenreEntity> genre = genreRepository.findByName(genreDto.getName());
        if (genre.isPresent()) {
            if ((genre.get().isEnabled()))
                throw new ClassicModelException("Genre already exist and it is enabled");
            else {
                genre.get().setEnabled(true);
                genre.get().setModifiedAt(LocalDateTime.now());
                genreRepository.save(genre.get());
            }
        }
        else{
        GenreEntity genreNewToAdd = GENRE_MAPPER.toEntity(genreDto);
        genreNewToAdd.setCreatedAt(LocalDateTime.now());
        genreNewToAdd.setEnabled(true);

        genreRepository.save(genreNewToAdd);}
    }

    @Override
    public void updateGenre(GenreDto genreDto, Integer genreId) {
        GenreEntity genreEntityOptional = genreRepository.findById(genreId)
                .orElseThrow(() -> new ClassicModelException("Genre with id " + genreId + " was not found to be updated"));
        GenreEntity genreIfNameExists = genreRepository.findByNameAndIdNot(genreDto.getName(), genreId)
                .orElseThrow(() -> new ClassicModelException("Genre name you provided for update exist on another genre"));
        genreEntityOptional.setModifiedAt(LocalDateTime.now());
        genreEntityOptional.setName(genreDto.getName());
        genreRepository.save(genreEntityOptional);
    }

    @Override
    public void genreAction(Integer genreId, Boolean enabled) {
        GenreEntity genre = genreRepository.findById(genreId)
                .orElseThrow(() -> new ClassicModelException("Genre with id " + genreId + " does not exists"));
        genre.setEnabled(enabled);
        genreRepository.save(genre);
    }
}
