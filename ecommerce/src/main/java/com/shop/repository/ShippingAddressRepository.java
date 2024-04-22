package com.shop.repository;

import com.shop.domain.entity.ShippingAddressEntity;
import com.shop.domain.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ShippingAddressRepository extends JpaRepository<ShippingAddressEntity, Integer> {
    List<ShippingAddressEntity> findAllByEnabledIsTrueAndUserIdEquals(Integer userId);

    Optional<ShippingAddressEntity> findByAddressLine1AndUser(String addressLine1, UserEntity user);

    Optional<ShippingAddressEntity> findByIdAndUser(Integer id, UserEntity user);
    Optional<ShippingAddressEntity> findByIdAndUserAndEnabledIsTrue(Integer id, UserEntity user);


    boolean existsByUserAndEnabledTrueAndAddressLine1AndIdNot(UserEntity user,String addressLine1,Integer addressId);
    Optional<ShippingAddressEntity> findByUserAndAddressLine1AndIdNot(UserEntity user,String addressLine1,Integer addressId);
}
