package com.shop.service;

import com.shop.domain.dto.book.BookTitleDto;
import com.shop.domain.dto.user.StatsUserDto;
import com.shop.domain.entity.BookEntity;
import com.shop.domain.entity.UserEntity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public interface StatsService {

    List<BookTitleDto> findBooksByTitleOrGenreName(String keyword);

    BookTitleDto findMostSoldBook();

    BigDecimal calculateTotalSumOfOrders(Integer year);

     Integer countTotalOrders();

    StatsUserDto findUserWithMostOrders();
}
