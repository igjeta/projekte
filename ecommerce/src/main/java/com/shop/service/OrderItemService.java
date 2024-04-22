package com.shop.service;

import com.shop.domain.dto.order.AdminOrderDto;
import com.shop.domain.dto.order.OrderSumDto;

import java.util.List;
import java.util.Map;

public interface OrderItemService {

    void createOrderItems(Map<Integer, Integer> itemsDto, Integer addressId);

    //    void cancelOrder(Integer orderId);
    List<OrderSumDto> getOrderSums();

    List<AdminOrderDto> getAllOrdersForAdmin();
}
