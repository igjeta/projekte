package com.shop.controller;

import com.shop.domain.dto.book.BookTitleDto;
import com.shop.domain.dto.user.StatsUserDto;
import com.shop.domain.entity.BookEntity;
import com.shop.domain.entity.UserEntity;
import com.shop.service.StatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/stats")
public class StatsController {

    @Autowired
    private StatsService statsService;

    @GetMapping("/books")
    public List<BookTitleDto> findBooksByTitleOrGenreName(@RequestParam String keyword) {
        return statsService.findBooksByTitleOrGenreName(keyword);
    }

    @GetMapping("/mostSoldBook")
    public BookTitleDto findMostSoldBook() {
        return statsService.findMostSoldBook();
    }

    @GetMapping("/totalSumOfOrders")
    public BigDecimal calculateTotalSumOfOrders(@RequestParam Integer year) {
        return statsService.calculateTotalSumOfOrders(year);
    }

    @GetMapping("/totalOrders")
    public Integer countTotalOrders() {
        return statsService.countTotalOrders();
    }

    @GetMapping("/userWithMostOrders")
    public StatsUserDto findUserWithMostOrders() {
        return statsService.findUserWithMostOrders();
    }
}
