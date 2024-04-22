package com.shop.service.impl;

import com.shop.domain.dto.book.BookTitleDto;
import com.shop.domain.dto.user.StatsUserDto;
import com.shop.domain.entity.BookEntity;
import com.shop.domain.entity.UserEntity;
import com.shop.repository.StatsRepository;
import com.shop.service.StatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StatsServiceImpl implements StatsService {
    @Autowired
    private StatsRepository statsRepository;

    public List<BookTitleDto> findBooksByTitleOrGenreName(String keyword) {
        List<BookEntity> books = statsRepository.findBooksByTitleOrGenreName(keyword);
        return books.stream()
                .map(book -> new BookTitleDto(book.getId(), book.getTitle()))
                .collect(Collectors.toList());
    }

    @Override
    public BookTitleDto findMostSoldBook() {
        BookEntity mostSoldBook = statsRepository.findMostSoldBook();
        return new BookTitleDto(mostSoldBook.getId(), mostSoldBook.getTitle());
    }

    @Override
    public BigDecimal calculateTotalSumOfOrders(Integer year) {
        LocalDateTime startDate = LocalDateTime.of(year, 1, 1, 0, 0, 0);
        LocalDateTime endDate = LocalDateTime.of(year, 12, 31, 23, 59, 59);
        return statsRepository.calculateTotalSumOfOrders(startDate, endDate);
    }

    @Override
    public Integer countTotalOrders() {
        return statsRepository.countTotalOrders();
    }

    @Override
    public StatsUserDto findUserWithMostOrders() {
        UserEntity user= statsRepository.findUserWithMostOrders();
        return new StatsUserDto(user.getId(), user.getEmail());
    }
}
