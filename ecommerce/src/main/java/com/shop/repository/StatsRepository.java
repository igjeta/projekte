package com.shop.repository;

import com.shop.domain.entity.BookEntity;
import com.shop.domain.entity.UserEntity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public interface StatsRepository {

    List<BookEntity> findBooksByTitleOrGenreName(String keyword);
    BookEntity findMostSoldBook();
    BigDecimal calculateTotalSumOfOrders(LocalDateTime startDate, LocalDateTime endDate);
    Integer countTotalOrders();
    UserEntity findUserWithMostOrders();
}
