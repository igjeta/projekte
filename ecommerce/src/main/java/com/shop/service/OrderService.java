package com.shop.service;

import com.shop.domain.entity.OrderEntity;
import com.shop.domain.entity.ShippingAddressEntity;
import com.shop.domain.entity.StatusOrderEnum;
import com.shop.domain.entity.UserEntity;

import java.util.List;

public interface OrderService {

    OrderEntity createOrder(UserEntity user, ShippingAddressEntity shippingAddress);
    void cancelOrder(Integer orderId);
    List<OrderEntity> findOrdersByUserId(Integer userId);
    void updateOrderStatus(Integer orderId, StatusOrderEnum newStatus);
}
