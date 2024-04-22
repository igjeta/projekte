package com.shop.domain.mapper;

import com.shop.domain.dto.shippingaddress.ShippingAddressCreateUpdateDto;
import com.shop.domain.dto.shippingaddress.ShippingAddressDto;
import com.shop.domain.entity.ShippingAddressEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ShippingAddressMapper extends BaseMapper<ShippingAddressEntity, ShippingAddressDto>{

    ShippingAddressMapper SHIPPING_ADDRESS_MAPPER= Mappers.getMapper(ShippingAddressMapper.class);

    @Override
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "enabled",ignore = true)
    @Mapping(target = "createdAt",ignore = true)
    @Mapping(target = "modifiedAt",ignore = true)
    ShippingAddressEntity toEntity(ShippingAddressDto dto);

    @Mapping(target = "user", ignore = true)
    @Mapping(target = "enabled",ignore = true)
    @Mapping(target = "createdAt",ignore = true)
    @Mapping(target = "modifiedAt",ignore = true)
    @Mapping(target = "addressLine1",ignore=true)
    ShippingAddressEntity toEntityCrud(ShippingAddressCreateUpdateDto dto);

    @Override
    ShippingAddressDto toDTO(ShippingAddressEntity entity);
}
