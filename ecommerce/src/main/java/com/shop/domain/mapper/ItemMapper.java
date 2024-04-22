package com.shop.domain.mapper;

import com.shop.domain.dto.order.ItemsDto;
import com.shop.domain.entity.OrderItemEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ItemMapper {
    ItemMapper ITEM_MAPPER= Mappers.getMapper(ItemMapper.class);

    @Mapping(target = "book",ignore = true)
    @Mapping(target = "price",ignore = true)
    @Mapping(target = "createdAt",ignore = true)
    @Mapping(target = "modifiedAt",ignore = true)
    @Mapping(target = "order",ignore = true)
    OrderItemEntity toEntity(ItemsDto dto);

}
