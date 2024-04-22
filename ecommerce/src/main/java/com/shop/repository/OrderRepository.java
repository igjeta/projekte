package com.shop.repository;

import com.shop.domain.entity.BookEntity;
import com.shop.domain.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<OrderEntity,Integer> {
    List<OrderEntity> findAllByEnabledTrue();
    List<OrderEntity> findAllByUserId(Integer userId);
}
