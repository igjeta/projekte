package com.shop.domain.dto.order;

import com.shop.domain.entity.StatusOrderEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AdminOrderDto {
    private Integer orderId;
    private StatusOrderEnum status;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private List<OrderItemDto> orderItems;
}
