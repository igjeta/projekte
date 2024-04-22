package com.shop.repository;

import com.shop.domain.entity.OrderItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderItemRepository extends JpaRepository<OrderItemEntity,Integer> {

    List<OrderItemEntity> findByOrderId(Integer orderId);
}
