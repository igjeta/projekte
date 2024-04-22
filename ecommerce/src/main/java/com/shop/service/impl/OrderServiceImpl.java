package com.shop.service.impl;

import com.shop.domain.entity.*;
import com.shop.domain.exceptions.ClassicModelException;
import com.shop.repository.OrderItemRepository;
import com.shop.repository.OrderRepository;
import com.shop.service.BookService;
import com.shop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private BookService bookService;

    @Override
    public OrderEntity createOrder(UserEntity user, ShippingAddressEntity shippingAddress) {
        OrderEntity order = OrderEntity.builder()
                .user(user)
                .createdAt(LocalDateTime.now())
                .status(StatusOrderEnum.PENDING)
                .shippingAddress(shippingAddress)
                .enabled(true)
                .build();
        orderRepository.save(order);
        return order;
    }

    @Override
    public void cancelOrder(Integer orderId) {
        OrderEntity order = orderRepository.findById(orderId).orElseThrow(() -> new ClassicModelException("Order with id " + orderId + "does not exist to be cancelled"));
        order.setStatus(StatusOrderEnum.CANCELED);
        orderRepository.save(order);
    }

    @Override
    public List<OrderEntity> findOrdersByUserId(Integer userId) {
        return orderRepository.findAllByUserId(userId);
    }

    @Override
    @Transactional
    public void updateOrderStatus(Integer orderId, StatusOrderEnum newStatus) {
        OrderEntity order = orderRepository.findById(orderId)
                .orElseThrow(() -> new ClassicModelException("Order with id " + orderId + " does not exist"));


        if (newStatus == StatusOrderEnum.CANCELED) {
            List<OrderItemEntity> orderItems = orderItemRepository.findByOrderId(orderId);
            bookService.restoreQuantities(orderItems);
        }
        order.setStatus(newStatus);
        orderRepository.save(order);
    }
}
