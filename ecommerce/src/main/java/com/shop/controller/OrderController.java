package com.shop.controller;

import com.shop.domain.dto.order.AdminOrderDto;
import com.shop.domain.dto.order.OrderSumDto;
import com.shop.domain.entity.OrderEntity;
import com.shop.domain.entity.StatusOrderEnum;
import com.shop.service.OrderItemService;
import com.shop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    @Autowired
    private OrderItemService orderItemService;

    @Autowired
    private OrderService orderService;

    @PostMapping("/create")
    public ResponseEntity<String> createOrder(@RequestBody Map<Integer, Integer> itemsDto, @RequestParam("addressId") Integer addressId) {
        orderItemService.createOrderItems(itemsDto, addressId);
        return ResponseEntity.ok("Order created successfully!");
    }

    @GetMapping("/all")
    public ResponseEntity<List<OrderSumDto>> getOrderSums() {
        List<OrderSumDto> orderSumDtoList = orderItemService.getOrderSums();
        return ResponseEntity.ok(orderSumDtoList);
    }

    @GetMapping("/admin/all")
    public ResponseEntity<List<AdminOrderDto>> getAllOrdersForAdmin() {
        List<AdminOrderDto> adminOrders = orderItemService.getAllOrdersForAdmin();
        return ResponseEntity.ok(adminOrders);
    }

    @PutMapping("/{orderId}/status")
    public ResponseEntity<String> updateOrderStatus(@PathVariable("orderId") Integer orderId, @RequestParam("status") StatusOrderEnum newStatus) {
        orderService.updateOrderStatus(orderId, newStatus);
        return ResponseEntity.ok("Order status updated successfully!");
    }
}
