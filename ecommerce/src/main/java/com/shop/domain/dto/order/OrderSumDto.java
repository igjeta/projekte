package com.shop.domain.dto.order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderSumDto {
    private Integer orderId;
    private String orderStatus;
    private BigDecimal totalSum;
    private List<OrderItemDto> orderItems;
}
