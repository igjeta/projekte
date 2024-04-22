package com.shop.service;

import com.shop.domain.dto.shippingaddress.ShippingAddressCreateUpdateDto;
import com.shop.domain.dto.shippingaddress.ShippingAddressDto;
import com.shop.domain.entity.ShippingAddressEntity;
import com.shop.domain.entity.UserEntity;

import java.util.List;

public interface ShippingAddressService {

    List<ShippingAddressDto> getAllShippingAddress();

    void createShippingAddress(ShippingAddressCreateUpdateDto addressDto);

    void updateShippingAddress(ShippingAddressCreateUpdateDto addressDto,Integer addressId);

    void disableShippingAddress(Integer id,Boolean enabled);

    ShippingAddressEntity findAddressByIdAndUser(Integer addressId, UserEntity user);
}
