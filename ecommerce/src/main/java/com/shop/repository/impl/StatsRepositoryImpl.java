package com.shop.repository.impl;

import com.shop.domain.entity.BookEntity;
import com.shop.domain.entity.UserEntity;
import com.shop.repository.StatsRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public class StatsRepositoryImpl implements StatsRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<BookEntity> findBooksByTitleOrGenreName(String keyword) {
        String formattedKeyword = "%" + keyword + "%";
        return entityManager.createQuery("SELECT DISTINCT b FROM BookEntity b LEFT JOIN FETCH b.genre g WHERE b.title LIKE :keyword OR g.name LIKE :keyword", BookEntity.class)
                .setParameter("keyword", formattedKeyword)
                .getResultList();
    }

    @Override
    public BookEntity findMostSoldBook() {
        return entityManager.createQuery("SELECT b FROM BookEntity b ORDER BY b.quantity DESC", BookEntity.class)
                .setMaxResults(1)
                .getSingleResult();
    }

    @Override
    public BigDecimal calculateTotalSumOfOrders(LocalDateTime startDate, LocalDateTime endDate) {
        int startYear = startDate.getYear();
        int endYear = endDate.getYear();
        return entityManager.createQuery("SELECT SUM(oi.quantity * oi.price) FROM OrderItemEntity oi WHERE YEAR(oi.createdAt) BETWEEN :startYear AND :endYear", BigDecimal.class)
                .setParameter("startYear", startYear)
                .setParameter("endYear", endYear)
                .getSingleResult();
    }

    @Override
    public Integer countTotalOrders() {
        Long totalCount = entityManager.createQuery("SELECT COUNT(o) FROM OrderEntity o", Long.class)
                .getSingleResult();
        return totalCount.intValue();
    }

    @Override
    public UserEntity findUserWithMostOrders() {
        return entityManager.createQuery("SELECT u FROM UserEntity u INNER JOIN u.orders o GROUP BY u.id ORDER BY COUNT(o) DESC", UserEntity.class)
                .setMaxResults(1)
                .getSingleResult();
    }
}
