package com.shop.repository;

import com.shop.domain.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface BookRepository extends JpaRepository<BookEntity,Integer> {

    List<BookEntity> findAllByEnabledTrue();
    Optional<BookEntity> findByTitleAndEnabledTrue(String title);

    Optional<BookEntity> findByIdAndEnabledTrue(Integer integer);

    Optional<BookEntity> findByTitleAndIdNot(String bookName, Integer id);

    List<BookEntity>findAllByEnabledTrueAndIdIn(Set<Integer> bookIds);
}
