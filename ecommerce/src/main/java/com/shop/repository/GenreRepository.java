package com.shop.repository;

import com.shop.domain.entity.BookEntity;
import com.shop.domain.entity.GenreEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface GenreRepository extends JpaRepository<GenreEntity,Integer> {
    List<GenreEntity> findAllByEnabledTrue();
    Optional<GenreEntity> findByIdAndEnabledTrue(Integer id);
    Optional<GenreEntity> findByName(String name);

    Optional<GenreEntity> findByNameAndIdNot(String name,Integer genreId);
}
