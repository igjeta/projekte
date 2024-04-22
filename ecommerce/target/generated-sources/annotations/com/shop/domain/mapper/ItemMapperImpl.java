package com.shop.domain.mapper;

import com.shop.domain.dto.order.ItemsDto;
import com.shop.domain.entity.OrderItemEntity;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-05T13:51:25+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 20.0.1 (Oracle Corporation)"
)
public class ItemMapperImpl implements ItemMapper {

    @Override
    public OrderItemEntity toEntity(ItemsDto dto) {
        if ( dto == null ) {
            return null;
        }

        OrderItemEntity.OrderItemEntityBuilder orderItemEntity = OrderItemEntity.builder();

        orderItemEntity.quantity( dto.getQuantity() );

        return orderItemEntity.build();
    }
}
